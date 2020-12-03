import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
class MyThreadBoxR extends Thread{
	ThreadMoveBox2 main;
	boolean isRunning = true;
	public MyThreadBoxR(ThreadMoveBox2 main) {
		this.main = main;
	}
	@Override
	public void run() {
		while(isRunning){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			main.moveRed();
		}
		
	}
	void stopRun(){
		isRunning = false;
	}
}
class MyThreadBoxB extends Thread{
	ThreadMoveBox2 main;
	boolean isRunning = true;
	public MyThreadBoxB(ThreadMoveBox2 main) {
		this.main = main;
	}
	@Override
	public void run() {
		while(isRunning){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			main.moveBlue();
		}
	}
	void stopRun(){
		isRunning = false;
	}
}
public class ThreadMoveBox2 extends JFrame implements ActionListener{
	JButton boxB, boxR, btn;
	JPanel pnl;
	int x;
	int y;
	MyThreadBoxR tR;
	MyThreadBoxB tB;
	boolean up;
	boolean left;
	public ThreadMoveBox2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		
		pnl = new JPanel();
		boxB = new JButton();
		boxR = new JButton();
		btn = new JButton("ÁßÁö");
		pnl.setLayout(null);
		boxB.setBorder(BorderFactory.createLineBorder(Color.blue));
		boxR.setBorder(BorderFactory.createLineBorder(Color.red));
		boxB.setBackground(Color.white);
		boxR.setBackground(Color.white);
		boxB.setBounds(0,150,50,50);
		boxR.setBounds(170,0,50,50);
		
		btn.addActionListener(this);
		
		pnl.add(boxR);
		pnl.add(boxB);
		add(pnl);
		add(btn,"South");
		tR = new MyThreadBoxR(this);
		tR.start();
		tB = new MyThreadBoxB(this);
		tB.start();
		setVisible(true);
	}
	void moveRed(){
		if(y>270){
			up = true;
		}else if(y<1){
			up = false;
		}
		if(up){
			y-= 20;
		}else{
			y+= 20;
		}
		boxR.setLocation(170,y);
	}
	void moveBlue(){
		if(x>310){
			left = true;
		}else if(x<1){
			left = false;
		}
		
		if(left){
			x-= 20;
		}else{
			x+= 20;
		}
		boxB.setLocation(x,150);
	}
	public static void main(String[] args) {
		new ThreadMoveBox2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		tR.stopRun();
		tB.stopRun();
	}
}
