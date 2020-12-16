import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChatNewRoomDialog extends JDialog implements ActionListener{
	JTextField tfname;
	JButton btnOk, btnCancel;
	ChatClientPrac chatClientPrac;
	public ChatNewRoomDialog(ChatClientPrac chatClientPrac) {
		super(chatClientPrac,true);
		this.chatClientPrac = chatClientPrac;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300,200);
		setLayout(null);
		JLabel lblname = new JLabel("대화방 이름");
		lblname.setBounds(0,0,100,50);
		tfname = new JTextField();
		tfname.setBounds(100, 0, 200, 50);
		
		btnOk = new JButton("생성");
		btnCancel = new JButton("취소");
		btnOk.setBounds(50, 100, 100, 50);
		btnCancel.setBounds(150, 100, 100, 50);
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		
		add(lblname);
		add(tfname);
		add(btnOk);
		add(btnCancel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOk){
			chatClientPrac.createRoom(tfname.getText());
			dispose();
		}else if(e.getSource()==btnCancel){
			dispose();
		}
	}
}
