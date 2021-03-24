import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FindSamePicGame extends JFrame implements ActionListener{
	JButton[] btns = new JButton[16];
	//Color[] colors = {Color.RED, Color.black, Color.blue, Color.PINK, Color.CYAN,Color.GRAY,Color.green,Color.magenta};
	String[] nums = {"1","2","3","4","5","6","7","8"};
	int[] allocateNum = new int[8];
	String[] btnAnswer = new String[16];
	int restrict;
	JButton user1;
	JButton user2;
	public FindSamePicGame(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(4,4));
		int index;
		
		
		for(int i=0;i<16;i++){
			while(true){
				
				index = (int)(Math.random()*8);
				if(allocateNum[index]==0||allocateNum[index]==1){
					allocateNum[index]++;
					break;
				}else{
					
				}
			}
			
			btns[i] = new JButton();
			btns[i].setBackground(Color.gray);
			btnAnswer[i] =nums[index];
			btns[i].addActionListener(this);
			pnl.add(btns[i]);
		}
		
		add(pnl);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FindSamePicGame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(restrict==0){
			if(user1!=null&&user2!=null){
				if(!(user1.getText().equals(user2.getText()))){
					user1.setText("");
					user2.setText("");
					user1.setBackground(Color.GRAY);
					user2.setBackground(Color.GRAY);
				}
			}
			
			for(int i=0;i<16;i++){
				if(btns[i].equals(e.getSource())){
					btns[i].setBackground(Color.white);
					btns[i].setText(btnAnswer[i]);
					user1 =btns[i];
				}
			}
			restrict++;
		}else if(restrict==1){
			for(int i=0;i<16;i++){
				if(btns[i].equals(e.getSource())){
					btns[i].setBackground(Color.white);
					btns[i].setText(btnAnswer[i]);
					user2 =btns[i];
				}
			}
			restrict=0;
		}
	}
}
