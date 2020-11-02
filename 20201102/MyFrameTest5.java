import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame5 extends JFrame{
	public MyFrame5(){
		setSize(500,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테스트 프레임");
		
		
		JPanel panel = new JPanel();
		JTextField tf1 = new JTextField(10);
		tf1.setText("입력 가능");
		JTextField tf2 = new JTextField(10);
		tf2.setEditable(false);
		setLayout(new FlowLayout());
		
		panel.add(tf1);
		panel.add(tf2);
		
		add(panel);
		setVisible(true);
	}
}
public class MyFrameTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame5();
	}

}
