import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
class Thread_TimeReduce extends Thread{
	ThreadEx4 main;
	boolean isrun = true;
	boolean isStop = false;
	public Thread_TimeReduce(ThreadEx4 main) {
		// TODO Auto-generated constructor stub
		this.main = main;
	}
	@Override
	public void run() {
		while (isrun) {
			try {
				if(isStop){
					Thread.sleep(3000);
					isStop = false;
				}else{
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			main.chgTime();
		}
	}
	
	void chgRun(boolean b){
		isrun = b;
	}
	void setStop(){
		isStop = true;
	}
}
public class ThreadEx4 extends JFrame implements ActionListener{
	JButton stop,restart;
	JLabel lbl;
	int time;
	Thread_TimeReduce t;
	public ThreadEx4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		setRe(100);
		lbl = new JLabel();
		lbl.setText(time+"");
		restart = new JButton("다시");
		restart.addActionListener(this);
		stop = new JButton("중지");
		stop.addActionListener(this);
		JPanel pnl = new JPanel();
		pnl.add(stop);
		pnl.add(restart);
		add(pnl,"South");
		add(lbl);
		t = new Thread_TimeReduce(this);
		t.start();
		setVisible(true);
	}
	public static void main(String[] args) {
		new ThreadEx4();
	}
	synchronized void chgTime(){
		time -=1;
		lbl.setText(time+"");
		repaint();
		revalidate();
		if(time<=0){
			JOptionPane.showMessageDialog(this, "끝");
			t.chgRun(false);
		}
	}
	void setRe(int t){
		time = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==restart){
			setRe(101);
		}else{
			t.setStop();
		}
	}
}
