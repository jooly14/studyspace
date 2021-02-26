import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class P11 extends JFrame implements ActionListener{
	JTextField idTf;
	JPasswordField pwF;
	JLabel idLbl, pwLbl;
	JButton loginBtn;
	public P11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(320,200);
		setTitle("My First Swing Example");
		idTf = new JTextField();
		pwF = new JPasswordField();
		idLbl = new JLabel("User");
		pwLbl = new JLabel("Password");
		loginBtn = new JButton("Login");
		loginBtn.addActionListener(this);
		setLayout(null);
		idLbl.setBounds(30, 20, 100, 30);
		pwLbl.setBounds(30, 70, 100, 30);
		idTf.setBounds(120, 20, 150, 30);
		pwF.setBounds(120, 70, 150, 30);
		loginBtn.setBounds(75, 120, 150, 30);
		add(idLbl);
		add(pwLbl);
		add(idTf);
		add(pwF);
		add(loginBtn);
		setVisible(true);
	}
	public static void main(String[] args) {
		new P11();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = idTf.getText();
		String pw = String.valueOf(pwF.getPassword());
		JOptionPane.showMessageDialog(this, "id : "+id +" / pw :"+pw);
	}
}
