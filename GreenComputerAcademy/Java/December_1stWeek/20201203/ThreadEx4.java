import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
class MyThread4 extends Thread{
	SimpleDateFormat f = new SimpleDateFormat("yyyy�� M�� d�� a h�� m�� s��");
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
			frm.setTime();	//Ŭ���� ��ü�� �޾ƿͼ� �� ������ �޼��带 ȣ���ϴ� ����̴�.
							//��������� ���� �޾ƿ��� ���� �����ϴ� �� ���� ������???
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
		f = new SimpleDateFormat("yyyy�� M�� d�� a h�� m�� s��");
		
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
