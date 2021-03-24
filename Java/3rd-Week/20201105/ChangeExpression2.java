import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
//abc를 각각 누르면 얼굴표정이 바뀌는 프로그램을 구현
//라벨에 이미지를 붙이는 방식이 아닌 패널을 이미지를 그리는 방식을 사용
//이미지를 그리는 방식을 사용하려면 paintComponent를 오버라이딩해야 하므로 jpanel을 상속받는 클래스가 필요
//패널에 add돼야할 keylistener는 무명클래스로 구현
//이벤트가 발생하고 나면 반드시 repaint해야함
class ExpressionPanel extends JPanel{
	BufferedImage img1;
	BufferedImage img2;
	BufferedImage img3;
	BufferedImage img;
	
	public ExpressionPanel(){
		try {
			img1 = ImageIO.read(new File("happy.jpg"));
			img2 = ImageIO.read(new File("sad.jpg"));
			img3 = ImageIO.read(new File("soso.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		img = img1;
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				if(c=='a'){
					img = img1;
				}else if(c=='b'){
					img = img2;
				}else if(c=='c'){
					img = img3;
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		requestFocus();
		setFocusable(true);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 150, 150, null);
	}
	
	
}

public class ChangeExpression2 extends JFrame{
	public ChangeExpression2(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new ExpressionPanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangeExpression2();
	}

}
