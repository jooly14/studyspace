import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageFrame extends JFrame{
	BufferedImage img=null;
	public MyImageFrame(){
		setTitle("Image Load Test");
		
		try {
			img = ImageIO.read(new File("cat.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());		
			System.exit(0);
		}
		
		add(new Mypanel2());
		pack();
		setVisible(true);
	}
	class Mypanel2 extends JPanel{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(20));
			g2.drawImage(img, 0, 0, null);
			g2.drawLine(50, 500, 500, 500);
		}
		@Override
		public Dimension getPreferredSize() {
			// TODO Auto-generated method stub
			if(img==null){
				return new Dimension(100,100);
			}else{
				return new Dimension(img.getWidth(null),img.getHeight(null));
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyImageFrame();
	}

}
