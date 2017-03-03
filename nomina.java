import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Choice;
import java.awt.event.MouseListener;

public class nomina extends Frame implements ActionListener, WindowListener, MouseListener{
  //Menú principal de nómina, con cuatro opciones de acciones por hacer (Registrar, Editar, Mostrar, Eliminar) 
  Label titulo,abajo,info,error,lfecha,lnom,lsucursal,lfechap,lsueldod,ldiast,limss,ltextra,lcomentarios,ldesc,
        lcuenta,lpuesto,lsueldo,derecha,izqa,dera, titulos, buscare,espaciob, tit, nbuscado,a,b,lnombreb,
   emplreg,nbuscadoe,titulom,totaln;
 JLabel logo;
 Panel empleados, información, abj, table,editt,abj1,mod,elimm,mode,medio;
 Button registrar, mostrar, buscar, modificar, eliminar, regresar, guardar,busc, conf, guardare,confi,borrare;
 JDialog registro, muestra,edit,editar,elim,eliminare;
 JTextField fecha, nom,sucursal,fechap,sueldod,diast,imss,textra,comentarios,desc,puesto,cuenta,sueldo, escribir, 
   nombreb,nombrebt,nombrebe;
 JScrollPane barra,barrab;
 RandomAccessFile nominaempleados;
 JTable tabla;
 DefaultTableModel model;
   String nombre, sfecha, ssucursal,sfechap, simms,stextra,scomentarios,sdesc,scuenta,spuesto,ssueldod, 
     sdiast,ssueldo,nnombre,buscado;
   Boolean existe, ya, esta;
   Double n;
   ImageIcon icono;
   Choice sucursalo,puestoo,textrao,desco,imsso, diasto;
  Color nuevo = new Color(255,200,15);  
  public static double nominat; 
  private double valor;
  
  public static void main (String[] args) throws IOException{
   nomina fr= new nomina();
   fr.setSize(1370,725);
   fr.setTitle("Mr.Brown");
   fr.setVisible(true);
   fr.setExtendedState(MAXIMIZED_BOTH);  
      }
  
   public nomina() throws IOException{ //Crea el menú principal con 4 botones
     setLayout(new BorderLayout());
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    add("North", titulo);
    abajo= new Label( "Nómina", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    add("South", abajo);
    empleados= new Panel();
    empleados.setLayout(null);
    registrar = new Button ("Registrar Empleado");
    registrar.setBackground(nuevo); 
    registrar.setBounds(475, 210, 165,75);
    registrar.setFont(new Font("Serif",3, 15));
    mostrar = new Button ("Mostrar lista de empleados");
    mostrar.setBackground(nuevo);
    mostrar.setBounds(695, 210, 165, 75);
    mostrar.setFont(new Font("Serif", 3, 13));
    modificar = new Button ("Editar/Buscar");
    modificar.setBackground(nuevo);
    modificar.setBounds(475, 305, 165, 75);
    modificar.setFont(new Font("Serif", 3, 19));
    eliminar = new Button ("Eliminar un empleado");
    eliminar.setBackground(nuevo);  
    eliminar.setBounds(695, 305, 165, 75);
    eliminar.setFont(new Font("Serif", 3, 15));
    regresar= new Button ("Regresar");
    regresar.setBackground(Color.black);
    regresar.setForeground(Color.orange);
    regresar.setFont(new Font("Serif",2, 16));
    regresar.setBounds(55, 510, 80, 50);    
    ImageIcon icono = new ImageIcon("mblogo2.png","logo de mr. brown");             
     logo= new JLabel(icono);
     logo.setBounds(1170,455,165,140);    
    empleados.add(registrar);
    empleados.add(mostrar);
    empleados.add(modificar);
    empleados.add(eliminar);
    empleados.add(regresar);
    empleados.add(logo);
    add("Center", empleados);        
    registrar.addActionListener(this);
    mostrar.addActionListener(this);
    modificar.addActionListener(this);
    eliminar.addActionListener(this);
    regresar.addActionListener(this);    
    addWindowListener(this);
    }
   
    public void actionPerformed(ActionEvent e){
      if(e.getSource()== mostrar)
        lista();
      if(e.getSource()== registrar)
      registrar();
      if(e.getSource()== modificar)
       modificar();
      if(e.getSource()== eliminar)
       eliminar();
      if(e.getSource()== guardar){
      guardar();
      fecha.setText("");       
      nom.setText("");
      diasto.select("");
      sucursalo.select("");
      puestoo.select("");
      desco.select("");
      textrao.select("");
      imsso.select("");
      cuenta.setText("");
      sueldod.setText("");
      fechap.setText("");
      comentarios.setText("");
       }
      if(e.getSource()==conf)
      editar();
      if(e.getSource()==regresar)
       this.setVisible(false);
      if(e.getSource()==guardare){
        editado();
        editar.dispose();
        edit.dispose();
      }
      if(e.getSource()==confi)
        borrar();       
      if(e.getSource()==borrare){
        eliminado();
        eliminare.dispose();
        elim.dispose();
      }
    }
    
    public void registrar(){ //Dialog para ingresar información de los empleados
       registro= new JDialog();
       registro.setSize(375,390);
       registro.setLocationRelativeTo(null);
       registro.setTitle("Registrar empleado");
       registro.setVisible(true);       
       registro.setLayout(new BorderLayout());
       información= new Panel();
       información.setLayout(new GridLayout(12,2));
       abj=new Panel();
       abj.setLayout(new BorderLayout());       
       lfecha= new Label("Fecha de contratación   ", Label.RIGHT);
       fecha= new JTextField();
       fecha.setText("dd/mm/aaaa");
       fecha.setForeground(Color.gray);
       fecha.setEditable(true);
       lnom= new Label("Nombre   ", Label.RIGHT);
       nom= new JTextField();
       nom.setEditable(true);
       lsucursal= new Label("Sucursal   ", Label.RIGHT); 
       sucursalo= new Choice();
       String opcsucursal[]={"","Garza Sada", "Otra Sucursal"};
       for(int i=0;i<opcsucursal.length;i++)
         sucursalo.add(opcsucursal[i]);           
       lpuesto= new Label("Puesto   ", Label.RIGHT);
       puestoo= new Choice();
       String opcpuesto[]={"","Mesero","Chef","Cocinero","Host","Gerente","Caja"};
       for(int i=0;i<opcpuesto.length;i++)
         puestoo.add(opcpuesto[i]);
       lcuenta= new Label("Cuenta   ", Label.RIGHT);
       cuenta= new JTextField();
       cuenta.setEditable(true);
       lsueldod= new Label("Sueldo Diario   ", Label.RIGHT);
       sueldod= new JTextField();
       sueldod.setEditable(true);
       ldiast= new Label("Días Trabajados   ", Label.RIGHT);
       diasto= new Choice();
       String opcdiast[]={"","1","2","3","4","5","6","7"};
       for(int i=0;i<opcdiast.length;i++)
       diasto.add(opcdiast[i]);
       lfechap= new Label("Fecha de Pago   ", Label.RIGHT);
       fechap= new JTextField();
       fechap.setEditable(true);
       lcomentarios= new Label("Comentarios   ", Label.RIGHT);
       comentarios= new JTextField();
       comentarios.setEditable(true);
       ldesc= new Label("Descuentos   ", Label.RIGHT);
       desco= new Choice();
       String opcdesc[]={"","Si","No"};
       for(int i=0;i<opcdesc.length;i++)
         desco.add(opcdesc[i]);
       ltextra= new Label("Tiempo Extra   ", Label.RIGHT);
       textrao= new Choice();
       String opctextra[]={"","Si","No"};
       for(int i=0;i<opctextra.length;i++)
         textrao.add(opctextra[i]);
       limss= new Label("IMSS   ", Label.RIGHT);
       imsso= new Choice();
       String opcimss[]={"","Si","No"};
       for(int i=0;i<opcimss.length;i++)
         imsso.add(opcimss[i]);
       info= new Label("Ingresar información del empleado", Label.CENTER);
       info.setFont(new Font("Serif", Font.BOLD, 13));
       info.setBackground(nuevo);
       info.setForeground(Color.black);
       guardar= new Button("Guardar");
       guardar.setBackground(nuevo);
       guardar.setForeground(Color.black);
       derecha= new Label();
       izqa=new Label("                                    ");
       dera=new Label("                                    ");       
       abj.add("West",izqa);
       abj.add("East",dera);
       abj.add("Center",guardar);
       registro.add("East",derecha);
       registro.add("North",info);
       información.add(lnom);
       información.add(nom);
       información.add(lfecha);
       información.add(fecha);
       información.add(lsucursal);
       información.add(sucursalo);
       información.add(lpuesto);
       información.add(puestoo);
       información.add(lcuenta);
       información.add(cuenta);
       información.add(lsueldod);
       información.add(sueldod);
       información.add(ldiast);
       información.add(diasto);
       información.add(lfechap);
       información.add(fechap);
       información.add(lcomentarios);
       información.add(comentarios);
       información.add(ldesc);
       información.add(desco);
       información.add(ltextra);
       información.add(textrao);
       información.add(limss);
       información.add(imsso);
       registro.add("South",abj);
       registro.add("Center", información);       
       fecha.addMouseListener(this);
       guardar.addActionListener(this);
       addWindowListener(this);
        }
    
     public void mouseClicked(MouseEvent e) {
       if(e.getSource()==fecha)
          fecha.setText("");
          }
          
    public void guardar(){ //guardar la info registrada en un archivo
    try {      
      RandomAccessFile nominaempleados=new RandomAccessFile ("empleadosmb.txt","rw");
   double osueldod=0.0; int odiast=0; double osueldo=0.0;
    osueldod=Double.parseDouble(sueldod.getText());
    odiast=Integer.parseInt(diasto.getSelectedItem());
    osueldo=osueldod*odiast;       
        sfecha=fecha.getText();
        nombre= nom.getText();
        ssucursal=sucursalo.getSelectedItem().toString();
        sfechap=fechap.getText();
        ssueldod=sueldod.getText();        
        sdiast=diasto.getSelectedItem().toString();
        ssueldo=String.valueOf(osueldo);
        simms=imsso.getSelectedItem().toString();
        stextra=textrao.getSelectedItem().toString();
        scomentarios=comentarios.getText();
        sdesc=desco.getSelectedItem().toString();
        scuenta=cuenta.getText();
        spuesto=puestoo.getSelectedItem().toString();                
        if (sfecha.length()<10) {  
              for (int f=sfecha.length(); f<10;f++)  
             sfecha=sfecha + " "; } 
        else 
          sfecha=sfecha.substring(0,10);
        
        if (nombre.length()<35) {  
              for (int n=nombre.length(); n<35;n++)  
             nombre=nombre + " ";  } 
        else 
          nombre=nombre.substring(0,35); 
        
        if (ssucursal.length()<18) {  
              for (int s=ssucursal.length(); s<18;s++)  
             ssucursal=ssucursal + " "; } 
        else 
          ssucursal=ssucursal.substring(0,18);
        
        if (spuesto.length()<11) {  
              for (int p=spuesto.length(); p<11;p++)  
             spuesto=spuesto + " ";   } 
        else 
          spuesto=spuesto.substring(0,11);
        
        if (scuenta.length()<10) {  
              for (int c=scuenta.length(); c<10;c++)  
             scuenta=scuenta + " ";  } 
        else 
          scuenta=scuenta.substring(0,10);
        
        if(ssueldod.length()<6){
          for (int sd=ssueldod.length(); sd<6;sd++)
            ssueldod=ssueldod+" "; }
        else 
          ssueldod=ssueldod.substring(0,6);
        
         if(sdiast.length()<1){
          for (int dt=sdiast.length(); dt<1;dt++)
            sdiast=sdiast+" "; }
        else 
          sdiast=sdiast.substring(0,1);
        
         if(ssueldo.length()<8){
          for (int sf=ssueldo.length(); sf<8;sf++)
            ssueldo=ssueldo+" ";  }
        else 
          ssueldo=ssueldo.substring(0,8);
        
         if (sfechap.length()<10) {  
              for (int f2=sfechap.length(); f2<10;f2++)  
                sfechap=sfechap + " "; } 
        else 
          sfechap=sfechap.substring(0,10);
        
        if (scomentarios.length()<25) {  
              for (int c2=scomentarios.length(); c2<25;c2++)  
             scomentarios=scomentarios + " ";  } 
        else 
          scomentarios=scomentarios.substring(0,25);
        
        if (sdesc.length()<2) {  
              for (int d2=sdesc.length(); d2<2;d2++)  
             sdesc=sdesc + " "; } 
        else 
          sdesc=sdesc.substring(0,2);
        
        if (stextra.length()<2) {  
              for (int t=stextra.length(); t<2;t++)  
             stextra=stextra + " ";  } 
        else 
          stextra=stextra.substring(0,2);
        
        if (simms.length()<2) {  
              for (int i=simms.length(); i<2;i++)  
             simms=simms + " ";  } 
        else 
          simms=simms.substring(0,2);
          
        if (nominaempleados.length()!=0) 
             nominaempleados.seek(nominaempleados.length()); 
             nominaempleados.writeChars(sfecha);
             nominaempleados.writeChars(nombre); 
             nominaempleados.writeChars(ssucursal);
             nominaempleados.writeChars(spuesto);
             nominaempleados.writeChars(scuenta);
             nominaempleados.writeChars(ssueldod);
             nominaempleados.writeChars(sdiast);
             nominaempleados.writeChars(ssueldo);
             nominaempleados.writeChars(sfechap);
             nominaempleados.writeChars(scomentarios);
             nominaempleados.writeChars(sdesc);
             nominaempleados.writeChars(stextra);
             nominaempleados.writeChars(simms);
             nominaempleados.writeBoolean(true);
             nominaempleados.close();
          }catch(IOException e) 
          {
           error= new Label("Error: archivo no encontrado");
           información.add(error);
        } }
                       
      public void lista(){ //Muestra una lista de los empleados registrados y sus datos
        muestra= new JDialog();
        muestra.setSize(1100,450);
        muestra.setLocationRelativeTo(null);
        muestra.setTitle("Lista de empleados");
        muestra.setVisible(true);   
         titulom=new Label("Mr.Brown", Label.CENTER);
        titulom.setFont(new Font("Serif", Font.BOLD, 35));
        titulom.setBackground(Color.orange);
        titulom.setForeground(Color.black);
         model= new DefaultTableModel();
         model.addColumn("Fecha");
         model.addColumn("Nombre");
         model.addColumn("Sucursal");
         model.addColumn("Puesto");
         model.addColumn("Cuenta");
         model.addColumn("Sueldo Diario");
         model.addColumn("D. Trabajados");
         model.addColumn("Sueldo");
         model.addColumn("Fecha de Pago");
         model.addColumn("Comentarios");
         model.addColumn("Descuentos");
         model.addColumn("T. Extra");
         model.addColumn("IMSS");       
       try{
          RandomAccessFile nominaempleados=new RandomAccessFile ("empleadosmb.txt","rw");
        long tamRegistro=281; 
        long cantRegistros=0; 
        String nombre=""; String sfecha="";String ssucursal="";String sfechap="";String simms="";
        String stextra="";String scomentarios="";String sdesc="";String scuenta="";String spuesto="";
        String ssueldod=""; String sdiast=""; String ssueldo="";        
        cantRegistros=nominaempleados.length()/tamRegistro;        
         for (int registro=0;registro<cantRegistros; registro ++) {
           nominaempleados.seek(registro*tamRegistro); 
          for(int j=0; j<10;j++) 
              sfecha=sfecha + nominaempleados.readChar();
         for(int j=0; j<35;j++) 
              nombre=nombre + nominaempleados.readChar();
        for(int j=0; j<18;j++) 
              ssucursal=ssucursal + nominaempleados.readChar();
        for(int j=0; j<11;j++) 
              spuesto=spuesto + nominaempleados.readChar();
        for(int j=0; j<10;j++) 
              scuenta=scuenta + nominaempleados.readChar();
        for(int j=0; j<6;j++)
              ssueldod=ssueldod + nominaempleados.readChar();
        for(int j=0; j<1; j++)
              sdiast=sdiast + nominaempleados.readChar();
        for(int j=0; j<8; j++)
              ssueldo=ssueldo + nominaempleados.readChar();
        for(int j=0; j<10;j++) 
              sfechap=sfechap + nominaempleados.readChar();          
        for(int j=0; j<25;j++) 
              scomentarios=scomentarios + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              sdesc=sdesc + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              stextra=stextra + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              simms= simms+ nominaempleados.readChar();    
        esta=nominaempleados.readBoolean();        
        if(esta==true){
        String[] fila={sfecha,nombre,ssucursal,spuesto,scuenta,ssueldod,sdiast,ssueldo,sfechap,scomentarios,sdesc,stextra,simms}; 
        model.addRow(fila);}        
        nombre=""; sfecha=""; ssucursal="";sfechap=""; simms="";stextra="";scomentarios="";
        sdesc="";scuenta="";spuesto=""; ssueldod=""; ssueldo=""; sdiast="";
        }
        nominaempleados.close();
        nominat=0.0;
         for(int i=0;i<model.getRowCount();i++){  
           n=Double.parseDouble(model.getValueAt(i,7).toString());
        nominat=nominat+n;}                       
        }catch(IOException e) {
           error= new Label("Error: archivo no encontrado");
           muestra.add(error);}//Evita un error al abrir el archivo                
      medio=new Panel(new BorderLayout());
       emplreg=new Label("Cantidad de empleados Registrados: "+ model.getRowCount(), Label.CENTER);
       emplreg.setBackground(Color.orange);
       emplreg.setForeground(Color.black);
        tabla= new JTable(model);       
     tabla.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     tabla.getTableHeader().setBackground(Color.black); 
     tabla.getTableHeader().setForeground(Color.orange);
     tabla.setEnabled(false);
           int ancho[]={8,135,25,15,20,10,10,10,25,30,2,2,2};
         for(int i=0;i<model.getColumnCount();i++)
           tabla.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);              
     totaln= new Label("Total de la nómina: $"+nominat, Label.RIGHT);
      totaln.setFont(new Font("Serif", 1, 14));     
     barra = new JScrollPane();
     barra.setViewportView (tabla);
        medio.add("Center",barra);
        medio.add("South", totaln);
        muestra.add("Center",medio);
        muestra.add("North",titulom);
        muestra.add("South",emplreg);
        }
        
        public double getValor(){
        valor=nominat; 
        return valor;       
      }
            
      public void modificar(){ //Dialog para insertar el nombre del empleado a buscar
        edit= new JDialog();
        edit.setSize(650,120);
        edit.setLocationRelativeTo(null);
        edit.setTitle("Buscador de empleados");
        edit.setVisible(true);
        edit.setLayout(new BorderLayout());
        editt= new Panel();
        editt.setLayout(new FlowLayout());        
        nbuscado= new Label("Nombre del empleado a buscar");
        nombreb= new JTextField(23);
        conf= new Button("Confirmar");                
        a= new Label("Mr.Brown", Label.CENTER);
        a.setFont(new Font("Serif", Font.BOLD, 18));
        a.setBackground(nuevo);
        a.setForeground(Color.black);
        b= new Label();
        b.setBackground(nuevo);        
        editt.add(nbuscado);
        editt.add(nombreb);
        editt.add(conf);        
        conf.addActionListener(this);
        addWindowListener(this);        
        edit.add("Center",editt);
        edit.add("North",a);
        edit.add("South",b);
         }      
      
      public void editar(){ //Dialog donde aparece la información del empleado buscado, la cual es editable
       editar= new JDialog();
       editar.setSize(375,390);
       editar.setLocationRelativeTo(null);
       editar.setTitle("Editar empleado");
       editar.setVisible(true);
       editar.setLayout(new BorderLayout());
       mod= new Panel();
       mod.setLayout(new GridLayout(13,2));
       abj1=new Panel();
       abj1.setLayout(new BorderLayout());
       lfecha= new Label("Fecha de contratación   ", Label.RIGHT);
       fecha= new JTextField();
       fecha.setEditable(true);
       lnom= new Label("Nombre   ", Label.RIGHT);
       nom= new JTextField();
       nom.setEditable(true);
       lsucursal= new Label("Sucursal   ", Label.RIGHT); 
       sucursalo= new Choice();
       String opcsucursal[]={"","Garza Sada        ", "Otra Sucursal     "};
       for(int i=0;i<opcsucursal.length;i++)
         sucursalo.add(opcsucursal[i]);  
       lpuesto= new Label("Puesto   ", Label.RIGHT);
       puestoo= new Choice();
       String opcpuesto[]={"","Mesero     ", "Chef       ","Cocinero   ","Host       ","Gerente    ","Caja       "};
       for(int i=0;i<opcpuesto.length;i++)
         puestoo.add(opcpuesto[i]);  
       lcuenta= new Label("Cuenta   ", Label.RIGHT);
       cuenta= new JTextField();
       cuenta.setEditable(true);
       lsueldod= new Label("Sueldo Diario   ", Label.RIGHT);
       sueldod= new JTextField();
       sueldod.setEditable(true);
       ldiast= new Label("Días Trabajados   ", Label.RIGHT);
       diasto= new Choice();
       String opcdiast[]={"","1","2","3","4","5","6","7"};
       for(int i=0;i<opcdiast.length;i++)
         diasto.add(opcdiast[i]);  
       lfechap= new Label("Fecha de Pago   ", Label.RIGHT);
       fechap= new JTextField();
       fechap.setEditable(true);
       lcomentarios= new Label("Comentarios   ", Label.RIGHT);
       comentarios= new JTextField();
       comentarios.setEditable(true);
       ldesc= new Label("Descuentos   ", Label.RIGHT);
       desco= new Choice();
       String opcdesc[]={"","Si","No"};
       for(int i=0;i<opcdesc.length;i++)
         desco.add(opcdesc[i]);  
       ltextra= new Label("Tiempo Extra   ", Label.RIGHT);
       textrao= new Choice();
       String opctextra[]={"","Si","No"};
       for(int i=0;i<opctextra.length;i++)
         textrao.add(opctextra[i]);  
       limss= new Label("IMSS   ", Label.RIGHT);
       imsso= new Choice();
       String opcimss[]={"","Si","No"};
       for(int i=0;i<opcimss.length;i++)
         imsso.add(opcimss[i]);  
       lnombreb=new Label("Nombre buscado:   ", Label.RIGHT);
       nombrebt=new JTextField();
       nombrebt.setEditable(false);
       info= new Label("Editar información del empleado", Label.CENTER);
       info.setFont(new Font("Serif", Font.BOLD, 13));
       info.setBackground(nuevo);
       info.setForeground(Color.black);
       guardare= new Button("Editar");
       guardare.setBackground(nuevo);
       guardare.setForeground(Color.black);
       derecha= new Label();
       izqa=new Label("                                    ");
       dera=new Label("                                    ");       
       int registro=0;long tamRegistro=281;long cantRegistros=0; nnombre=""; existe=false;
       buscado=nombreb.getText();
       try{ 
            RandomAccessFile nominaempleados=new RandomAccessFile("empleadosmb.txt","rw"); 
            cantRegistros=nominaempleados.length()/tamRegistro;
         
           while((registro < cantRegistros) && existe==false) { 
              nominaempleados.seek((registro*tamRegistro)+20);
              for(int i=0;i<35;i++)
                nnombre=nnombre + nominaempleados.readChar(); 
              buscado=buscado.trim();
              nnombre=nnombre.trim();
             if (nnombre.equalsIgnoreCase(buscado)){
               existe=true;             
             nominaempleados.seek(registro*tamRegistro); 
          for(int sf=0; sf<10;sf++) 
              sfecha=sfecha + nominaempleados.readChar();
         for(int n=0; n<35;n++) 
              nombre=nombre + nominaempleados.readChar();
        for(int j=0; j<18;j++) 
              ssucursal=ssucursal + nominaempleados.readChar();
        for(int j=0; j<11;j++) 
              spuesto=spuesto + nominaempleados.readChar();
        for(int j=0; j<10;j++) 
              scuenta=scuenta + nominaempleados.readChar();
        for(int j=0; j<6;j++)
              ssueldod=ssueldod + nominaempleados.readChar();
        for(int j=0; j<1; j++)
              sdiast=sdiast + nominaempleados.readChar();
        for(int j=0; j<8; j++)
              ssueldo=ssueldo + nominaempleados.readChar();
        for(int j=0; j<10;j++) 
              sfechap=sfechap + nominaempleados.readChar();          
        for(int j=0; j<25;j++) 
              scomentarios=scomentarios + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              sdesc=sdesc + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              stextra=stextra + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              simms= simms+ nominaempleados.readChar();            
                sfecha.substring(0,10);
                nombre.substring(0,35);
                ssucursal.substring(0,18);
                spuesto.substring(0,11);
                scuenta.substring(0,10);
                ssueldod.substring(0,6);
                sdiast.substring(0,1);
                ssueldo.substring(0,8);
                sfechap.substring(0,10);
                scomentarios.substring(0,25);
                sdesc.substring(0,2);
                stextra.substring(0,2);
                simms.substring(0,2);                                
                fecha.setText(sfecha);
                nom.setText(nombre);
                sucursalo.select(ssucursal);
                puestoo.select(spuesto);
                cuenta.setText(scuenta);
                sueldod.setText(ssueldod);
                diasto.select(sdiast);
                fechap.setText(sfechap);
                comentarios.setText(scomentarios);
                desco.select(sdesc);
                textrao.select(stextra);
                imsso.select(simms);
                nombrebt.setText(buscado);
           } else {fecha.setText("-");
                nom.setText("Empleado no encontrado");
                sucursalo.select("");
                puestoo.select("");
                cuenta.setText("-");
                sueldod.setText("-");
                diasto.select("");
                fechap.setText("-");
                comentarios.setText("-");
                desco.select("");
                textrao.select("");
                imsso.select("");
                nombrebt.setText(buscado);
                    registro++;                          
           nnombre="";}         
              nnombre=""; nombre=""; sfecha=""; ssucursal="";sfechap=""; simms="";stextra="";scomentarios="";
                 sdesc="";scuenta="";spuesto=""; ssueldod=""; ssueldo=""; sdiast=""; 
                }
              nominaempleados.close(); 
          } catch(IOException e) 
          {error= new Label("Error: archivo no encontrado");
           muestra.add(error);}                
       abj1.add("West",izqa);
       abj1.add("East",dera);
       abj1.add("Center",guardare);
       editar.add("East",derecha);
       editar.add("North",info);
       mod.add(lnom);
       mod.add(nom);      
       mod.add(lfecha);
       mod.add(fecha);
       mod.add(lsucursal);
       mod.add(sucursalo);
       mod.add(lpuesto);
       mod.add(puestoo);
       mod.add(lcuenta);
       mod.add(cuenta);
       mod.add(lsueldod);
       mod.add(sueldod);
       mod.add(ldiast);
       mod.add(diasto);
       mod.add(lfechap);
       mod.add(fechap);
       mod.add(lcomentarios);
       mod.add(comentarios);
       mod.add(ldesc);
       mod.add(desco);
       mod.add(ltextra);
       mod.add(textrao);
       mod.add(limss);
       mod.add(imsso);
       mod.add(lnombreb);
       mod.add(nombrebt);
       editar.add("South",abj1);
       editar.add("Center", mod);        
       guardare.addActionListener(this);
       addWindowListener(this);
      }
      
      public void editado(){ //Guarda la información editada en el archivo de texto 
        try{
          RandomAccessFile nominaempleados=new RandomAccessFile ("empleadosmb.txt","rw");       
        String nombree=""; String sfechae="";String ssucursale="";String sfechape="";String simmse="";
        String stextrae="";String scomentariose="";String sdesce="";String scuentae="";String spuestoe="";
        String ssueldode=""; String sdiaste=""; String ssueldoe="";  String abuscar=""; String nnombre2="";                   
     int registro=0;long tamRegistro=281; long cantRegistros=0; double osueldod=0.0; int odiast=0; 
     double osueldo=0.0; boolean modificado=false;
    osueldod=Double.parseDouble(sueldod.getText());
    odiast=Integer.parseInt(diasto.getSelectedItem().toString());
    osueldo=osueldod*odiast;
     cantRegistros=nominaempleados.length()/tamRegistro;     
                abuscar=nombrebt.getText();      
                sfechae=fecha.getText();
                nombree= nom.getText();
                ssucursale=sucursalo.getSelectedItem();
                sfechape=fechap.getText();
                ssueldode=sueldod.getText();        
                sdiaste=diasto.getSelectedItem();
                ssueldoe=String.valueOf(osueldo);
                simmse=imsso.getSelectedItem();
                stextrae=textrao.getSelectedItem();
                scomentariose=comentarios.getText();
                sdesce=desco.getSelectedItem();
                scuentae=cuenta.getText();
                spuestoe=puestoo.getSelectedItem(); 
            if (sfechae.length()<10) {  
              for (int f=sfechae.length(); f<10;f++)  
             sfechae=sfechae + " ";     } 
        else 
          sfechae=sfechae.substring(0,10);
        
        if (nombree.length()<35) {  
              for (int n=nombree.length(); n<35;n++)  
             nombree=nombree + " ";    } 
        else 
          nombree=nombree.substring(0,35); 
        
        if (ssucursale.length()<18) {  
              for (int s=ssucursale.length(); s<18;s++)  
             ssucursale=ssucursale + " "; } 
        else 
          ssucursale=ssucursale.substring(0,18);
        
        if (spuestoe.length()<11) {  
              for (int p=spuestoe.length(); p<11;p++)  
                spuestoe=spuestoe + " "; }
        else 
          spuestoe=spuestoe.substring(0,11);
        
        if (scuentae.length()<10) {  
              for (int c=scuentae.length(); c<10;c++)  
             scuentae=scuentae + " "; } 
        else 
          scuentae=scuentae.substring(0,10);
        
        if(ssueldode.length()<6){
          for (int sd=ssueldode.length(); sd<6;sd++)
            ssueldode=ssueldode+" "; }
        else 
          ssueldode=ssueldode.substring(0,6);
        
         if(sdiaste.length()<1){
          for (int dt=sdiaste.length(); dt<1;dt++)
            sdiaste=sdiaste+" ";   }
        else 
          sdiaste=sdiaste.substring(0,1);
        
         if(ssueldoe.length()<8){
          for (int sf=ssueldoe.length(); sf<8;sf++)
            ssueldoe=ssueldoe+" "; }
        else 
          ssueldoe=ssueldoe.substring(0,8);
        
         if (sfechape.length()<10) {  
              for (int f2=sfechape.length(); f2<10;f2++)  
             sfechape=sfechape + " ";  } 
        else 
          sfechape=sfechape.substring(0,10);
        
        if (scomentariose.length()<25) {  
              for (int c2=scomentariose.length(); c2<25;c2++)  
             scomentariose=scomentariose + " ";  } 
        else 
          scomentariose=scomentariose.substring(0,25);
        
        if (sdesce.length()<2) {  
              for (int d2=sdesce.length(); d2<2;d2++)  
             sdesce=sdesce + " "; } 
        else 
          sdesce=sdesce.substring(0,2);
        
        if (stextrae.length()<2) {  
              for (int t=stextrae.length(); t<2;t++)  
             stextrae=stextrae + " "; } 
        else 
          stextrae=stextrae.substring(0,2);
        
        if (simmse.length()<2) {  
              for (int i=simmse.length(); i<2;i++)  
             simmse=simmse + " "; } 
        else 
          simmse=simmse.substring(0,2);                      
     while(registro < cantRegistros && modificado==false){
            nominaempleados.seek(registro*tamRegistro+20); 
        for(int i=0;i<35;i++)
            nnombre2=nnombre2 + nominaempleados.readChar();                                         
              nnombre2=nnombre2.trim();
              abuscar=abuscar.trim();                   
              if(abuscar.equalsIgnoreCase(nnombre2)){    
                modificado=true;
             nominaempleados.seek(registro*tamRegistro); 
             nominaempleados.writeChars(sfechae);
             nominaempleados.writeChars(nombree); 
             nominaempleados.writeChars(ssucursale);
             nominaempleados.writeChars(spuestoe);
             nominaempleados.writeChars(scuentae);
             nominaempleados.writeChars(ssueldode);
             nominaempleados.writeChars(sdiaste);
             nominaempleados.writeChars(ssueldoe);
             nominaempleados.writeChars(sfechape);
             nominaempleados.writeChars(scomentariose);
             nominaempleados.writeChars(sdesce);
             nominaempleados.writeChars(stextrae);
             nominaempleados.writeChars(simmse);
             nominaempleados.close();         }
              else{
              registro++;
              nnombre2="";}
                }                
        }catch(IOException e) 
          {error= new Label("Error: archivo no encontrado");
           muestra.add(error);}        
        }
      
       public void eliminar(){ //Dialog para insertar el nombre del empleado a eliminar
        elim= new JDialog();
        elim.setSize(650,120);
        elim.setLocationRelativeTo(null);
        elim.setTitle("Buscador de empleados");
        elim.setVisible(true);
        elim.setLayout(new BorderLayout());
        elimm= new Panel();
        elimm.setLayout(new FlowLayout());        
        nbuscadoe= new Label("Nombre del empleado a eliminar");
        nombrebe= new JTextField(23);
        confi= new Button("Confirmar");                
        a= new Label("Mr.Brown", Label.CENTER);
        a.setFont(new Font("Serif", Font.BOLD, 18));
        a.setBackground(nuevo);
        a.setForeground(Color.black);
        b= new Label();
        b.setBackground(nuevo);        
        elimm.add(nbuscadoe);
        elimm.add(nombrebe);
        elimm.add(confi);        
        confi.addActionListener(this);
        addWindowListener(this);        
        elim.add("Center",elimm);
        elim.add("North",a);
        elim.add("South",b);
         }      
      
      public void borrar(){ //Dialog donde aparece la información del empleado buscado, la cual es editable
       eliminare= new JDialog();
       eliminare.setSize(375,390);
       eliminare.setLocationRelativeTo(null);
       eliminare.setTitle("Eliminar empleado");
       eliminare.setVisible(true);
       eliminare.setLayout(new BorderLayout());
       mode= new Panel();
       mode.setLayout(new GridLayout(13,2));
       abj1=new Panel();
       abj1.setLayout(new BorderLayout());
       lfecha= new Label("Fecha de contratación   ", Label.RIGHT);
       fecha= new JTextField();
       fecha.setEditable(true);
       lnom= new Label("Nombre   ", Label.RIGHT);
       nom= new JTextField();
       nom.setEditable(true);
       lsucursal= new Label("Sucursal   ", Label.RIGHT); 
       sucursalo= new Choice();
       String opcsucursal[]={"","Garza Sada        ", "Otra Sucursal     "};
       for(int i=0;i<opcsucursal.length;i++)
         sucursalo.add(opcsucursal[i]);  
       lpuesto= new Label("Puesto   ", Label.RIGHT);
       puestoo= new Choice();
       String opcpuesto[]={"","Mesero     ","Chef       ","Cocinero   ","Host       ","Gerente    ","Caja       "};
       for(int i=0;i<opcpuesto.length;i++)
         puestoo.add(opcpuesto[i]);  
       lcuenta= new Label("Cuenta   ", Label.RIGHT);
       cuenta= new JTextField();
       cuenta.setEditable(true);
       lsueldod= new Label("Sueldo Diario   ", Label.RIGHT);
       sueldod= new JTextField();
       sueldod.setEditable(true);
       ldiast= new Label("Días Trabajados   ", Label.RIGHT);
       diasto= new Choice();
       String opcdiast[]={"","1","2","3","4","5","6","7"};
       for(int i=0;i<opcdiast.length;i++)
         diasto.add(opcdiast[i]);  
       lfechap= new Label("Fecha de Pago   ", Label.RIGHT);
       fechap= new JTextField();
       fechap.setEditable(true);
       lcomentarios= new Label("Comentarios   ", Label.RIGHT);
       comentarios= new JTextField();
       comentarios.setEditable(true);
       ldesc= new Label("Descuentos   ", Label.RIGHT);
       desco= new Choice();
       String opcdesc[]={"","Si","No"};
       for(int i=0;i<opcdesc.length;i++)
         desco.add(opcdesc[i]);  
       ltextra= new Label("Tiempo Extra   ", Label.RIGHT);
       textrao= new Choice();
       String opctextra[]={"","Si","No"};
       for(int i=0;i<opctextra.length;i++)
         textrao.add(opctextra[i]);  
       limss= new Label("IMSS   ", Label.RIGHT);
       imsso= new Choice();
       String opcimss[]={"","Si","No"};
       for(int i=0;i<opcimss.length;i++)
         imsso.add(opcimss[i]);  
       lnombreb=new Label("Nombre buscado:   ", Label.RIGHT);
       nombrebt=new JTextField();
       nombrebt.setEditable(false);
       info= new Label("Información del empleado a eliminar", Label.CENTER);
       info.setFont(new Font("Serif", Font.BOLD, 13));
       info.setBackground(nuevo);
       info.setForeground(Color.black);
       borrare= new Button("Eliminar");
       borrare.setBackground(nuevo);
       borrare.setForeground(Color.black);
       derecha= new Label();
       izqa=new Label("                                    ");
       dera=new Label("                                    ");       
       int registro=0;long tamRegistro=281;long cantRegistros=0; nnombre=""; existe=false;
       buscado=nombrebe.getText();
       try{ 
            RandomAccessFile nominaempleados=new RandomAccessFile("empleadosmb.txt","rw"); 
            cantRegistros=nominaempleados.length()/tamRegistro;
         
           while((registro < cantRegistros) && existe==false) { 
              nominaempleados.seek((registro*tamRegistro)+20);
              for(int i=0;i<35;i++)
                nnombre=nnombre + nominaempleados.readChar(); 
              buscado=buscado.trim();
              nnombre=nnombre.trim();
             if (nnombre.equalsIgnoreCase(buscado)){
               existe=true;             
             nominaempleados.seek(registro*tamRegistro); 
          for(int sf=0; sf<10;sf++) 
              sfecha=sfecha + nominaempleados.readChar();
         for(int n=0; n<35;n++) 
              nombre=nombre + nominaempleados.readChar();
        for(int j=0; j<18;j++) 
              ssucursal=ssucursal + nominaempleados.readChar();
        for(int j=0; j<11;j++) 
              spuesto=spuesto + nominaempleados.readChar();
        for(int j=0; j<10;j++) 
              scuenta=scuenta + nominaempleados.readChar();
        for(int j=0; j<6;j++)
              ssueldod=ssueldod + nominaempleados.readChar();
        for(int j=0; j<1; j++)
              sdiast=sdiast + nominaempleados.readChar();
        for(int j=0; j<8; j++)
              ssueldo=ssueldo + nominaempleados.readChar();
        for(int j=0; j<10;j++) 
              sfechap=sfechap + nominaempleados.readChar();          
        for(int j=0; j<25;j++) 
              scomentarios=scomentarios + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              sdesc=sdesc + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              stextra=stextra + nominaempleados.readChar();
        for(int j=0; j<2;j++) 
              simms= simms+ nominaempleados.readChar();            
                sfecha.substring(0,10);
                nombre.substring(0,35);
                ssucursal.substring(0,18);
                spuesto.substring(0,11);
                scuenta.substring(0,10);
                ssueldod.substring(0,6);
                sdiast.substring(0,1);
                ssueldo.substring(0,8);
                sfechap.substring(0,10);
                scomentarios.substring(0,25);
                sdesc.substring(0,2);
                stextra.substring(0,2);
                simms.substring(0,2);                                
                fecha.setText(sfecha);
                nom.setText(nombre);
                sucursalo.select(ssucursal);
                puestoo.select(spuesto);
                cuenta.setText(scuenta);
                sueldod.setText(ssueldod);
                diasto.select(sdiast);
                fechap.setText(sfechap);
                comentarios.setText(scomentarios);
                desco.select(sdesc);
                textrao.select(stextra);
                imsso.select(simms);
                nombrebt.setText(buscado);
           } else {fecha.setText("-");
                nom.setText("Empleado no encontrado" );
                sucursalo.select("");
                puestoo.select("");
                cuenta.setText("-");
                sueldod.setText("-");
                diasto.select("");
                fechap.setText("-");
                comentarios.setText("-");
                desco.select("");
                textrao.select("");
                imsso.select("");
                nombrebt.setText(buscado);
                    registro++;                          
           nnombre="";}         
              nnombre=""; nombre=""; sfecha=""; ssucursal="";sfechap=""; simms="";stextra="";scomentarios="";
                 sdesc="";scuenta="";spuesto=""; ssueldod=""; ssueldo=""; sdiast=""; 
                }
              nominaempleados.close(); 
          } catch(IOException e) 
          {error= new Label("Error: archivo no encontrado");
           muestra.add(error);}                
       abj1.add("West",izqa);
       abj1.add("East",dera);
       abj1.add("Center",borrare);
       eliminare.add("East",derecha);
       eliminare.add("North",info);
       mode.add(lnom);
       mode.add(nom);      
       mode.add(lfecha);
       mode.add(fecha);
       mode.add(lsucursal);
       mode.add(sucursalo);
       mode.add(lpuesto);
       mode.add(puestoo);
       mode.add(lcuenta);
       mode.add(cuenta);
       mode.add(lsueldod);
       mode.add(sueldod);
       mode.add(ldiast);
       mode.add(diasto);
       mode.add(lfechap);
       mode.add(fechap);
       mode.add(lcomentarios);
       mode.add(comentarios);
       mode.add(ldesc);
       mode.add(desco);
       mode.add(ltextra);
       mode.add(textrao);
       mode.add(limss);
       mode.add(imsso);
       mode.add(lnombreb);
       mode.add(nombrebt);
       eliminare.add("South",abj1);
       eliminare.add("Center", mode);        
       borrare.addActionListener(this);
       addWindowListener(this);
      }
      
      public void eliminado(){ //Borra la información del empleado buscado
        try{
          RandomAccessFile nominaempleados=new RandomAccessFile ("empleadosmb.txt","rw");         
        String nombree=""; String sfechae="";String ssucursale="";String sfechape="";String simmse="";
        String stextrae="";String scomentariose="";String sdesce="";String scuentae="";String spuestoe="";
        String ssueldode=""; String sdiaste=""; String ssueldoe="";  String abuscar=""; String nnombre2="";                   
     int registro=0;long tamRegistro=281; long cantRegistros=0; boolean modificado=false;    
     cantRegistros=nominaempleados.length()/tamRegistro;        
     abuscar=nombrebt.getText();      
                sfechae=fecha.getText();
                nombree= nom.getText();
                ssucursale=sucursalo.getSelectedItem();
                sfechape=fechap.getText();
                ssueldode=sueldod.getText();        
                sdiaste=diasto.getSelectedItem();
                simmse=imsso.getSelectedItem();
                stextrae=textrao.getSelectedItem();
                scomentariose=comentarios.getText();
                sdesce=desco.getSelectedItem();
                scuentae=cuenta.getText();
                spuestoe=puestoo.getSelectedItem();                                                   
     while(registro < cantRegistros && modificado==false){
            nominaempleados.seek(registro*tamRegistro+20); 
        for(int i=0;i<35;i++)
            nnombre2=nnombre2 + nominaempleados.readChar();                                         
              nnombre2=nnombre2.trim();
              abuscar=abuscar.trim();                   
              if(abuscar.equalsIgnoreCase(nnombre2)){    
                modificado=true;
             nominaempleados.seek(registro*tamRegistro+280); 
             nominaempleados.writeBoolean(false);   
              nominaempleados.close();         }
              else{
              registro++;
              nnombre2="";}
                }        
        }catch(IOException e) 
          {error= new Label("Error: archivo no encontrado");
           muestra.add(error);}   
        }
      
   public void windowClosing(WindowEvent e){
    System.exit(0);  }
   public void  windowActivated(WindowEvent e){}
   public void windowClosed(WindowEvent e){}
   public void windowDeactivated(WindowEvent e){}
   public void windowDeiconified(WindowEvent e){}
   public void windowIconified(WindowEvent e){}
   public void windowOpened(WindowEvent e){}
   public void mousePressed(MouseEvent e){}
   public void mouseEntered(MouseEvent e){}
   public void mouseExited(MouseEvent e){}
   public void mouseReleased(MouseEvent e){}
 }