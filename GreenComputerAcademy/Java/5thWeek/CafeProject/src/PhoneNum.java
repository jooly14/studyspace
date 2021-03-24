import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PhoneNum extends JFrame implements ActionListener{
	JButton[] pN_btn = new JButton[15];
	String[] pN_buttons = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "����", "����", "�ʱ�ȭ", "���"};
	JLabel[] pN_lb = new JLabel[13];
	String[] pN_dash = {"_","_","_","-","_","_","_","_","-","_","_","_","_"};
	JPanel pN_pnl, pN_pnlN;
	JLabel[] pN_numbers;
	int pN_cnt;
	
	PhoneNum(){
		this.setSize(250,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pN_pnl = new JPanel(new GridLayout(0, 3, 1, 1));
		for(int i = 0; i < pN_buttons.length; i++){
		pN_btn[i] = new JButton(pN_buttons[i]);
		pN_btn[i].addActionListener(this);
		pN_pnl.add(pN_btn[i]);
		}
		
		pN_pnlN = new JPanel();
		for(int i = 0; i < pN_dash.length; i++){
		pN_lb[i] = new JLabel(pN_dash[i]);
		pN_pnlN.add(pN_lb[i]);
		}
		
		this.add(pN_pnl);
		this.add(pN_pnlN, "North");
		
		this.setVisible(true);
	}
	
	void getNum(){					//'-'�� �� �迭�� '-'�� ���� �迭�� ����
		pN_numbers = new JLabel[11];
		pN_numbers[0] = pN_lb[0];
		pN_numbers[1] = pN_lb[1];
		pN_numbers[2] = pN_lb[2];
		pN_numbers[3] = pN_lb[4];
		pN_numbers[4] = pN_lb[5];
		pN_numbers[5] = pN_lb[6];
		pN_numbers[6] = pN_lb[7];
		pN_numbers[7] = pN_lb[9];
		pN_numbers[8] = pN_lb[10];
		pN_numbers[9] = pN_lb[11];
		pN_numbers[10] = pN_lb[12];
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pN_cbtn = (JButton)e.getSource();	
		
		getNum();
		
		if(pN_cbtn == pN_btn[11]){			//'����'
			pN_cnt--;
			pN_numbers[pN_cnt].setText("_");
		}else if(pN_cbtn == pN_btn[12]){		//'����'
			int pN_stamp = 1;
			
			int pN_dashCount = 0;
			
			for(int i = 0; i < 11; i++){
				String a = pN_numbers[i].getText();
				if(a == "_"){
					pN_dashCount++;
				}
			}
			if(pN_dashCount > 1){
				JOptionPane.showMessageDialog(this, "��ȣ�� �Է����ּ���.", "���", JOptionPane.WARNING_MESSAGE);
			}else if(pN_dashCount == 0){
//				[ 10,000 ������ ������ 1��  (��)-> 20,000~29,000�����̴� ������2�� ]
//				int x = 0;
//				x = x + 10000;
//				if(moneyTotal >= (x)){
//					stamp++;
//				}
				JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�. \n ������ : "+ pN_stamp);
				dispose();
			}
			
			
		}else if(pN_cbtn == pN_btn[13]){		//'�ʱ�ȭ'
			for(int i = 0; i < pN_numbers.length; i++){
				pN_numbers[i].setText("_");
				pN_cnt = 0;
			}
		}else if(pN_cbtn == pN_btn[14]){		//'���'
			dispose();
		}else if(pN_cbtn == pN_btn[9]){		//��ĭ(�ƹ���ɾ���)
			pN_numbers[pN_cnt].setText("_");
		}else if(pN_cbtn == pN_btn[10]){		//���� '0'
			pN_numbers[pN_cnt].setText(pN_cbtn.getActionCommand());
			pN_cnt++;
		}else{									//����'1~9' == btn[0]~btn[8]
			pN_numbers[pN_cnt].setText(pN_cbtn.getActionCommand());
			pN_cnt++;
		}
	}
	
	public static void main(String[] args) {
		new PhoneNum();
	}
}
