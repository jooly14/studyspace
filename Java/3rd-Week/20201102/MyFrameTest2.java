import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame2 extends JFrame{
	public MyFrame2(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		setLayout(new FlowLayout());

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setLocation(screenSize.width/2,screenSize.height/2);
		
		setIconImage(kit.getImage("hu.gif"));
		
		JButton btn = new JButton("버튼");
		add(btn);
		setVisible(true);
	}
}
public class MyFrameTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame2();
	}

}
