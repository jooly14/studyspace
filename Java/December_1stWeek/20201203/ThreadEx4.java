import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
class MyThread4 extends Thread{
	SimpleDateFormat f = new SimpleDateFormat("yyyy년 M월 d일 a h시 m분 s초");
	ThreadEx4 frm;
	//lbl.setText(f.format(new Date()));
	public MyThread4(ThreadEx4 frm) {
		this.frm = frm;
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frm.setTime();	//클래스 자체를 받아와서 그 내부의 메서드를 호출하는 방식이다.
							//멤버변수를 직접 받아오는 것을 지양하는 게 좋지 않을까???
		}
	}
}
public class ThreadEx4 extends JFrame{
	JLabel lbl;
	SimpleDateFormat f;
	public ThreadEx4(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lbl = new JLabel();
		f = new SimpleDateFormat("yyyy년 M월 d일 a h시 m분 s초");
		
		//lbl.setFont(new Font("Serif",Font.BOLD,50));
		add(lbl);
		Thread t = new MyThread4(this);
		t.start();
		setVisible(true);
	}
	void setTime(){
		lbl.setText(f.format(System.currentTimeMillis()));
	}
	public static void main(String[] args) {
		new ThreadEx4();
	}
}
