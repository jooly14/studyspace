import javax.swing.JButton;
import javax.swing.JFrame;

public class AbsoluteLayoutTest2 extends JFrame{
	public AbsoluteLayoutTest2(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JButton btn1 =new JButton("button1");
		/*btn1.setLocation(0,0);
		btn1.setSize(100,100);*/
		btn1.setBounds(0, 0, 100, 100);
		add(btn1);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AbsoluteLayoutTest2();
	}

}
