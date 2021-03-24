import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame1 extends JFrame{
	public MyFrame1(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		setResizable(false);
		setLocation(200,200);
		
		setLayout(new FlowLayout());
		JButton btn = new JButton("버튼");
		add(btn);
		setVisible(true);
	}
}
public class MyFrameTest1 {

	public static void main(String[] args) {
		new MyFrame1();
	}

}
