import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JCafeManagerLoginDialog extends JDialog implements ActionListener{
	JButton btnOk, btnCancel;
	String id = "1234";	//�ӽ� ���̵�
	String pw = "1234";	//�ӽ� ��й�ȣ
	JTextField idTf;
	JPasswordField pwF;
	JCafeMain mainFrame;
	
	public JCafeManagerLoginDialog(JCafeMain mainFrame){
		this.mainFrame = mainFrame;
		setTitle(" ������ �α��� ");
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		JPanel pnlId = new JPanel();
		JPanel pnlPw = new JPanel();
		idTf = new JTextField(15);
		pwF = new JPasswordField(15);
		
		pnlId.add(new JLabel("���̵�      :   "));
		pnlId.add(idTf);
		pnlPw.add(new JLabel("��й�ȣ  :   "));
		pnlPw.add(pwF);
		pnlCenter.add(pnlId);
		pnlCenter.add(pnlPw);
		
		btnOk = new JButton("�α���");
		btnCancel = new JButton("���");
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		JPanel pnlOKCancel = new JPanel();
		pnlOKCancel.add(btnOk);
		pnlOKCancel.add(btnCancel);
		add(pnlCenter);
		add(pnlOKCancel,"South");
		add(new JPanel(),"North");	//���� ������ �ٿ���
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300,180);
		setVisible(true);
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk){
			if(idTf.getText().equals(id)&&pwF.getText().equals(pw)){
				JOptionPane.showMessageDialog(this, "�α��εǾ����ϴ�.");
				mainFrame.logIn();
				new JCafeManagerMenu(mainFrame);
				dispose();
			}else{
				JOptionPane.showMessageDialog(this, "���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				idTf.selectAll();
				pwF.setText("");
				idTf.requestFocus();
			}
		}else{
			dispose();
		}
	}

}
