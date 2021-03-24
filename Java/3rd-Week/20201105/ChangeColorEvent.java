import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//button을 누르거나 엔터를 누르면 신호등 색이 차례대로 켜지는 프로그램
//button을 차례로 끄고 켜기위해서 별도의 lightnum이라는 변수를 넣음
//012순서로 증가하다가 3이 되면 다시 0이 되도록 구현
public class ChangeColorEvent extends JFrame implements ActionListener, KeyListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btnCh;
	int lightNum;

	
	public ChangeColorEvent(){
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		btn1 = new JButton();
		btn2 = new JButton();
		btn3 = new JButton();
		btn1.setBounds(90, 30, 100, 100);
		btn2.setBounds(90, 160, 100, 100);
		btn3.setBounds(90, 290, 100, 100);
		btn1.setBackground(Color.white);
		btn2.setBackground(Color.white);
		btn3.setBackground(Color.white);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		/*panel.addKeyListener(this);
		panel.requestFocus();
		panel.setFocusable(true);*/
		
		btnCh = new JButton("traffic light turn on");
		btnCh.addActionListener(this);
		btnCh.addKeyListener(this);
		
		
		
		/*this.addWindowListener( new WindowAdapter() { 
			public void windowOpened( WindowEvent e ){
				btnCh.requestFocus();
				btnCh.setFocusable(true); 
			} 
			
		});*/
		
		add(panel);
		add(btnCh,"South");
		setVisible(true);
		btnCh.requestFocus();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangeColorEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*if(++lightNum>=3){
			lightNum =0;
		}*/
		
		lightNum++;
		if(lightNum==0){
			btn3.setBackground(Color.white);
			btn1.setBackground(Color.red);
		}else if(lightNum==1){
			btn1.setBackground(Color.white);
			btn2.setBackground(Color.yellow);
			
		}else if(lightNum==2){
			btn2.setBackground(Color.white);
			btn3.setBackground(Color.green);
			lightNum =-1;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			if(++lightNum>=3){
				lightNum =0;
			}
			
			if(lightNum==0){
				btn3.setBackground(Color.white);
				btn1.setBackground(Color.red);
			}else if(lightNum==1){
				btn1.setBackground(Color.white);
				btn2.setBackground(Color.yellow);
				
			}else if(lightNum==2){
				btn2.setBackground(Color.white);
				btn3.setBackground(Color.green);
				
			}
			
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
