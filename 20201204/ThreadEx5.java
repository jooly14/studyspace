import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
class JumpThread extends Thread{
	ThreadEx5 main;
	int height;
	boolean isRun = true;
	public JumpThread(ThreadEx5 main, int height) {
		this.main =main;
		this.height = height;
	}
	@Override
	public void run() {
		while(isRun){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(height<=0){
				main.downBox();
			}else{
				main.upBox();
				height-=10;
			}
		}
	}
	void setRun(){
		isRun = false;
	}
}
public class ThreadEx5 extends JFrame implements KeyListener{
	JButton btn;
	JumpThread t;
	public ThreadEx5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLayout(null);
		
		
		btn = new JButton();
		btn.setBackground(Color.red);
		btn.setBounds(200, 220, 30, 30);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		
		
		add(btn);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadEx5();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
				t = new JumpThread(this,100);
				t.start();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	void upBox(){
		btn.setLocation(btn.getX(), btn.getY()-10);
		
	}
	void downBox(){
		btn.setLocation(btn.getX(), btn.getY()+10);
		if(btn.getY()==220){
			t.setRun();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
