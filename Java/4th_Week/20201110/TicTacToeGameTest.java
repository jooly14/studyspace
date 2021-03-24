import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeGameTest extends JFrame implements ActionListener{
	JButton[] btns= new JButton[9];
	JLabel lbl;
	int[] winnerChk = {3,4,5,6,7,8,9,10,11};
	int total;
	int turn;
	public TicTacToeGameTest(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(0,3));
		for(int i=0;i<9;i++){
			btns[i] = new JButton();
			btns[i].addActionListener(this);
			pnl.add(btns[i]);
		}
		lbl = new JLabel(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		
		add(lbl,"South");
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TicTacToeGameTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++){
			if(btns[i].equals(e.getSource())){
				if(turn==0){
					if(btns[i].getText().equals("")){
						btns[i].setText("X");
						turn++;
						lbl.setText("O의 차례입니다.");
						winnerChk[i] = 1;
						total++;
					}
				}else if(turn==1){
					if(btns[i].getText().equals("")){
						btns[i].setText("O");
						turn=0;
						lbl.setText("X의 차례입니다.");
						winnerChk[i] = 2;
						total++;
					}
				}
			}
		}
		
		if(winnerChk[0]==winnerChk[1]&&winnerChk[1]==winnerChk[2]){
			winner(0);
		}else if(winnerChk[3]==winnerChk[4]&&winnerChk[3]==winnerChk[5]){
			winner(3);
		}else if(winnerChk[6]==winnerChk[7]&&winnerChk[6]==winnerChk[8]){
			winner(6);
		}else if(winnerChk[0]==winnerChk[3]&&winnerChk[0]==winnerChk[6]){
			winner(0);
		}else if(winnerChk[1]==winnerChk[4]&&winnerChk[1]==winnerChk[7]){
			winner(1);
		}else if(winnerChk[2]==winnerChk[5]&&winnerChk[2]==winnerChk[8]){
			winner(2);
		}else if(winnerChk[0]==winnerChk[4]&&winnerChk[0]==winnerChk[8]){
			winner(0);
		}else if(winnerChk[2]==winnerChk[4]&&winnerChk[2]==winnerChk[6]){
			winner(2);
		}else if(total==9){
			winner(9);
		}
	}
	void winner(int n){
		String str ="";
		if(n>8){
			str = "무승부입니다.";
			if(turn==1){
				lbl.setText("X의 차례입니다.");
				turn=0;
			}else{
				lbl.setText("O의 차례입니다.");
				turn=1;
			}
		}else{
			if(winnerChk[n]==1){
				str = "X가 승리하였습니다.";
				lbl.setText("X의 차례입니다.");
				turn=0;
			}else{
				
				str = "O가 승리하였습니다.";
				lbl.setText("O의 차례입니다.");
				turn=1;
			}
			
		}
		total =0;
		JOptionPane.showMessageDialog(this, str);
		for(int i=0;i<9;i++){
			btns[i].setText("");
			winnerChk[i]= i+3;
			
		}
	}

}
