import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame{
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	int x1 =0, x2 =0,x3=0;
	
	class MyThread5 extends Thread{
		@Override
		public void run() {
			for(int i =0;i<120;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				x1 += (int)(Math.random()*30);
				x2 += (int)(Math.random()*30);
				x3 += (int)(Math.random()*30);
				lbl1.setBounds(x1,0,100,100);
				lbl2.setBounds(x2,50,100,100);
				lbl3.setBounds(x3,100,100,100);
			}
		}
	}
	public CarGame(){
		setTitle("CarRace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,230);
		setLayout(null);
		
		lbl1 = new JLabel();
		lbl2 = new JLabel();
		lbl3 = new JLabel();
		ImageIcon icon = new ImageIcon("car1.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		icon = new ImageIcon(img);
		lbl1.setIcon(icon);
		lbl2.setIcon(icon);
		lbl3.setIcon(icon);
		add(lbl1);
		add(lbl2);
		add(lbl3);
		
		lbl1.setBounds(0,0,100,100);
		lbl2.setBounds(0,50,100,100);
		lbl3.setBounds(0,100,100,100);
		new MyThread5().start();
		setVisible(true);
	}
	public static void main(String[] args) {
		new CarGame();
	}
}
