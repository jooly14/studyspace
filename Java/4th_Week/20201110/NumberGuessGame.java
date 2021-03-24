import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NumberGuessGame extends JFrame implements ActionListener,KeyListener{
	JButton btnRetry;
	JButton btnExit;
	JTextField text;
	JTextField hint;
	int answer;
	public NumberGuessGame(){
		answer = (int)(Math.random()*100)+1;
		setTitle("숫자게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setLayout(new GridLayout(0,1));
		
		JPanel pnlN = new JPanel();
		text = new JTextField(10);
		pnlN.add(new JLabel("숫자를 추측하시오:"));
		pnlN.add(text);
		text.addKeyListener(this);
		
		JPanel pnlC = new JPanel();
		hint = new JTextField(20);
		hint.setEditable(false);
		pnlC.add(hint);
		
		btnRetry = new JButton("다시 한번");
		btnRetry.addActionListener(this);
		btnExit = new JButton("종료");
		btnExit.addActionListener(this);
		JPanel pnlS = new JPanel();
		pnlS.add(btnRetry);
		pnlS.add(btnExit);
		
		add(pnlN);
		add(pnlC);
		add(pnlS);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberGuessGame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnExit){
			System.exit(0);
		}else if(e.getSource()==btnRetry){
			int userAnswer = Integer.parseInt(text.getText());
			if(answer==userAnswer){
				hint.setText("정답입니다.");
			}else if(answer>userAnswer){
				hint.setBackground(Color.red);
				hint.setText("너무 낮습니다.");
			}else{
				hint.setBackground(Color.red);
				hint.setText("너무 높습니다.");
				
			}
			text.selectAll();
			text.requestFocus();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			int userAnswer = Integer.parseInt(text.getText());
			if(answer==userAnswer){
				hint.setText("정답입니다.");
			}else if(answer>userAnswer){
				hint.setBackground(Color.red);
				hint.setText("너무 낮습니다.");
			}else{
				hint.setBackground(Color.red);
				hint.setText("너무 높습니다.");
				
			}
			text.selectAll();
			text.requestFocus();
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

}
