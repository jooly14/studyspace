import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreadMoveBox extends JFrame implements ActionListener{
	JButton box, btn;
	JPanel mainPnl;
	int x;
	Thread t;
	boolean isRunning = true;
	public ThreadMoveBox() {
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box = new JButton("빨간색");
		btn = new JButton("중지");
		btn.addActionListener(this);
		mainPnl = new JPanel();
		mainPnl.setLayout(null);
		mainPnl.add(box);
		box.setBackground(Color.RED);
		box.setBounds(x,50,50,50);
		
		this.add(mainPnl);
		this.add(btn,"South");
		t = new BoxThread();
		t.start();
		setVisible(true);
	}
	class BoxThread extends Thread{	//timer는 기본적으로  반복문이지만 thread는 반복 실행을 하기 위해서는 반복분을 따로 쓰는 것이 필요하다.
		@Override
		public void run() {
			while(isRunning){	//Thread.stop()이 문제를 내포하고 있으므로 사용을 지양하는 것이 좋다. 대신 반복문 조건으로 통제가 가능하다.
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					x += 10;
				box.setLocation(x,50);
			}
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//t.interrupt();
		//t.stop();
		isRunning = false;
	}
	public static void main(String[] args) {
		new ThreadMoveBox();
	}
	
}
