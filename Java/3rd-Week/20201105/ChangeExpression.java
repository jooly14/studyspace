import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//abc를 각각 눌리면 얼굴 표정이 바뀌는 것을 구현
//이미지는 라벨에 붙여서 사용
public class ChangeExpression extends JFrame implements KeyListener{
	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon icon3;
	JLabel lbl;
	public ChangeExpression(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		icon1 = new ImageIcon("happy.jpg");
		icon2 = new ImageIcon("sad.jpg");
		icon3 = new ImageIcon("soso.jpg");
		icon1 = imgSize(icon1);
		icon2 = imgSize(icon2);
		icon3 = imgSize(icon3);
		lbl = new JLabel(icon1);
		lbl.setBounds(180,180,100,100);
		pnl.setBackground(Color.white);
		pnl.add(lbl);
		
		pnl.addKeyListener(this);
		pnl.requestFocus();
		pnl.setFocusable(true);
		
		add(pnl);
		setVisible(true);
	}
	ImageIcon imgSize(ImageIcon icon){
		Image img = icon.getImage();
		Image imgch = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		return new ImageIcon(imgch);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangeExpression();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		if(c=='a'){
			lbl.setIcon(icon1);
		}else if(c=='b'){
			lbl.setIcon(icon2);
		}else if(c=='c'){
			lbl.setIcon(icon3);
		}
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
