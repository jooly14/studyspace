import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class TabTest extends JFrame{
	JTabbedPane tab;
	JPanel pnl;
	JButton btn1, btn2, btn3;
	JTextArea ta;
	JLabel lbl;
	public TabTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		
		tab = new JTabbedPane();
		pnl = new JPanel();
		
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		
		ta = new JTextArea("abcdef");
		lbl = new JLabel("글씨 글씨");
		
		pnl.add(btn1);
		pnl.add(btn2);
		pnl.add(btn3);
		
		tab.add("패널", pnl);
		tab.add("텍스트에어리어",ta);
		tab.add("레이블", lbl);
		
		add(tab);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TabTest();
	}

}
