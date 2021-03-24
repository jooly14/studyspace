import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	JCafeNewMenuPnl nmp;
	JCafeManagerMenu c;
	JCafeManagerMenu(JCafeManagerMenu c, JCafeNewMenuPnl nmp){
		this.nmp = nmp;
		this.c = c;
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
			new JCafenewMenu(c, nmp);
		}else if(e.getSource()==btnDeadLineRegistration){
			new DeadLineRegistration();
		}else if(e.getSource()==btnPaymentData){
			new JCafeCloseSale();
		}
	}
}

class DeadLineRegistration extends JDialog implements ActionListener{ //������� �޴�
	JButton stock,order,attend,newMenu,exit;
	JCafeManagerMenu jmm;
	
	DeadLineRegistration(){
		
		this.setSize(200,250);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		String str[]={"���������","���ֵ��","���°���","�޴����","�����Ϸ�"};

		JPanel panel=new JPanel();

		stock=new JButton("���������");
		order=new JButton("���ֵ��");
		attend=new JButton("���°���");
		newMenu=new JButton("�޴����");
		exit=new JButton("�����Ϸ�");
		
		Color color=new Color(255,228,225);
		panel.setBackground(color.white);
		
		stock.setBackground(color);
		order.setBackground(color);
		attend.setBackground(color);
		newMenu.setBackground(color);
		exit.setBackground(color);
		
		stock.addActionListener(this);
		order.addActionListener(this);
		attend.addActionListener(this);
		newMenu.addActionListener(this);
		exit.addActionListener(this);
		
		//���� ��� ��ϰ� ���ֵ���� ��ģ ��� ������ ������ ��ư ���� ����
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);
		
		File dir = new File("./jcafe_"+dt+"/deadlinelist.txt");
		if (dir.exists()) {
			stock.setBackground(Color.orange);
		}
				
		File dir2 = new File("./jcafe_order_registration/"+dt+"_orderlist.txt");
		if (dir2.exists()) {
			order.setBackground(Color.orange);
		}
		
		panel.setLayout(new GridLayout(0,1,10,10));
		panel.add(stock);
		panel.add(order);
		panel.add(attend);
		panel.add(newMenu);
		panel.add(exit);
		
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	DeadLineRegistration(JCafeManagerMenu jmm){
		this.jmm = jmm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==stock){
			new JCafeDeadLineList();
			dispose();
		}
		else if(e.getSource()==order){
			Date date = new Date();
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			String dt = transFormat.format(date);
			
			File dir = new File("./jcafe_"+dt+"/deadlinelist.txt");
			if (dir.exists()) {
				new JCafeSpinner();
				dispose();
			}else{
				JOptionPane.showMessageDialog(this, "���� ������� �Ϸ���� �ʾҽ��ϴ�.");
			}
		}
		else if(e.getSource()==attend){
//			c=new JCafeTotalPay(this);
		}
		else if(e.getSource()==newMenu){
			new JCafeNewMenuPnl();
		}
		else if(e.getSource()==exit){
//			c.totalSave();
		}
		
	}
}


