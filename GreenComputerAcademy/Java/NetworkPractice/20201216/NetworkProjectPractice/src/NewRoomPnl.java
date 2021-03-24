import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NewRoomPnl extends JPanel{
	JTable table_user;
	JTextArea ta;
	JTextField tf;
	DefaultTableModel model;
	String[] header = {"접속자"};
	String[][] content = {};
	JButton exitBtn;
	
	ChatClientPrac chatClientPrac;
	public NewRoomPnl(ChatClientPrac chatClientPrac) {
		this.chatClientPrac = chatClientPrac;
		model = new DefaultTableModel(content, header);
		table_user = new JTable(model);
		JScrollPane table_pane = new JScrollPane(table_user);
		table_pane.setBounds(600, 0, 200, 530);
		
		tf = new JTextField();
		tf.addActionListener(chatClientPrac);
		tf.setBounds(0, 400, 600, 30);
		ta =  new JTextArea();
		JScrollPane pane = new JScrollPane(ta);
		pane.setBounds(0, 0, 600, 400);
		add(table_pane);
		add(pane);
		add(tf);
		
		exitBtn = new JButton("나가기");
		exitBtn.setBounds(0, 500, 150, 50);
		exitBtn.addActionListener(chatClientPrac);
		
		add(exitBtn);
		
		setLayout(null);
		setVisible(true);
	}
}
