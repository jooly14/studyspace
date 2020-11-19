import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JCafeManagerMenu extends JDialog implements ActionListener{
	JButton btnLogOut, btnNewMenu, btnPaymentData, btnDeadLineRegistration;
			//�α׾ƿ� 	/�޴����		/��������		 /�������
	JCafeMain mainFrame;
	public JCafeManagerMenu(JCafeMain mainFrame){
		this.mainFrame = mainFrame;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		add(new JLabel("������ �޴�"),"North");
		
		JPanel pnl_btn = new JPanel();
		btnLogOut = new JButton("�α� �ƿ�");
		btnLogOut.addActionListener(this);
		
		btnNewMenu = new JButton("�޴� ���");
		btnNewMenu.addActionListener(this);
		
		btnDeadLineRegistration = new JButton("���� ���");
		btnDeadLineRegistration.addActionListener(this);
		
		btnPaymentData = new JButton("���� ����");
		btnPaymentData.addActionListener(this);
		
		
		
		pnl_btn.add(btnNewMenu);
		pnl_btn.add(btnPaymentData);
		pnl_btn.add(btnDeadLineRegistration);
		pnl_btn.add(btnLogOut);
		add(pnl_btn);
		pack();
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogOut){
			int confirmChk =JOptionPane.showConfirmDialog(this, "�α׾ƿ� �Ͻðڽ��ϱ�?","�α׾ƿ�",JOptionPane.YES_NO_OPTION);
			if(confirmChk == JOptionPane.YES_OPTION){
				mainFrame.logOut();
				dispose();
			}
		}else if(e.getSource()==btnNewMenu){
			new JCafenewMenu(this);
		}else if(e.getSource()==btnDeadLineRegistration){
			new DeadLineRegistration();
		}else if(e.getSource()==btnPaymentData){
			new JCafeCloseSale();
		}
	}
	
	
}
class DeadLineRegistration extends JDialog implements ActionListener{ //������� �޴�
	JButton stock,order,attend,blank,exit;

	DeadLineRegistration(){
		
		this.setSize(200,250);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		String str[]={"���������","���ֵ��","���°���","blank","�����Ϸ�"};

		JPanel panel=new JPanel();

		stock=new JButton("���������");
		order=new JButton("���ֵ��");
		attend=new JButton("���°���");
		blank=new JButton("");
		exit=new JButton("�����Ϸ�");
		
		Color color=new Color(255,228,225);
		panel.setBackground(color.white);
		
		stock.setBackground(color);
		order.setBackground(color);
		attend.setBackground(color);
		blank.setBackground(color);
		exit.setBackground(color);
		
		stock.addActionListener(this);
		order.addActionListener(this);
		attend.addActionListener(this);
		blank.addActionListener(this);
		exit.addActionListener(this);
		
		panel.setLayout(new GridLayout(0,1,10,10));
		panel.add(stock);
		panel.add(order);
		panel.add(attend);
		panel.add(blank);
		panel.add(exit);
		
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==stock){
			new JCafeDeadLineList();
		}
		else if(e.getSource()==order){
			
		}
		else if(e.getSource()==attend){
			
		}
		else if(e.getSource()==blank){
			
		}
		else if(e.getSource()==exit){
			
		}
		
	}
}
