import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
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
import javax.swing.table.JTableHeader;
class readDial extends JDialog implements ActionListener{
	JButton closeBtn;
	JLabel tNumLbl;
	JLabel tTitleLbl;
	JLabel tWriterLbl;
	JLabel tDateLbl;
	JLabel tContentLbl;
	JPanel pnlW;
	BoardTest frame;
	JLabel sNumLbl;
	JLabel sTitleLbl;
	JLabel sWriterLbl;
	JLabel sDateLbl;
	JTextArea sContentArea;
	JPanel pnlC;
	JPanel pnlCL;
	public readDial(BoardTest frame){
		super(frame, true);
		this.frame = frame;
		closeBtn = new JButton("닫기");
		closeBtn.addActionListener(this);
		
		
		tNumLbl = new JLabel("글번호:");
		tTitleLbl = new JLabel("제목:");
		tWriterLbl = new JLabel("글쓴이:");
		tDateLbl = new JLabel("날짜:");
		tContentLbl = new JLabel("내용:");
		
		pnlW = new JPanel();
		pnlW.add(new JLabel("            "));
		pnlW.add(tNumLbl);
		pnlW.add(new JLabel("            "));
		pnlW.add(tTitleLbl);
		pnlW.add(new JLabel("            "));
		pnlW.add(tWriterLbl);
		pnlW.add(new JLabel("            "));
		pnlW.add(tDateLbl);
		pnlW.add(new JLabel("            "));
		pnlW.add(tContentLbl);
		pnlW.setPreferredSize(new Dimension(52,400));
		pnlW.setLayout(new FlowLayout(FlowLayout.LEADING,10,4));
		
		sNumLbl = new JLabel();
		sTitleLbl = new JLabel();
		sWriterLbl = new JLabel();
		sDateLbl = new JLabel();
		sContentArea = new JTextArea(8,25);
		JScrollPane sp = new JScrollPane(sContentArea);
		sContentArea.setEditable(false);
		
		pnlCL = new JPanel();
		pnlCL.setPreferredSize(new Dimension(250,180));
		pnlCL.setLayout(new GridLayout(0,1,0,4));
		pnlCL.add(new JLabel("            "));
		pnlCL.add(sNumLbl);
		pnlCL.add(new JLabel("            "));
		pnlCL.add(sTitleLbl);
		pnlCL.add(new JLabel("            "));
		pnlCL.add(sWriterLbl);
		pnlCL.add(new JLabel("            "));
		pnlCL.add(sDateLbl);
		pnlCL.add(new JLabel("            "));
		pnlC = new JPanel();
		pnlC.setLayout(new FlowLayout(FlowLayout.LEADING,30,3));
		pnlC.add(pnlCL);
		pnlC.add(sp);
		
		getRow();
		
		setSize(400,400);
		add(closeBtn,"South");
		add(pnlW,"West");
		add(pnlC);
		setVisible(true);
	}
	void getRow(){
		int selNum = frame.table.getSelectedRow();
		sNumLbl.setText((String)frame.table.getValueAt(selNum, 0));
		sTitleLbl.setText((String)frame.table.getValueAt(selNum, 1));
		sWriterLbl.setText((String)frame.table.getValueAt(selNum, 2));
		sDateLbl.setText((String)frame.table.getValueAt(selNum, 3));
		sContentArea.setText(frame.content[Integer.parseInt((String)frame.table.getValueAt(selNum, 0))]+"                                     ");
		
		/*
		 JLabel sNumLbl;
	JLabel sTitleLbl;
	JLabel sWriterLbl;
	JLabel sDateLbl;
	JLabel sContentLbl;
		 */
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
class writeDial extends JDialog implements ActionListener{
	JButton closeBtn;
	JLabel tTitleLbl;
	JLabel tWriterLbl;
	JLabel tDateLbl;
	JLabel tContentLbl;
	JPanel pnlW;
	BoardTest frame;
	JTextField titelF;
	JTextField writerF;
	JTextField dateF;
	JTextArea contentA;
	JPanel pnlC;
	
	public writeDial(BoardTest frame){
		closeBtn = new JButton("닫기");
		this.frame = frame;
		closeBtn.addActionListener(this);
		
		titelF = new JTextField(25);
		writerF = new JTextField(25);
		dateF = new JTextField(25);
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		dateF.setText(format.format(d));
		dateF.setEditable(false);
		contentA = new JTextArea(10,25);
		JScrollPane consp = new JScrollPane(contentA);
		
		pnlC = new JPanel();
		pnlC.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		pnlC.add(new JLabel("                                                "));
		pnlC.add(titelF);
		pnlC.add(new JLabel("                                                "));
		pnlC.add(writerF);
		pnlC.add(new JLabel("                                                "));
		pnlC.add(dateF);
		pnlC.add(new JLabel("                                                "));
		pnlC.add(consp);
		
		tTitleLbl = new JLabel("제목:");
		tWriterLbl = new JLabel("글쓴이:");
		tDateLbl = new JLabel("날짜:");
		tContentLbl = new JLabel("내용:");
		
		pnlW = new JPanel();
		pnlW.setPreferredSize(new Dimension(52,400));
		pnlW.setLayout(new FlowLayout(FlowLayout.LEADING,10,6));
		pnlW.add(new JLabel("            "));
		pnlW.add(tTitleLbl);
		pnlW.add(new JLabel("            "));
		pnlW.add(tWriterLbl);
		pnlW.add(new JLabel("            "));
		pnlW.add(tDateLbl);
		pnlW.add(new JLabel("            "));
		pnlW.add(tContentLbl);
		
		setSize(400,400);
		add(closeBtn,"South");
		add(pnlW,"West");
		add(pnlC);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String[] rowData = new String[4];
		rowData[0] = frame.idx+"";
		rowData[1] = titelF.getText();
		rowData[2] = writerF.getText();
		rowData[3] = dateF.getText();
		frame.content[frame.idx] = contentA.getText();
		
		frame.model.addRow(rowData);
		/*
		 JTextField titelF;
	JTextField writerF;
	JTextField dateF;
	JTextArea contentA;
		 */
		frame.idx++;
		
		this.dispose();
	}
}
public class BoardTest extends JFrame implements ActionListener,MouseListener{
	JLabel title;
	JPanel titlepnl;
	JTable table;
	DefaultTableModel model;
	JButton writeBtn;
	String[] header ={"번호","제목","글쓴이","날짜"};
	String[][] row = {};
	String[] content = new String[100];
	int idx;
	public BoardTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		
		title = new JLabel("게시판");
		titlepnl = new JPanel();
		
		titlepnl.add(title);
		
		writeBtn = new JButton("글쓰기");
		writeBtn.addActionListener(this);
		
		
		model = new DefaultTableModel(row,header);
		table = new JTable(model);
		table.addMouseListener(this);
		JScrollPane sp = new JScrollPane(table);
		
		JTableHeader h =table.getTableHeader();
		h.setBackground(Color.orange);
		
		add(sp);
		add(writeBtn,"South");
		add(titlepnl,"North");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new writeDial(this);
			
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		new readDial(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
