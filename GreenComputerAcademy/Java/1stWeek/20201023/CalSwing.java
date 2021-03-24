import java.awt.*;
import javax.swing.*;

public class CalSwing{
	JFrame frame;
	JButton btn1, btn2, btn3;
	JTextField tf1, tf2;
	
	void init(){
		frame = new JFrame();
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		tf1 = new JTextField();
		tf2 = new JTextField(10);	
	}
	void start(){
		FlowLayout f = new FlowLayout();
		//frame.setLayout(f);
		frame.add(btn1,"North");
		frame.add(btn2,"South");
		frame.add(btn3,"East");
		frame.add(tf1,"West");
		frame.add(tf2,"Center");
		
		frame.setSize(300,200);
		frame.setVisible(true);
		
	}
	public static void main(String args[]){
		CalSwing s = new CalSwing();
		s.init();
		s.start();
	}
	
	
}