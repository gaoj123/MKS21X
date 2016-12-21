import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
 private Container pane;

 private JButton b;
    private JButton d;
 private JLabel a;
 private JTextField c;
    //private JCheckBox c;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window() {
     this.setTitle("Converting Temperatures");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
     a=new JLabel("Result");
     b = new JButton("toC");
     c=new JTextField(12);
     d=new JButton("toF");
     //l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
     //t = new JTextField(12);
     // c = new JCheckBox("Overclock!!!");
     //pane.add(l);
     pane.add(c);
     // pane.add(t);
     pane.add(d);
     pane.add(b);
     pane.add(a);
 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window g = new Window();
     g.setVisible(true);
  }
}
