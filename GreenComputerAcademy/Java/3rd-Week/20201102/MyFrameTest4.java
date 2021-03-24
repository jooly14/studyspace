import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame4 extends JFrame{
	public MyFrame4(){
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setTitle("테스트 프레임");
		JPanel p = new JPanel();
		JButton b1 = new JButton();
		b1.setText("왼쪽 버튼");
		JButton b3 = new JButton("오른쪽 버튼");
		b3.setEnabled(false);
		p.add(b1);
		p.add(new JButton("중앙 버튼"));
		p.add(b3);
		
		add(p);
		setVisible(true);
	}
}
public class MyFrameTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame4();
	}

}
