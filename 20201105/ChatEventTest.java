import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//setvisible 다음에 텍스트필드에 포커스를 줄수 있음
public class ChatEventTest extends JFrame implements KeyListener,ActionListener{
	JTextArea ta;
	JTextField tf;
	String str = "";
	
	public ChatEventTest(){
		init();
		
	}
	void init(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pnl = new JPanel();
		ta = new JTextArea(str);
		tf = new JTextField(30);
		tf.setPreferredSize(new Dimension(0,28));
		tf.addKeyListener(this);
		JButton btn = new JButton("입력");
		btn.addActionListener(this);
		pnl.add(tf);
		pnl.add(btn);
		
		/*
		//처음 실행했을 때 텍스트필드에 포커스가 가도록 설정
		this.addWindowListener( new WindowAdapter() { 
				public void windowOpened( WindowEvent e ){
					tf.requestFocus(); } 
			});*/

		
		add(ta);
		add(pnl,"South");
		
		setVisible(true);
		tf.requestFocus();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatEventTest();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			SimpleDateFormat format = new SimpleDateFormat ( "HH:mm");
			
			str = str+ "\n" + tf.getText()+"   ("+ format.format(System.currentTimeMillis())+")";;
			ta.setText(str);
			tf.setText("");
			
		}else{
			ta.setText(str+"\n.....................작성중");
		}
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		ta.setText(str);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			
			str = str+ "\n" + tf.getText();
			ta.setText(str);
			tf.setText("");
	}

}
