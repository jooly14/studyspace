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
		box = new JButton("������");
		btn = new JButton("����");
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
	class BoxThread extends Thread{	//timer�� �⺻������  �ݺ��������� thread�� �ݺ� ������ �ϱ� ���ؼ��� �ݺ����� ���� ���� ���� �ʿ��ϴ�.
		@Override
		public void run() {
			while(isRunning){	//Thread.stop()�� ������ �����ϰ� �����Ƿ� ����� �����ϴ� ���� ����. ��� �ݺ��� �������� ������ �����ϴ�.
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
