import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
//keylistener인터페이스를 구현하지 않고 keyAdapter클래스를 상속받아서 필요한 메서드만 오버라이딩해서 사용
class MyKeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
	}
}

public class keyEventTest2 extends JFrame{
	JTextField tf;
	public keyEventTest2(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf = new JTextField();
		tf.addKeyListener(new MyKeyListener());
		
		add(tf);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new keyEventTest2();
	}

}
