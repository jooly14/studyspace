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
			//로그아웃 	/메뉴등록		/결제내역		 /마감등록
	JCafeMain mainFrame;
	
	public JCafeManagerMenu(JCafeMain mainFrame){
		this.mainFrame = mainFrame;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		add(new JLabel("관리자 메뉴"),"North");
		
		JPanel pnl_btn = new JPanel();
		btnLogOut = new JButton("로그 아웃");
		btnLogOut.addActionListener(this);
		
		btnNewMenu = new JButton("메뉴 등록");
		btnNewMenu.addActionListener(this);
		
		btnDeadLineRegistration = new JButton("마감 등록");
		btnDeadLineRegistration.addActionListener(this);
		
		btnPaymentData = new JButton("결제 내역");
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
			int confirmChk =JOptionPane.showConfirmDialog(this, "로그아웃 하시겠습니까?","로그아웃",JOptionPane.YES_NO_OPTION);
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

class DeadLineRegistration extends JDialog implements ActionListener{ //마감등록 메뉴
	JButton stock,order,attend,newMenu,exit;
	JCafeManagerMenu jmm;
	
	DeadLineRegistration(){
		
		this.setSize(200,250);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		String str[]={"금일재고등록","발주등록","근태관리","메뉴등록","마감완료"};

		JPanel panel=new JPanel();

		stock=new JButton("금일재고등록");
		order=new JButton("발주등록");
		attend=new JButton("근태관리");
		newMenu=new JButton("메뉴등록");
		exit=new JButton("마감완료");
		
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
		
		//금일 재고 등록과 발주등록을 마친 경우 오렌지 색으로 버튼 색이 변함
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
				JOptionPane.showMessageDialog(this, "금일 재고등록이 완료되지 않았습니다.");
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


