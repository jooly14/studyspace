import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//방법1 : 테이블에서 데이터를 하나하나 받아와서 쓰는 방법
class TableDialogRead extends JDialog implements ActionListener{
	JLabel num, title, name, date, content;
	JButton btn;
	public TableDialogRead(BoardTest2 frame, String[] data){
		super(frame, true);
		setSize(300,300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		
		JPanel pnl = new JPanel(new GridLayout(0, 1));
		num = new JLabel("글번호: "+data[0]);
		title = new JLabel("제목: "+data[1]);
		name = new JLabel("글쓴이: "+data[2]);
		date = new JLabel("날짜: "+data[3]);
		content = new JLabel("내용: "+data[4]);
		
		
		pnl.add(num);
		pnl.add(title);
		pnl.add(name);
		pnl.add(date);
		pnl.add(content);
		add(pnl);
		
		
		btn = new JButton("닫기");
		btn.addActionListener(this);
		add(btn,"South");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dispose();
	}
}
//방법2 : frame.content 하나에 모든 데이터를 넣는다. 구분할 수 있는 문자(Ex. /)를 사용한다.
//문자열 하나로 된 데이터를 받아서 사용한다.
//split 메서드를 활용한다.
class TableDialogRead2 extends JDialog implements ActionListener{
	JLabel num, title, name, date, content;
	JButton btn;
	public TableDialogRead2(BoardTest2 frame, String inData){
		super(frame, true);
		setSize(300,300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		String[] data = inData.split("/");
		JPanel pnl = new JPanel(new GridLayout(0, 1));
		num = new JLabel("글번호: "+data[0]);
		title = new JLabel("제목: "+data[1]);
		name = new JLabel("글쓴이: "+data[2]);
		date = new JLabel("날짜: "+data[3]);
		content = new JLabel("내용: "+data[4]);
		
		
		pnl.add(num);
		pnl.add(title);
		pnl.add(name);
		pnl.add(date);
		pnl.add(content);
		add(pnl);
		
		
		btn = new JButton("닫기");
		btn.addActionListener(this);
		add(btn,"South");
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dispose();
	}
}

class TableDialogWrite extends JDialog implements ActionListener{
	JButton btn;
	JTextField title, name, date;
	JTextArea content;
	BoardTest2 frame;
	public TableDialogWrite(BoardTest2 frame){
		super(frame, true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400,400);
		this.frame = frame;
		JPanel pnl = new JPanel(new GridLayout(0, 2));
		JLabel lblTitle = new JLabel("제목");
		JLabel lblName = new JLabel("글쓴이");
		JLabel lblDate = new JLabel("날짜");
		JLabel lblContent = new JLabel("내용");
		title = new JTextField();
		name = new JTextField();
		date = new JTextField(new Date()+"");
		date.setEditable(false);
		content = new JTextArea();
		pnl.add(lblTitle);
		pnl.add(title);
		pnl.add(lblName);
		pnl.add(name);
		pnl.add(lblDate);
		pnl.add(date);
		pnl.add(lblContent);
		pnl.add(content);
		add(pnl);
		
		btn = new JButton("닫기");
		btn.addActionListener(this);
		add(btn,"South");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String[] data = new String[4];
		data[0] = title.getText();
		data[1] = name.getText();
		data[2] = date.getText();
		data[3] = content.getText();
		
		frame.setData(data);
		dispose();
	}
}
public class BoardTest2 extends JFrame implements ActionListener,MouseListener{
	JTable table;
	JLabel titleLbl;
	JButton btn;
	private DefaultTableModel model;
	String[] header ={"번호","제목","글쓴이","날짜"};
	String[][] contents = {};
	int idx;
	String[] content = new String[100];
	void setData(String[] data){
		String[] inData = new String[4];
		inData[0] = (idx+1)+"";
		inData[1] = data[0];
		inData[2] = data[1];
		inData[3] = data[2];
		//content[idx] = data[3];
		
		content[idx] = inData[0]+"/"+inData[1]+"/"+inData[2]+"/"+inData[3]+"/"+data[3];
		
		
		model.addRow(inData);
		idx++;
	}
	public BoardTest2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		
		titleLbl = new JLabel("게시판");
		add(titleLbl,"North");
		
		
		model = new DefaultTableModel(contents,header);
		table = new JTable(model);
		table.addMouseListener(this);
		JScrollPane tablepnl = new JScrollPane(table);
		add(tablepnl);
		
		
		btn = new JButton("글쓰기");
		btn.addActionListener(this);
		add(btn,"South");
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardTest2();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int selRow = table.getSelectedRow();
		/*String boData[] = new String[5];
		boData[0] = (String)table.getValueAt(selRow, 0);
		boData[1] = (String)table.getValueAt(selRow, 1);
		boData[2] = (String)table.getValueAt(selRow, 2);
		boData[3] = (String)table.getValueAt(selRow, 3);
		boData[4] = content[selRow];
		new TableDialogRead2(this, boData);*/
		new TableDialogRead2(this, content[selRow]);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new TableDialogWrite(this);
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}
