import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
class Thread_TimeReduce2 extends Thread{
	ThreadEx6 main;
	boolean isrun = true;
	boolean isStop = false;
	public Thread_TimeReduce2(ThreadEx6 main) {
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
public class ThreadEx6 extends JFrame implements ActionListener{
	JButton stop,restart;
	JLabel lbl;
	int time;
	Thread_TimeReduce2 t;
	public ThreadEx6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(null);
		
		lbl = new JLabel();
		setRe(100);
		lbl.setOpaque(true);
		lbl.setBackground(Color.red);
		lbl.setText(time+"");
		lbl.setBounds(30, 30, 200, 30);
		restart = new JButton("다시");
		restart.addActionListener(this);
		stop = new JButton("중지");
		stop.addActionListener(this);
		JPanel pnl = new JPanel();
		pnl.add(stop);
		pnl.add(restart);
		add(pnl,"South");
		pnl2.add(lbl);
		add(pnl2);
		t = new Thread_TimeReduce2(this);
		t.start();
		setVisible(true);
	}
	public static void main(String[] args) {
		new ThreadEx6();
	}
	synchronized void chgTime(){
		time -=1;
		lbl.setText(time+"");
		lbl.setBounds(lbl.getX()+lbl.getWidth()/(time+1), lbl.getY(), (lbl.getWidth()/(time+1))*time, lbl.getHeight());
		repaint();
		revalidate();
		if(time<=0){
			JOptionPane.showMessageDialog(this, "끝");
			t.chgRun(false);
		}
	}
	void setRe(int t){
		time = t;
		lbl.setBounds(30, 30, 200, 30);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==restart){
			setRe(100);
		}else{
			t.setStop();
		}
	}
}
