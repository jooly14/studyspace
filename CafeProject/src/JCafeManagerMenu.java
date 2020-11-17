import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JCafeManagerMenu extends JDialog implements ActionListener{
	JButton btnLogOut, btnNewMenu, btnPaymentData, btnDeadLineRegistration;
			//�α׾ƿ� 	/�޴����		/��������			/�������
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
			int confirmChk =JOptionPane.showConfirmDialog(this, "�α׾ƿ� �Ͻðڽ��ϱ�?","�α׾ƿ�",JOptionPane.YES_NO_OPTION);
			if(confirmChk == JOptionPane.YES_OPTION){
				mainFrame.logOut();
				dispose();
			}
		}else if(e.getSource()==btnNewMenu){
			new JCafenewMenu();
		}else if(e.getSource()==btnDeadLineRegistration){
			//������� ������
		}else if(e.getSource()==btnPaymentData){
			//�������� ��ư ��������
		}
	}
	
	
}
