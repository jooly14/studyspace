import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
class Thread_ThreadEx2 extends Thread{
	ThreadEx2 main;
	public Thread_ThreadEx2(ThreadEx2 main) {
		// TODO Auto-generated constructor stub
		this.main = main;
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
			main.chgExpression();
		}
	}
}
public class ThreadEx2 extends JFrame implements ActionListener{
	JButton smile,soso,bad;
	JButton start;
	int cur = 1;
	public ThreadEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		mkBtn();
		
		start = new JButton("Ω√¿€");
		start.addActionListener(this);
		add(start,"South");
		setVisible(true);
	}
	void mkBtn(){
		smile = new JButton(new ImageIcon("smile.png"));
		soso = new JButton(new ImageIcon("soso.png"));
		bad = new JButton(new ImageIcon("bad.png"));
		add(smile);
	}
	public static void main(String[] args) {
		new ThreadEx2();
	}
	void chgExpression(){
		if(cur==1){
			remove(smile);
			add(soso);
			cur++;
		}else if(cur==2){
			remove(soso);
			add(bad);
			cur++;
		}else if(cur==3){
			remove(bad);
			add(smile);
			cur=1;
		}
		repaint();
		revalidate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Thread_ThreadEx2(this).start();
	}
}
