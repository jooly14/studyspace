import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//이미지를 그려서 움직이는 차를 만들어냄
//paintComponent를 오버라이드함(jpanel의 메서드)
//imageio를 이용해서 image객체를 만들어냄.
//keylistener를 panel에서 사용하려면 focus를 받아와야함
class CarGamePanel extends JPanel{
	BufferedImage img;
	int img_x=100,img_y=100;
	
	public CarGamePanel(){
		try {
			img = ImageIO.read(new File("car.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("No Image");
			System.exit(1);
		}
		
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode =e.getKeyCode();
				switch(keyCode){
				case KeyEvent.VK_LEFT : img_x -= 10; break;
				case KeyEvent.VK_RIGHT : img_x += 10; break;
				case KeyEvent.VK_UP : img_y -= 10; break;
				case KeyEvent.VK_DOWN : img_y += 10; break;
				}
				repaint();
			}
		});
		this.requestFocus();
		this.setFocusable(true);
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		arg0.drawImage(img, img_x, img_y, null);
	}
}

public class CarGameTest extends JFrame{
	public CarGameTest(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new CarGamePanel());
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CarGameTest();
	}

}
