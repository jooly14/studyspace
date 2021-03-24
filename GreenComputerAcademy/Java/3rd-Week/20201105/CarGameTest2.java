import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//이미지를 그리는 방식이 아니라 라벨에 이미지를 붙이는 형식으로 구현
//이미지를 붙일때 사이즈가 안 맞으면 imageIcon에서 image에 담아서 image의 사이즈를 설정하고 다시 imageIcon에 담아서 사용
public class CarGameTest2 extends JFrame implements KeyListener{
	int x, y;
	JLabel box;	//앞전에 이미지 페인트 방식에서 이미지를 라벨에 붙이는 방식으로 바꿨다. 매번 이미지를 다시 그리는 것이 아니라 라벨이 움직이는 방식이다.
	public CarGameTest2(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		
		ImageIcon img = new ImageIcon("car.png");	//이미지아이콘의 사이즈가 안 맞아서 이미지에 담아서 사이즈를 바꾼뒤 다시 아이콘에 담았다.
		Image img1 = img.getImage();
		Image imgCh = img1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		img = new ImageIcon(imgCh);
		box = new JLabel(img);
		box.setBounds(x, y, 200, 200);
		pnl.add(box);
		pnl.addKeyListener(this);
		
		pnl.requestFocus();
		pnl.setFocusable(true);
		
		add(pnl);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CarGameTest2();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode== KeyEvent.VK_LEFT){
			x -= 10;
		}else if(keyCode == KeyEvent.VK_RIGHT){
			x +=10;
		}else if(keyCode == KeyEvent.VK_UP){
			y -=10;
		}else if(keyCode == KeyEvent.VK_DOWN){
			y +=10;
		}
		box.setLocation(x, y);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
