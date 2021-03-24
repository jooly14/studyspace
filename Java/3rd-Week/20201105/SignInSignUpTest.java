import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//JOptionPane의 활용
public class SignInSignUpTest extends JFrame implements ActionListener{
	String id = "abc";
	String pw= "123";
	JTextField idTf;
	JTextField pwTf;
	JButton signInBtn;
	JButton signUpBtn;
	
	public SignInSignUpTest(){
		init();
	}
	void init(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1));
		
		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		JPanel pnl3 = new JPanel();
		idTf = new JTextField(15);
		pwTf = new JTextField(15);
		JLabel lblEmpty1 = new JLabel("    ");
		JLabel lblEmpty2 = new JLabel("");
		JLabel idLbl = new JLabel("아이디");
		JLabel pwLbl = new JLabel("비밀번호");
		pnl1.add(idLbl);
		pnl1.add(lblEmpty1);
		pnl1.add(idTf);
		pnl2.add(pwLbl);
		pnl2.add(lblEmpty2);
		pnl2.add(pwTf);
		
		signInBtn = new JButton("로그인");
		signInBtn.addActionListener(this);
		signUpBtn = new JButton("회원가입");
		pnl3.add(signInBtn);
		pnl3.add(signUpBtn);
		
		add(pnl1);
		add(pnl2);
		add(pnl3);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(this,"눌렀다.");
		new SignInSignUpTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==signInBtn){
			if(idTf.getText().equals(id)&&pwTf.getText().equals(pw)){
				JOptionPane.showMessageDialog(this, "로그인되었습니다.");
			}else{
				JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
				idTf.setText("");
				pwTf.setText("");
			}
		}
	}

}
