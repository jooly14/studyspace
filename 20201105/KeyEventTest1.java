import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
//키이벤트 테스트 예제
//keylistener의 메서드들을 각각 실행해보고 keyevent의 getkeycode,getkeychar메서드도 사용해봄
public class KeyEventTest1 extends JFrame implements KeyListener{
	public KeyEventTest1(){
		setTitle("이벤트 예제");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField tf = new JTextField(20);
		tf.addKeyListener(this);
		
		add(tf);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyEventTest1();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		display(e,"keyPressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		display(e,"keyReleased");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		display(e,"keyTyped");
	}
	protected void display(KeyEvent e, String s) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		int keyCode = e.getKeyCode();
		String modifiers = e.isAltDown()+ " "+e.isControlDown()+" "+e.isShiftDown();
		System.out.println(s+" "+c+" "+keyCode+" "+modifiers);
	}

}
