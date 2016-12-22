import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window extends JFrame implements ActionListener {
    private Container pane;
    private JButton b;
    private JButton d;
    private JLabel a;
    private JTextField c;
    //private JCheckBox c;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Window() {
	this.setTitle("Converting Temperatures");
	this.setSize(300,370);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout(30,70,30));  //NOTE!! THIS CAN BE CHANGED (see below)
	a=new JLabel("Result");
	b = new JButton("toC");
	b.addActionListener(this);
	b.setActionCommand("convertToC");
	//b.setPreferredSize(new Dimension(100,5));
	c=new JTextField(12);
	d=new JButton("toF");
	d.addActionListener(this);
	d.setActionCommand("convertToF");
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
    public void actionPerformed(ActionEvent e){
	if(e.getActionCommand().equals("convertToC")){
	    double x=(5.0/9)*(Double.parseDouble(c.getText())-32);
	    double roundOff=Math.round(x*100.0)/100.0;
	     a.setText(""+roundOff+" C");
	     
	}
	else if(e.getActionCommand().equals("convertToF")){
	    // int F=0;
	    //String input=c.getText();
	    // for(int i=0;i<input.length();i++){
	    // 	if (input.substring(i,i+1).equals("F")){
	    // 		F=1;
	    // 	}
	    // }
	    //if (F==0){
		double y=(9.0/5)*Double.parseDouble(c.getText())+32;
		double roundY=Math.round(y*100.0)/100.0;
		a.setText(""+roundY+" F");
		//}
	}
    }
}
