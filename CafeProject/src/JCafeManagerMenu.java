import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JCafeManagerMenu extends JDialog implements ActionListener{
	JButton btnLogOut, btnNewMenu, btnPaymentData, btnDeadLineRegistration;
			//로그아웃 	/메뉴등록		/결제내역			/마감등록
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
		pnl_btn.add(btnDeadLineRegistration);
		pnl_btn.add(btnPaymentData);
		pnl_btn.add(btnLogOut);
		add(pnl_btn);
		pack();
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnLogOut){
			int confirmChk =JOptionPane.showConfirmDialog(this, "로그아웃 하시겠습니까?","로그아웃",JOptionPane.YES_NO_OPTION);
			if(confirmChk == JOptionPane.YES_OPTION){
				mainFrame.logOut();
				dispose();
			}
		}else if(e.getSource()==btnNewMenu){
			new JCafenewMenu();
		}else if(e.getSource()==btnDeadLineRegistration){
			//마감등록 했을때
		}else if(e.getSource()==btnPaymentData){
			//결제내역 버튼 눌렀을때
		}
	}
	
	
}
