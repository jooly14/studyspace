import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutTest4 extends JFrame  {
	public LayoutTest4(){
		setTitle("마일을 킬로미터로 변환");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel la1 = new JLabel("거리를 마일 단위로 입력하시오");
		JTextField tf1 = new JTextField(5);
		JPanel panel1 = new JPanel();
		panel1.add(la1);
		panel1.add(tf1);
		
		JPanel panel2 = new JPanel();
		JButton btn = new JButton("변환");
		btn.setBackground(Color.red);
		panel2.add(btn);
		
		JPanel panel3 = new JPanel();
		JTextField tf2 = new JTextField(20);
		panel3.add(tf2);
		
		add(panel1);
		add(panel2);
		add(panel3);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LayoutTest4();
	}

}
