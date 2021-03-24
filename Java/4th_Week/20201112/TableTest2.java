import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableTest2 extends JFrame implements ActionListener{
	JButton insertBtn;
	JButton deleteBtn;
	JTextField tf;
	JPanel pnlS;
	JTable table;
	String[] header = {"번호","아이디","비밀번호"};
	String[][] contents = {};
	DefaultTableModel tablemodel;
	int idx; 
	public TableTest2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		
		insertBtn = new JButton("추가");
		deleteBtn = new JButton("삭제");
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		tf = new JTextField(15);
		pnlS = new JPanel();
		pnlS.add(tf);
		pnlS.add(insertBtn);
		pnlS.add(deleteBtn);
		tablemodel = new DefaultTableModel(contents, header);
		table = new JTable(tablemodel);
		JScrollPane sp = new JScrollPane(table);
		
		add(sp);
		add(pnlS,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TableTest2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==insertBtn){
			String[] str = new String[3];
			str[0] = idx+"";
			str[1] = tf.getText(); 
			str[2] = "1234"; 
			tablemodel.addRow(str);
			idx++;
			tf.selectAll();
			tf.requestFocus();
		}else{
			//tablemodel.removeRow(tablemodel.getRowCount()-1);	//마지막 줄 지우기
			
			//선택한 줄 지우기
			int selRow = table.getSelectedRow();
			tablemodel.removeRow(selRow);
		
		}
	}

}
