import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PhoneNum extends JFrame implements ActionListener{
	JButton[] btn = new JButton[15];
	String[] buttons = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "����", "����", "�ʱ�ȭ", "���"};
	JTextField tf;
	JPanel pnl;
	String tmp = "";
	
	PhoneNum(){
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pnl = new JPanel(new GridLayout(0, 3, 1, 1));
		for(int i = 0; i < buttons.length; i++){
		btn[i] = new JButton(buttons[i]);
		btn[i].addActionListener(this);
		pnl.add(btn[i]);
		}
		tf = new JTextField();
		
		this.add(pnl);
		this.add(tf, "North");
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for(int i = 0; i < 11; i++){
			if(arg0.getSource() == btn[i]){
				//����
				tmp = tmp + (btn[i].getText());
				tf.setText(tmp);
			}
		}
		if(arg0.getSource() == btn[11]){
			//����
			int t = tf.getText().length();
				if(t == 0){
					tf.setText("");
				}else if(t >0){
					String back = tf.getText().substring(0, (t-1));
					tf.setText(back);
					tmp = tf.getText();
				}
		}else if(arg0.getSource() == btn[12]){
			//����
			int stamp = 0;
			JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�. \n ������ : "+ stamp);
		
		}else if(arg0.getSource() == btn[13]){
			//�ʱ�ȭ
			tf.setText("");
			tmp = "";
		
		}else if(arg0.getSource() == btn[14]){
			//���
			dispose();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new PhoneNum();
	}
}
