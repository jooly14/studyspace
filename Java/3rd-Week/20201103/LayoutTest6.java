import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutTest6 extends JFrame{
	public LayoutTest6(){
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(300,450);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
		JTextField tf = new  JTextField(20);
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(tf);
		
	/*	JButton btnC = new JButton("C");
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnC.setPreferredSize(new Dimension(50,50));
		panel2.add(btnC);
	*/	
		
		JPanel panel3 = new JPanel();
		JButton btnC = new JButton("C");
		btnC.setPreferredSize(new Dimension(50,50));
		panel3.add(btnC);
		JLabel la1 = new JLabel("");
		JLabel la2 = new JLabel("");
		JLabel la3 = new JLabel("");
		panel3.add(la1);
		panel3.add(la2);
		panel3.add(la3);
		makeButton(panel3);
		panel3.setLayout(new GridLayout(0, 4, 5, 5));
		
		
		panel.add(panel1);
		//panel.add(panel2);
		panel.add(panel3);
		add(panel);
		pack();
		setVisible(true);
	}
	public void makeButton(JPanel panel){
		String[] str = {"7","8","9","/","4","5","6","*","1","2","3","-","0","+/-","=","+"};
		for(int i = 0; i<str.length;i++){
			JButton btn = new JButton(str[i]);
			btn.setPreferredSize(new Dimension(40,50));
			panel.add(btn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LayoutTest6();
	}

}
