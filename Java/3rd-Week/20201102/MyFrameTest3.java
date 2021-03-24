import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame3 extends JFrame{
	public MyFrame3(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("안녕하세요?"));
		panel.add(new JButton("버튼"));
		add(panel);
		setVisible(true);
		
	}
}
public class MyFrameTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame3();
	}

}
