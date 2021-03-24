import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class ListTest2 extends JFrame implements ActionListener{
	JButton inBtn;
	JButton outBtn;
	JList list1;
	JList list2;
	DefaultListModel dlist1;
	DefaultListModel dlist2;

	String[] str = {"서울","쿠웨이트","바그다드","쿠알라룸푸르","도하","베이징","마닐라","하노이","자카르타","예루살렘","다마스쿠스","타슈켄트","도쿄","방콕","싱가포르","뉴델리","테헤란","카트만두","타이베이","카이로","아크라"};
	public ListTest2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLayout(new FlowLayout());
		dlist1 = new DefaultListModel();	//리스트에 있는 값들을 삽입, 삭제하려면 DefaultListModel객체를 따로 만들어서 리스트에 넣어야된다.
		dlist2 = new DefaultListModel();
		list1 = new JList(dlist1);
		list2 = new JList(dlist2);
		/*
		list1.setPreferredSize(new Dimension(200,300));
		list2.setPreferredSize(new Dimension(200,300));*/
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for(int i=0;i<str.length;i++){
			dlist1.add(i,str[i]);
		}
		
		
		JPanel pnl = new JPanel();
		inBtn = new JButton("➡");
		outBtn = new JButton("⬅");
		inBtn.addActionListener(this);
		outBtn.addActionListener(this);
		pnl.add(inBtn);
		pnl.add(outBtn);
		pnl.setPreferredSize(new Dimension(50,300));
		
		JScrollPane pane1 = new JScrollPane(list1);
		JScrollPane pane2 = new JScrollPane(list2);
		pane1.setPreferredSize(new Dimension(250,300));
		pane2.setPreferredSize(new Dimension(250,300));
		add(pane1);
		add(pnl);
		add(pane2);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListTest2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==inBtn){
			dlist2.addElement(list1.getSelectedValue());
			dlist1.remove(list1.getSelectedIndex());
		}else{
			dlist1.addElement(list2.getSelectedValue());
			dlist2.remove(list2.getSelectedIndex());
		}
	}

}
