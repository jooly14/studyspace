import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutTest5 extends JFrame implements ActionListener{
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	public LayoutTest5(){
		setTitle("이자 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLayout(new FlowLayout());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 2, 50, 5));
		
		JLabel la1 = new JLabel("원금을 입력하시오");
		JLabel la2 = new JLabel("이율을 입력하시오");
		tf1 = new JTextField(5);
		tf2 = new JTextField(5);
		panel1.add(la1);
		panel1.add(tf1);
		panel1.add(la2);
		panel1.add(tf2);
		
		JPanel panel2 = new JPanel();
		JButton btn1 = new JButton("변환");
		btn1.addActionListener(this);
		btn1.setBackground(Color.red);
		panel2.add(btn1);
		
		JPanel panel3 = new JPanel();
		tf3 = new JTextField(20);
		panel3.add(tf3);
		
		add(panel1);
		add(panel2);
		add(panel3);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LayoutTest5();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(tf1.getText());
		double num2 = Double.parseDouble(tf2.getText());
		tf3.setText("이자는 연 "+(int)(num1*num2*0.01)+"만원입니다.");
		
	}	

}
