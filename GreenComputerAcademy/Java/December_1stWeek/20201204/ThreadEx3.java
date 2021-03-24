import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class Thread_ThreadEx3 extends Thread{
	ThreadEx3 main; 
	boolean isRunning = true;
	public Thread_ThreadEx3(ThreadEx3 main) {
		this.main = main;
		
	}
	@Override
	public void run() {
		while (isRunning) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			main.chgRed(5);
		}
	}
	void StopRun(){
		isRunning = false;
	}
}
public class ThreadEx3 extends JFrame implements ActionListener{
	JButton btnWh, btnRe;
	JPanel pnl;
	int x = 30;
	int width= 300;
	Thread_ThreadEx3 t;
	JButton btn;
	public ThreadEx3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		pnl = new JPanel();
		pnl.setLayout(null);
		
		btnWh = new JButton();
		btnRe = new JButton();
		btnWh.setBackground(Color.white);
		btnRe.setBackground(Color.red);
		btnRe.setBounds(x,30,width,30);
		btnWh.setBounds(30,30,300,30);
		
		pnl.add(btnRe);
		pnl.add(btnWh);
		add(pnl);
		
		btn = new JButton("Ω√¿€");
		btn.addActionListener(this);
		add(btn,"South");
		
		t = new Thread_ThreadEx3(this);
		setVisible(true);
	}
	void chgRed(int a){
		x+=a;
		width-=a;
		btnRe.setBounds(x,30,width,30);
		if(width<=0){
			t.StopRun();
			JLabel lbl = new JLabel("TIME OUT");
			lbl.setBounds(150,80,100,50);
			pnl.add(lbl);
		}
		repaint();
		revalidate();
	}
	public static void main(String[] args) {
		new ThreadEx3();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		t.start();
	}
}
