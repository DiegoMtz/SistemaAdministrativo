import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Double;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseListener;

public class mrbrown extends Frame implements ActionListener, WindowListener, MouseListener{
  //MENU PRINCIPAL, llama a las clases costos y nómina.  
 Button costos, nomina, ingeg, regresar,con;
 Label titulo, abajo, espacio, espacio2, lagua,lluz,lgas,lventas, info, derecha, izqa, dera;
 JTextField agua, gas, luz, ventas;
 Panel botones, tabla, atras,  información, abj;
 JLabel logo;
 DefaultTableModel tablai;
 JDialog ingresos, llenar;
 JScrollPane scroll;
 JTable table;
 ImageIcon icono;
 costos jFrame= new costos(); 
 nomina jFrame2= new nomina();
 Color nuevo=new Color(255,200,15);
 double valor, valor2, utilidad, n, vventas,vagua,vluz,vgas,vservicios;
 String svalor,svalor2; 
  nomina v=new nomina();
  costos v2=new costos();
 
  public static void main (String[] args) throws IOException{
   mrbrown fr= new mrbrown ();
   fr.setSize(1370,725);
   fr.setTitle("Mr.Brown");
   fr.setVisible(true);
   fr.setExtendedState(MAXIMIZED_BOTH);
   fr.setBackground(Color.black);
   }
 
 public mrbrown() throws IOException{ //Crea el menú principal con las opciones de: Costos, Ingresos y Nómina
     setLayout(new BorderLayout());           
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    add("North", titulo);    
    abajo= new Label();
    abajo.setFont(new Font("Serif", Font.BOLD, 35));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    add("South", abajo);    
    botones= new Panel();
    botones.setLayout(null);
    costos = new Button ("Costos");
    costos.setBackground(nuevo); 
    costos.setBounds(495, 210, 165,75);
    costos.setFont(new Font("Serif",3, 25));
    nomina = new Button ("Nómina");
    nomina.setBackground(nuevo);
    nomina.setBounds(690,210,165,75);
    nomina.setFont(new Font("Serif",3, 25));
    ingeg = new Button ("Ingresos y Egresos");
    ingeg.setBackground(nuevo);
    ingeg.setBounds(582,295,195,75);
    ingeg.setFont(new Font("Serif", 3, 19));         
    ImageIcon icono = new ImageIcon("mblogo2.png","logo de mr. brown");
     logo= new JLabel(icono);
     logo.setBounds(597,410,165,140);     
    botones.add(logo);     
    botones.add(costos);
    botones.add(nomina);
    botones.add(ingeg);
    add("Center", botones);         
    costos.addActionListener(this);
    nomina.addActionListener(this);
    ingeg.addActionListener(this);
    addWindowListener(this);
    }  
 
 public void actionPerformed(ActionEvent e) {
    if(e.getSource()== costos){
       jFrame.setSize(1370,725);
       jFrame.setTitle("Mr.Brown");
       jFrame.setExtendedState(MAXIMIZED_BOTH);
       jFrame.setVisible(true); 
      }
    if(e.getSource()== nomina){
       jFrame2.setSize(1370,725);
       jFrame2.setTitle("Mr.Brown");
       jFrame2.setExtendedState(MAXIMIZED_BOTH);
       jFrame2.setVisible(true); 
      }
    if(e.getSource()== ingeg)
      llenar(); 
    if(e.getSource()== con){
      ingresos();
      llenar.dispose();
    } } 
 
 public void llenar(){
   llenar= new JDialog();
       llenar.setSize(360,200);
       llenar.setLocationRelativeTo(null);
       llenar.setTitle("Ingresos y Egresos");
       llenar.setVisible(true);       
       llenar.setLayout(new BorderLayout());
       información= new Panel();
       información.setLayout(new GridLayout(4,2));
       abj=new Panel();
       abj.setLayout(new BorderLayout());       
       lagua= new Label("Agua   ", Label.RIGHT);
       agua= new JTextField();
       agua.setText("0.0");
       agua.setForeground(Color.gray);
       agua.setEditable(true);
       lluz= new Label("Luz   ", Label.RIGHT);
       luz= new JTextField();
       luz.setText("0.0");
       luz.setForeground(Color.gray);
       luz.setEditable(true);
       lgas= new Label("Gas   ", Label.RIGHT);
       gas= new JTextField();
       gas.setText("0.0");
       gas.setForeground(Color.gray);
       gas.setEditable(true);
       lventas= new Label("Ventas   ", Label.RIGHT);
       ventas= new JTextField();
       ventas.setText("0.0");
       ventas.setForeground(Color.gray);
       ventas.setEditable(true);
       info= new Label("Registrar ingresos y egresos", Label.CENTER);
       info.setFont(new Font("Serif", Font.BOLD, 13));
       info.setBackground(nuevo);
       info.setForeground(Color.black);
       con= new Button("Confirmar");
       con.setBackground(nuevo);
       con.setForeground(Color.black);
       derecha= new Label();
       izqa=new Label("                                    ");
       dera=new Label("                                    ");       
       abj.add("West",izqa);
       abj.add("East",dera);
       abj.add("Center",con);
       llenar.add("East",derecha);
       llenar.add("North",info);
       información.add(lventas);
       información.add(ventas);
       información.add(lagua);
       información.add(agua);
       información.add(lluz);
       información.add(luz);
       información.add(lgas);
       información.add(gas);
       llenar.add("South",abj);
       llenar.add("Center", información);       
       ventas.addMouseListener(this);
       agua.addMouseListener(this);
       luz.addMouseListener(this);
       gas.addMouseListener(this);
       con.addActionListener(this);
       addWindowListener(this);
 }
 
 public void ingresos(){  //Pantalla que muestra en una tabla los ingresos y egresos de la empresa
       ingresos= new JDialog();
       ingresos.setSize(850,320);
       ingresos.setTitle("Ingresos y Egresos");
       ingresos.setLocationRelativeTo(null);
       ingresos.setVisible(true);   
    setLayout(new BorderLayout());
    titulo= new Label( "Mr. Brown", Label.CENTER);
    titulo.setFont(new Font("Serif", Font.BOLD, 35));
    titulo.setBackground(nuevo);
    titulo.setForeground(Color.black);
    ingresos.add("North", titulo);    
    abajo= new Label( "Ingresos y Egresos", Label.CENTER);
    abajo.setFont(new Font("Serif", 4, 20));
    abajo.setBackground(nuevo);
    abajo.setForeground(Color.black);
    ingresos.add("South", abajo);        
    vventas= Double.parseDouble(ventas.getText());
    vagua= Double.parseDouble(agua.getText());
    vluz= Double.parseDouble(luz.getText());
    vgas= Double.parseDouble(gas.getText());    
    vservicios= (vagua+vluz+vgas)*(-1);  
    valor = v.getValor()*(-1);
    valor2 = v2.getValor2()*(-1);           
    tablai=new DefaultTableModel();
    tablai.addColumn("Fuente");
    tablai.addColumn("Cantidad");   
    String[] data = {"Ventas",vventas+""};
    String[] data2= {"Nómina", valor+""};
    String[] data3= {"Ingredientes", valor2+""};
    String[] data4= {"Servicios",vservicios+""};       
      tablai.addRow(data);
      tablai.addRow(data2);
      tablai.addRow(data3);
      tablai.addRow(data4);      
        //INGRESOS Y EGRESOS INVENTADOS PARA EL EJEMPLO      
         utilidad=0.0;
         for(int i=0;i<tablai.getRowCount();i++){  
           n=Double.parseDouble(tablai.getValueAt(i,1).toString());
        utilidad=utilidad+n;}             
    String[] data5= {"Utilidad Neta","$"+utilidad,};
    tablai.addRow(data5);            
     table = new JTable(tablai);
     table.getTableHeader().setFont(new Font("Serif", 1, 16)); 
     table.getTableHeader().setBackground(Color.black); 
     table.getTableHeader().setForeground(Color.orange);     
     table.setEnabled(false);
     scroll = new JScrollPane();
     scroll.setViewportView (table);     
     ingresos.add("Center", scroll);
   }
 
 public void mouseClicked(MouseEvent e) {
   if(e.getSource()== ventas){
          ventas.setText("");
          ventas.setForeground(Color.black);   }
   if(e.getSource()== agua){
          agua.setText("");
          agua.setForeground(Color.black);    }
   if(e.getSource()== luz){
          luz.setText("");
          luz.setForeground(Color.black);     }
   if(e.getSource()== gas){
          gas.setText("");
          gas.setForeground(Color.black);     }
          }
 
   public void mousePressed(MouseEvent e){}
   public void mouseEntered(MouseEvent e){}
   public void mouseExited(MouseEvent e){}
   public void mouseReleased(MouseEvent e){}
   public void windowClosing(WindowEvent e){
          System.exit(0);    } 
   public void  windowActivated(WindowEvent e){}
   public void windowClosed(WindowEvent e){}
   public void windowDeactivated(WindowEvent e){}
   public void windowDeiconified(WindowEvent e){}
   public void windowIconified(WindowEvent e){}
   public void windowOpened(WindowEvent e){}
 }