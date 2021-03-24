import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
class CounterExThread implements Runnable{
	CounterEx main;
	boolean isrunning = true;
	public CounterExThread(CounterEx main) {
		this.main = main;
	}
	@Override
	public void run() {
		System.out.println(1);
		while (isrunning) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(main.y==10){
				break;
			}
			main.height +=5;
			main.y -= 5;
			main.btnred.setBounds(130, main.y, 20, main.height);
			main.repaint();
			
		}
			
	}
}
public class CounterEx extends JFrame implements ActionListener{ 
	JButton startBtn;
	JButton stopBtn;
	JButton btnred;
	int y = 110;
	int height;
	Thread t;
	CounterExThread tr;
	public CounterEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		startBtn = new JButton("카운터 시작");
		stopBtn = new JButton("카운터 중지");
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		JPanel pnl = new JPanel();
		pnl.add(startBtn);
		pnl.add(stopBtn);
		JPanel inPnl= new JPanel();
		inPnl.setLayout(null);
		JButton btnwh = new JButton();
		btnred = new JButton();
		btnwh.setBackground(Color.white);
		btnred.setBackground(Color.red);
		btnwh.setBounds(130,10,20,100);
		btnred.setBounds(130,y,20,height);
		inPnl.add(btnred);
		inPnl.add(btnwh);
		add(pnl,"North");
		add(inPnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CounterEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==startBtn){
			tr = new CounterExThread(this);
			t = new Thread(tr);
			t.start();
			
		}else{
			tr.isrunning = false;
		}
	}
}
