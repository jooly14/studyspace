import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
class Thread_ThreadEx1 extends Thread{
	ThreadEx1 main;
	boolean isrunning = true;
	public Thread_ThreadEx1(JButton redbtn, int alpha,ThreadEx1 main) {
		// TODO Auto-generated constructor stub
		this.main = main;
	}
	@Override
	public void run() {
		while(isrunning){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			main.chgColor(isrunning);
		}
	}
}
public class ThreadEx1 extends JFrame implements ActionListener{
	JButton btn;
	JButton redBtn;
	int alpha = 255;
	public ThreadEx1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		btn = new JButton("Å¬¸¯");
		btn.addActionListener(this);
		redBtn = new JButton();
		redBtn.setBackground(new Color(255, 0, 0, alpha));
		
		add(redBtn);
		add(btn,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		new ThreadEx1();
	}
	void chgColor(boolean isrunning){
		alpha -=10;
		if(alpha<0){
			isrunning=false;
		}else{
			redBtn.setBackground(new Color(255,0,0,alpha));
			repaint();
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new Thread_ThreadEx1(redBtn,alpha,this).start();
	}
}
