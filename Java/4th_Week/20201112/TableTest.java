import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame{
	JTable table;
	public TableTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		String[] header = {"이름","주소","나이","가입여부"};
		String[][] contents = {{"김철수","서울","24","false"},
								{"김영희","부산","25","true"},
								{"이혜정","서울","32","false"}};
		table = new JTable(contents,header);
		JScrollPane sp = new JScrollPane(table);
		add(sp);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TableTest();
	}

}
