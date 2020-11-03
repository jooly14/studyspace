import javax.swing.JFrame;
import javax.swing.JLabel;

public class AbsoluteLayoutTest extends JFrame{
	public AbsoluteLayoutTest(){
		setSize(500,500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for(int i = 0;i<30;i++){
			int x = (int)(Math.random()*500);
			int y = (int)(Math.random()*500);
			JLabel la = new JLabel(i+"");
			la.setLocation(x, y);
			la.setSize(15,15);
			add(la);
		}
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AbsoluteLayoutTest();
	}

}
