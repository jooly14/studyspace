import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
class CycleSignThread extends Thread{
	CycleSign main;
	public CycleSignThread(CycleSign main) {
		this.main = main;
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			main.pnl.repaint();
		}
	}
}
class CycleSignPnl extends JPanel{
	int x=300;
	int x2=300;
	int two =1;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(new Font("Serif",Font.BOLD,30));
		if(two ==3){
			System.out.println(3);
			x-=10;
			x2-=10;
			g2.drawString("우리는 스레드로 애니메이션을 할 수 있어요! ", x, 30);
			g2.drawString("나는 스레드로 애니메이션을 할 수 있어요! ", x2, 30);
			if(x<-450){
				two =2;
				x = 300;
			}else if(x2<-500){
				two=1;
				x2 =300;
			}
		}else if(two ==1){
			System.out.println(1);
			g2.drawString("우리는 스레드로 애니메이션을 할 수 있어요! ", x, 30);
			x-=10;
			if(x<-400){
				two =3;
			}
		}else if(two ==2){
			System.out.println(2);
			x2-=10;
			g2.drawString("나는 스레드로 애니메이션을 할 수 있어요! ", x2, 30);
			if(x2<-400){
				two =3;
			}
		}
	}
}
public class CycleSign extends JFrame{
	CycleSignPnl pnl;
	public CycleSign() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,200);
		pnl = new CycleSignPnl();
		pnl.setBackground(Color.WHITE);
		pnl.setBounds(100,50,250,50);
		add(pnl);
		setLayout(null);
		new CycleSignThread(this).start();
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CycleSign();
	}

}
