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
	String id = "1234";	//임시 아이디
	String pw = "1234";	//임시 비밀번호
	JTextField idTf;
	JPasswordField pwF;
	JCafeMain mainFrame;
	
	public JCafeManagerLoginDialog(JCafeMain mainFrame){
		this.mainFrame = mainFrame;
		setTitle(" 관리자 로그인 ");
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		JPanel pnlId = new JPanel();
		JPanel pnlPw = new JPanel();
		idTf = new JTextField(15);
		pwF = new JPasswordField(15);
		
		pnlId.add(new JLabel("아이디      :   "));
		pnlId.add(idTf);
		pnlPw.add(new JLabel("비밀번호  :   "));
		pnlPw.add(pwF);
		pnlCenter.add(pnlId);
		pnlCenter.add(pnlPw);
		
		btnOk = new JButton("로그인");
		btnCancel = new JButton("취소");
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		JPanel pnlOKCancel = new JPanel();
		pnlOKCancel.add(btnOk);
		pnlOKCancel.add(btnCancel);
		add(pnlCenter);
		add(pnlOKCancel,"South");
		add(new JPanel(),"North");	//간격 때문에 붙였음
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300,180);
		setVisible(true);
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk){
			if(idTf.getText().equals(id)&&pwF.getText().equals(pw)){
				JOptionPane.showMessageDialog(this, "로그인되었습니다.");
				mainFrame.logIn();
				new JCafeManagerMenu(mainFrame);
				dispose();
			}else{
				JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
				idTf.selectAll();
				pwF.setText("");
				idTf.requestFocus();
			}
		}else{
			dispose();
		}
	}

}
