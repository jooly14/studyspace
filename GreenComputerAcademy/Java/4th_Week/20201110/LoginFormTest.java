import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFormTest extends JFrame implements ActionListener{
	JButton btnLogin;
	JButton btnCancel;
	JTextField tfEmail;
	JPasswordField pwField;
	String email = "abc@def.com";
	String pw = "123";
	public LoginFormTest(){
		setSize(400,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnl = new JPanel(new GridLayout(0,2));
		JLabel lblEmail = new JLabel("이메일");
		JLabel lblPw = new JLabel("비밀번호");
		btnLogin = new JButton("로그인");
		btnCancel = new JButton("취소");
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		tfEmail = new JTextField();
		pwField = new JPasswordField();
		pnl.add(lblEmail);
		pnl.add(tfEmail);
		pnl.add(lblPw);
		pnl.add(pwField);
		pnl.add(btnLogin);
		pnl.add(btnCancel);
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginFormTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnLogin){
			if(tfEmail.getText().equals(email)&&pwField.getText().equals(pw)){
				JOptionPane.showMessageDialog(this, "로그인 되었습니다.");
			}else{
				JOptionPane.showMessageDialog(this, "이메일이나 비밀번호가 잘못 입력되었습니다.");
				tfEmail.selectAll();
				pwField.selectAll();
				tfEmail.requestFocus();
			}
		}else if(e.getSource()==btnCancel){
			System.exit(0);
		}
	}

}
