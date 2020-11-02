import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrameTest6 extends JFrame{
	public MyFrameTest6(){
		setSize(500,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테스트 프레임");
		JPanel p = new JPanel();
		p.add(new JLabel("자바는 재미있나요?"));
		p.add(new JButton("Yes"));
		p.add(new JButton("No"));
		add(p);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrameTest6();
	}

}
