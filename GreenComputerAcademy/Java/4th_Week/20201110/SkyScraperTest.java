import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SkyScraperTest extends JFrame{
	public SkyScraperTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,260);
		
		
		add(new SkyScraperPnl());
		setVisible(true);
	}
	class SkyScraperPnl extends JPanel{
		BufferedImage image;
		public SkyScraperPnl(){
			try {
				image = ImageIO.read(new File("sky.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			int color = 80;
			g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(), null);
			for(int i=0;i<30;i++){
				color = color-2;
				g.setColor(new Color(color, color, color));
				int h =(int)(Math.random()*150)+20;
				g.fillRect((int)(Math.random()*250), 230-h, (int)(Math.random()*30)+20, h);
				
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SkyScraperTest();
	}

}
