import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeTest extends JFrame{
	JTree tree;
	JPanel pnl;
	
	public TreeTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		pnl = new JPanel();
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("나의 문서함");
		DefaultMutableTreeNode sub1 = new DefaultMutableTreeNode("편지");
		DefaultMutableTreeNode sub2 = new DefaultMutableTreeNode("음악");
		DefaultMutableTreeNode sub2_1 = new DefaultMutableTreeNode("한국");
		DefaultMutableTreeNode sub2_1_1 = new DefaultMutableTreeNode("트로트");
		DefaultMutableTreeNode sub2_2 = new DefaultMutableTreeNode("외국");
		DefaultMutableTreeNode sub3 = new DefaultMutableTreeNode("소설");
		DefaultMutableTreeNode sub3_1 = new DefaultMutableTreeNode("추리");
		tree = new JTree(root);
		root.add(sub1);
		root.add(sub2);
		sub2.add(sub2_1);
		sub2.add(sub2_2);
		sub2_1.add(sub2_1_1);
		root.add(sub3);
		sub3.add(sub3_1);
		pnl.add(tree);
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreeTest();
	}

}
