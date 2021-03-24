import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoonDrawTest extends JFrame{
	public MoonDrawTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,200);
		add(new MoonDrawPnl());
		setVisible(true);
	}
	class MoonDrawPnl extends JPanel{
		BufferedImage img;
		public  MoonDrawPnl() {
			// TODO Auto-generated constructor stub
			try {
				img = ImageIO.read(new File("sky.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), null);
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.YELLOW);
			g2.fillArc(20, 20, 100, 100, 310, -200);
			g2.setColor(Color.black);
			g2.fillOval(35, 60, 5, 5);
			g2.fillOval(55, 60, 5, 5);
			g2.drawArc(45, 80, 10, 10, 0, -180);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoonDrawTest();
	}

}
