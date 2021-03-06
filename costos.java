import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class costos extends Frame implements ActionListener, WindowListener{  
  //MENU DE COSTOS, incluye el bot�n de ingredientes, recetas y sub-recetas
  Button ing, recetas, subrecetas, regresar,sr1,sr2,sr3,sr4,sr5,sr6,sr7,sr8,sr9, 
           back,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12;
 Label titulo, abajo,srtitulo, srabajo,rtitulo, rabajo, titulor, abajor, totalingr;
 Panel botones,srbotones, sratras,rbotones, atras, centro;
 JDialog ingredientes, drecetas,rec,rec2,rec3,rec4,rec5,rec6,rec7,rec8,rec9,rec10,rec11,rec12,
         subr1,subr2,subr3,subr4,subr5,subr6,subr7,subr8,subr9, dsubrecetas;
 JScrollPane scroll,srscroll,rscroll;
 JTable table,srtable,rtable;
 ImageIcon icono;
 JLabel logo;
 DefaultTableModel ingr;
 Color nuevo=new Color(255,200,15);
 Double in; 
public static double totali; 
  private double valor2;
 
    public static void main (String[] args) throws IOException{
   costos fr= new costos ();
   fr.setSize(1370,725);
   fr.setTitle("Mr.Brown");
   fr.setVisible(true);
   fr.setExtendedState(MAXIMIZED_BOTH);
      }
  
   public costos() throws IOException{ //Crea el men� de costos, donde hay tres opciones: Ingredientes, Recetas y Sub-recetas
     setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    add("North", titulo);    
    abajo= new Label( "Costos", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    add("South", abajo);    
    botones= new Panel();
    botones.setLayout(null);
    ing = new Button ("Ingredientes Individuales");
    ing.setBackground(nuevo); 
    ing.setBounds(275, 250, 193,75);
    ing.setFont(new Font("Serif",2, 18));
    recetas = new Button ("Recetas");
    recetas.setBackground(nuevo);
    recetas.setBounds(865,250,185,75);
    recetas.setFont(new Font("Serif",2, 25));
    subrecetas = new Button ("Sub-Recetas");
    subrecetas.setBackground(nuevo);
    subrecetas.setBounds(575,250,185,75);
    subrecetas.setFont(new Font("Serif", 2, 25));    
    regresar= new Button ("Regresar");
    regresar.setBackground(Color.black);
    regresar.setForeground(nuevo);
    regresar.setFont(new Font("Serif",2, 16));
    regresar.setBounds(55, 510, 80, 50);    
    ImageIcon icono = new ImageIcon("mblogo2.png","logo de mr. brown");
     logo= new JLabel(icono);
     logo.setBounds(1170,455,165,140);    
    botones.add(logo);
    botones.add(ing);
    botones.add(recetas);
    botones.add(subrecetas);
    botones.add(regresar);
    add("Center", botones);     
    ing.addActionListener(this);
    recetas.addActionListener(this);
    subrecetas.addActionListener(this);
    regresar.addActionListener(this);
    addWindowListener(this);
   }
  
   public void actionPerformed(ActionEvent e) { //invoca el m�todo correspondiente al bot�n oprimido
       if(e.getSource()== ing)
       ingredientes();     
       if(e.getSource()== subrecetas)
       subrecetas();
       if(e.getSource()== recetas)
       recetas();
       if(e.getSource()== regresar)
        this.setVisible(false);
       if(e.getSource()==r1)
       receta1();         
       if(e.getSource()==r2)
       receta2();
       if(e.getSource()==r3)
       receta3();
       if(e.getSource()==r4)
       receta4();
       if(e.getSource()==r5)
       receta5();
       if(e.getSource()==r6)
       receta6();
       if(e.getSource()==r7)
       receta7();
       if(e.getSource()==r8)
       receta8();
       if(e.getSource()==r9)
       receta9();
       if(e.getSource()==r10)
       receta10();
       if(e.getSource()==r11)
       receta11();
       if(e.getSource()==r12)
       receta12();
       if(e.getSource()== sr1)    
       subreceta1();
       if(e.getSource()== sr2)    
       subreceta2();
       if(e.getSource()== sr3)    
       subreceta3();
       if(e.getSource()== sr4)    
       subreceta4();
       if(e.getSource()== sr5)    
       subreceta5();
       if(e.getSource()== sr6)    
       subreceta6();
       if(e.getSource()== sr7)    
       subreceta7();
       if(e.getSource()== sr8)    
       subreceta8();
       if(e.getSource()== sr9)    
       subreceta9();      
     }
   
   public void recetas(){ //Crea el men� del cat�logo de recetas
       drecetas= new JDialog();
       drecetas.setSize(540,390);
       drecetas.setTitle("Men� de recetas");
       drecetas.setLocation(115,185);
       drecetas.setVisible(true);        
       drecetas.setLayout(new BorderLayout());     
    rtitulo= new Label( "Mr. Brown", Label.CENTER);
    rtitulo.setFont(new Font("Serif", Font.BOLD, 35));
    rtitulo.setBackground(nuevo);
    rtitulo.setForeground(Color.black);
    drecetas.add("North", rtitulo);    
    rabajo= new Label( "Recetas", Label.CENTER);
    rabajo.setFont(new Font("Serif", 4, 20));
    rabajo.setBackground(nuevo);
    rabajo.setForeground(Color.black);
    drecetas.add("South", rabajo);    
    rbotones=new Panel (new GridLayout(4,3,1,1));    
        //Crea todos los botones del cat�logo de recetas
    r1= new Button ("Receta 1");r2= new Button ("Receta 2");r3= new Button ("Receta 3");
    r4= new Button ("Receta 4");r5= new Button ("Sandwich de Tocino");r6= new Button ("Receta 6");
    r7= new Button ("Receta 7");r8= new Button ("Receta 8");r9= new Button ("Receta 9");
    r10= new Button ("Hamburguesa Especial");r11= new Button ("Receta 11");r12= new Button ("Receta 12");
    rbotones.add(r1);
    rbotones.add(r2);
    rbotones.add(r3);
    rbotones.add(r4);
    rbotones.add(r5);
    rbotones.add(r6);
    rbotones.add(r7);
    rbotones.add(r8);
    rbotones.add(r9);
    rbotones.add(r10);
    rbotones.add(r11);
    rbotones.add(r12);
    drecetas.add("Center", rbotones);       
    r1.addActionListener(this);
    r2.addActionListener(this);
    r3.addActionListener(this);
    r4.addActionListener(this);
    r5.addActionListener(this);
    r6.addActionListener(this);
    r7.addActionListener(this);
    r8.addActionListener(this);
    r9.addActionListener(this);
    r10.addActionListener(this);
    r11.addActionListener(this);
    r12.addActionListener(this);
    regresar.addActionListener(this);
    addWindowListener(this);
   }
          
   public void subrecetas(){ //Crea el men� de sub-recetas
       dsubrecetas= new JDialog();
       dsubrecetas.setSize(540,390);
       dsubrecetas.setTitle("Men� de sub-recetas");
       dsubrecetas.setLocation(115,185);
       dsubrecetas.setVisible(true);       
     dsubrecetas.setLayout(new BorderLayout());     
    srtitulo= new Label( "Mr. Brown", Label.CENTER);
    srtitulo.setFont(new Font("Serif", Font.BOLD, 35));
    srtitulo.setBackground(nuevo);
    srtitulo.setForeground(Color.black);
    dsubrecetas.add("North", srtitulo);    
    srabajo= new Label( "Sub-Recetas", Label.CENTER);
    srabajo.setFont(new Font("Serif", 4, 20));
    srabajo.setBackground(nuevo);
    srabajo.setForeground(Color.black);
    dsubrecetas.add("South", srabajo);    
    srbotones=new Panel (new GridLayout(3,3,1,1));    
    sr1= new Button ("Baguette");sr2= new Button ("Salsa de Chipotle");sr3= new Button ("Limonada");
    sr4= new Button ("SubReceta 4");sr5= new Button ("SubReceta 5");sr6= new Button ("SubReceta 6");
    sr7= new Button ("SubReceta 7");sr8= new Button ("SubReceta 8");sr9= new Button ("SubReceta 9");    
    srbotones.add(sr1);
    srbotones.add(sr2);
    srbotones.add(sr3);
    srbotones.add(sr4);
    srbotones.add(sr5);
    srbotones.add(sr6);
    srbotones.add(sr7);
    srbotones.add(sr8);
    srbotones.add(sr9);
    dsubrecetas.add("Center", srbotones);     
    sr1.addActionListener(this);
    sr2.addActionListener(this);
    sr3.addActionListener(this);
    sr4.addActionListener(this);
    sr5.addActionListener(this);
    sr6.addActionListener(this);
    sr7.addActionListener(this);
    sr8.addActionListener(this);
    sr9.addActionListener(this);
    addWindowListener(this);
   }

   public void ingredientes(){ //Pantalla donde muestra una tabla con los ingredientes y sus costos
       ingredientes= new JDialog();
       ingredientes.setSize(850,400);
       ingredientes.setTitle("Lista de ingredientes");
       ingredientes.setLocationRelativeTo(null);
       ingredientes.setVisible(true);       
       ingredientes.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    ingredientes.add("North", titulo);    
    abajo= new Label( "Ingredientes Individuales", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    ingredientes.add("South", abajo);    
    //Crea la tabla donde se mostraran los ingredientes y llena las filas con strings
    ingr= new DefaultTableModel();
    ingr.addColumn("Ingredientes");
    ingr.addColumn("Cantidad");
    ingr.addColumn("Costo Original");
    ingr.addColumn("Rendimiento");
    ingr.addColumn("Costo Real");       
    String[] data = {"Carne","1 kg","85.00","100%","85.00"};
    String[] data2 ={"Aguacate","1 kg","8.00","92%","7.36"};
    String[] data3= {"Lechuga","1 kg","11.00","99%","10.89"};
    String[] data4 = {"Tomate","1 kg","8.52","98%","8.35"};
    String[] data5 = {"Pan", "20 pzs", "28.00", "100%", "28.00"};
    String[] data6 = {"Queso", "1 kg", "17.95", "100%", "17.95"};
    String[] data7 = {"Jam�n", "1 kg", "20.30", "100%", "20.30"};
    String[] data8 = {"Pasta", "1 kg", "42.73", "100%", "42.73"};
    String[] data9 = {"Lim�n", "1 kg", "13.95", "98%", "13.67"};
    String[] data10 = {"Galleta horneada", "1 kg", "22.00", "100%", "22.00"};    
   ingr.addRow(data);
   ingr.addRow(data2);
   ingr.addRow(data3);
   ingr.addRow(data4);
   ingr.addRow(data5);
   ingr.addRow(data6);
   ingr.addRow(data7);
   ingr.addRow(data8);
   ingr.addRow(data9);
   ingr.addRow(data10);   
   totali=0.0;
         for(int i=0;i<ingr.getRowCount();i++){  
           in=Double.parseDouble(ingr.getValueAt(i,4).toString());
          totali=totali+in;}         
     centro= new Panel(new BorderLayout());
     totalingr= new Label("Costo total de ingredientes: $"+totali,Label.RIGHT);
     totalingr.setFont(new Font("Serif", 1, 14)); 
     rtable = new JTable(ingr);
     rtable.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     rtable.getTableHeader().setBackground(Color.black); 
     rtable.getTableHeader().setForeground(Color.orange);
     rtable.setEnabled(false);
     rscroll = new JScrollPane();
     rscroll.setViewportView (rtable);
     centro.add("Center",rscroll);
     centro.add("South", totalingr);
     ingredientes.add("Center", centro);
       }
   
   public double getValor2(){
        valor2=totali; 
        return valor2;       
      }
   
   //Los siguientes m�todos crean las pantallas de cada sub-receta *SOLO TIENEN DATOS LA 1 Y 2*
    public void subreceta1(){
       subr1= new JDialog();
       subr1.setSize(600,275);
       subr1.setTitle("Mr.Brown");
       subr1.setLocation(700,240);
       subr1.setVisible(true);        
       subr1.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr1.add("North", titulo);    
    abajo= new Label( "Baguette", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr1.add("South", abajo);     
    Object[][] data = {{"Pan Franc�s","1 pz","$2.20"},{"Pimienta","2 gr","$0.70"},{"","",""},{"","Total","$2.90",}, };
     Object[] nombres = {"Ingrediente","Cantidad","Costo"};    //DATOS INVENTADOS PARA EL EJEMPLO
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     table.setEnabled(false);
     scroll = new JScrollPane();
     scroll.setViewportView (table);
     subr1.add("Center", scroll);
   }
   
   public void subreceta2(){
       subr2= new JDialog();
       subr2.setSize(600,275);
       subr2.setTitle("Mr.Brown");
       subr2.setLocation(700,240);
       subr2.setVisible(true);        
       subr2.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr2.add("North", titulo);    
    abajo= new Label( "Salsa Chipotle", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr2.add("South", abajo);     
    Object[][] data = {{"Queso Crema Philadelphia","190 gr","$5.00"},{"Tomate","1 kg","$8.35"},{"Cebolla Asada","1/2 pza","$2.50"},
    {"Dientes de ajo","2 pzas","$1.00"},{"Chile Chipotle","2 pzas","$3.40"},{"Concentrado de pollo","1 cda.","$0.20"},
      {"","Total","$20.45"}};       //DATOS INVENTADOS PARA EL EJEMPLO
     Object[] nombres = {"Ingrediente","Cantidad","Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     table.setEnabled(false);
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     subr2.add("Center", scroll);
   }
   
   public void subreceta3(){
       subr3= new JDialog();
       subr3.setSize(600,275);
       subr3.setTitle("Mr.Brown");
       subr3.setLocation(700,240);
       subr3.setVisible(true);        
       subr3.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr3.add("North", titulo);    
    abajo= new Label( "Limonada", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr3.add("South", abajo);     
    Object[][] data = {{"Lim�n", "1 kg", "13.95"}, {"Agua","5 l", "30.00"}, {"","Total","$43.95"}};       //DATOS INVENTADOS PARA EL EJEMPLO
     Object[] nombres = {"Ingrediente","Cantidad","Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     subr3.add("Center", scroll);
   }
   
   public void subreceta4(){
       subr4= new JDialog();
       subr4.setSize(600,275);
       subr4.setTitle("Mr.Brown");
       subr4.setLocation(700,240);
       subr4.setVisible(true);        
       subr4.setLayout(new BorderLayout());
       titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr4.add("North", titulo);    
    abajo= new Label( "Sub Receta 4", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr4.add("South", abajo);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"SubReceta4","Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     subr4.add("Center", scroll);
   }
   
   public void subreceta5(){
       subr5= new JDialog();
       subr5.setSize(600,275);
       subr5.setTitle("Mr.Brown");
       subr5.setLocation(700,240);
       subr5.setVisible(true);        
       subr5.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr5.add("North", titulo);    
    abajo= new Label( "Sub Receta 5", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr5.add("South", abajo);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"SubReceta5", "Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     subr5.add("Center", scroll);
   }

   public void subreceta6(){
       subr6= new JDialog();
       subr6.setSize(600,275);
       subr6.setTitle("Mr.Brown");
       subr6.setLocation(700,240);
       subr6.setVisible(true);        
       subr6.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr6.add("North", titulo);    
    abajo= new Label( "Sub Receta 6", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr6.add("South", abajo);    
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"SubReceta6","Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     subr6.add("Center", scroll);
   }
   
   public void subreceta7(){
       subr7= new JDialog();
       subr7.setSize(600,275);
       subr7.setTitle("Mr.Brown");
       subr7.setLocation(700,240);
       subr7.setVisible(true);        
       subr7.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr7.add("North", titulo);    
    abajo= new Label( "Sub Receta 7", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr7.add("South", abajo);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"SubReceta7","Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     subr7.add("Center", scroll);
   }
   
   public void subreceta8(){
       subr8= new JDialog();
       subr8.setSize(600,275);
       subr8.setTitle("Mr.Brown");
       subr8.setLocation(700,240);
       subr8.setVisible(true);        
       subr8.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr8.add("North", titulo);    
    abajo= new Label( "Sub Receta 8", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr8.add("South", abajo);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
    Object[] nombres = {"SubReceta8","Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     subr8.add("Center", scroll);
   }
   
   public void subreceta9(){
       subr9= new JDialog();
       subr9.setSize(600,275);
       subr9.setTitle("Mr.Brown");
       subr9.setLocation(700,240);
       subr9.setVisible(true);        
       subr9.setLayout(new BorderLayout());     
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    subr9.add("North", titulo);    
    abajo= new Label( "Sub Receta 9", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    subr9.add("South", abajo);
     Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"SubReceta9","Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     subr9.add("Center", scroll);
   }
   
   //Los siguientes metodos crean las pantallas para cada receta    *SOLO TIENEN DATOS LA 5 Y 10*
   public void receta1(){
       rec= new JDialog();
       rec.setSize(600,275);
       rec.setTitle("Mr. Brown");
       rec.setLocation(700,240);
       rec.setVisible(true);        
       rec.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec.add("North", titulor);    
    abajor= new Label( "Receta 1", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec.add("South", abajor);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"Receta 1","Costo"};    
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec.add("Center", scroll);   
   }
   
    public void receta2(){
       rec2= new JDialog();
       rec2.setSize(600,275);
       rec2.setTitle("Mr. Brown");
       rec2.setLocation(700,240);
       rec2.setVisible(true);        
       rec2.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec2.add("North", titulor);    
    abajor= new Label( "Receta 2", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec2.add("South", abajor);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
    Object[] nombres = {"Receta 2","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec2.add("Center", scroll);   
   }
    
    public void receta3(){
       rec3= new JDialog();
       rec3.setSize(600,275);
       rec3.setTitle("Mr. Brown");
       rec3.setLocation(700,240);
       rec3.setVisible(true);        
       rec3.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec3.add("North", titulor);    
    abajor= new Label( "Receta 3", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec3.add("South", abajor);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
    Object[] nombres = {"Receta 3","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec3.add("Center", scroll);   
   }
   
    public void receta4(){
       rec4= new JDialog();
       rec4.setSize(600,275);
       rec4.setTitle("Mr. Brown");
       rec4.setLocation(700,240);
       rec4.setVisible(true);        
       rec4.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec4.add("North", titulor);    
    abajor= new Label( "Receta 4", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec4.add("South", abajor);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"Receta 4","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec4.add("Center", scroll);   
   }
    
    public void receta5(){
       rec5= new JDialog();
       rec5.setSize(600,275);
       rec5.setTitle("Mr. Brown");
       rec5.setLocation(700,240);
       rec5.setVisible(true);        
       rec5.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec5.add("North", titulor);    
    abajor= new Label( "Sandwich de tocino", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec5.add("South", abajor);     
    Object[][] data = {{"Baguette","2 pzas","$5.80"},{"Jam�n","30 gr","$1.50"},{"Tomate","50 gr","$0.42"},{"Aguacate","30 gr","$0.22"},
    {"Tocino","10 gr","$0.70"},{"Lechuga","20 gr","$0.20"}, {"","Total","$8.84"},};
     Object[] nombres = {"Ingrediente","Cantidad","Costo"};  //DATOS INVENTADOS PARA EL EJEMPLO
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange); 
     table.setEnabled(false);
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec5.add("Center", scroll);  
   }
    
    public void receta6(){
       rec6= new JDialog();
       rec6.setSize(600,275);
       rec6.setTitle("Mr. Brown");
       rec6.setLocation(700,240);
       rec6.setVisible(true);        
       rec6.setLayout(new BorderLayout());
       titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec6.add("North", titulor);    
    abajor= new Label( "Receta 6", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec6.add("South", abajor);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"Receta 6","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec6.add("Center", scroll);   
   }
    
    public void receta7(){
       rec7= new JDialog();
       rec7.setSize(600,275);
       rec7.setTitle("Mr. Brown");
       rec7.setLocation(700,240);
       rec7.setVisible(true);        
       rec7.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec7.add("North", titulor);    
    abajor= new Label( "Receta 7", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec7.add("South", abajor);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
    Object[] nombres = {"Receta 7","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec7.add("Center", scroll);   
   }
    
    public void receta8(){
       rec8= new JDialog();
       rec8.setSize(600,275);
       rec8.setTitle("Mr. Brown");
       rec8.setLocation(700,240);
       rec8.setVisible(true);       
       rec8.setLayout(new BorderLayout());
       titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec8.add("North", titulor);    
    abajor= new Label( "Receta 8", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec8.add("South", abajor);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"Receta 8","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec8.add("Center", scroll);   
   }
    
    public void receta9(){
       rec9= new JDialog();
       rec9.setSize(600,275);
       rec9.setTitle("Mr. Brown");
       rec9.setLocation(700,240);
       rec9.setVisible(true);        
       rec9.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec9.add("North", titulor);    
    abajor= new Label( "Receta 9", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec9.add("South", abajor);
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"Receta 9","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec9.add("Center", scroll);   
   }
    
    public void receta10(){
       rec10= new JDialog();
       rec10.setSize(600,275);
       rec10.setTitle("Mr. Brown");
       rec10.setLocation(700,240);
       rec10.setVisible(true);        
       rec10.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec10.add("North", titulor);    
    abajor= new Label( "Hamburguesa Especial", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec10.add("South", abajor);     
    Object[][] data = {{"Pan","2 pzas","$4.80"},{"Carne","150 gr","$30.0"},{"Aguacate","30 gr","$0.22"},{"Tomate","50 gr","$0.42"},
       {"Lechuga","20 gr","$0.20"},{"","Total","$35.64"}};    //DATOS INVENTADOS PARA EL EJEMPLO
     Object[] nombres = {"Ingrediente","Cantidad","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     table.setEnabled(false);
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec10.add("Center", scroll);   
   }
    
    public void receta11(){
       rec11= new JDialog();
       rec11.setSize(600,275);
       rec11.setTitle("Mr. Brown");
       rec11.setLocation(700,240);
       rec11.setVisible(true);        
       rec11.setLayout(new BorderLayout());     
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec11.add("North", titulor);    
    abajor= new Label( "Receta 11", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec11.add("South", abajor);
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"Receta 11","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec11.add("Center", scroll);   
   }
    
    public void receta12(){
       rec12= new JDialog();
       rec12.setSize(600,275);
       rec12.setTitle("Mr. Brown");
       rec12.setLocation(700,240);
       rec12.setVisible(true);        
       rec12.setLayout(new BorderLayout());      
    titulor= new Label( "Mr. Brown", Label.CENTER);
    titulor.setFont(new Font("Serif", Font.BOLD, 35));
    titulor.setBackground(nuevo);
    titulor.setForeground(Color.black);
    rec12.add("North", titulor);    
    abajor= new Label( "Receta 12", Label.CENTER);
    abajor.setFont(new Font("Serif", 4, 20));
    abajor.setBackground(nuevo);
    abajor.setForeground(Color.black);
    rec12.add("South", abajor);     
    Object[][] data = {{"",""},{"","",},{"","",},{"","",},{"","",},{"","",},{"TOTAL","",},};
     Object[] nombres = {"Receta 12","Costo"};
     table = new JTable(data, nombres);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     rec12.add("Center", scroll);
    }
    
    public void windowClosing(WindowEvent e){            
            System.exit(0);     } //Sirve para salir del programa una vez que la ventana haya sido cerrada
    public void  windowActivated(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
  }