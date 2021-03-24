import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreeEventTest extends JFrame implements ActionListener{
	JTextField tf;
	JButton btnAdd;
	JButton btnDel;
	JPanel pnl;
	JPanel pnlN;
	JTree tree;
	public TreeEventTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("홈");
		
		tf = new JTextField(12);
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		pnl = new JPanel();
		tree = new JTree(root);
		pnl.add(tree);
		
		pnlN = new JPanel();
		pnlN.add(tf);
		pnlN.add(btnAdd);
		
		
		
		add(pnlN,"North");
		add(btnDel,"South");
		add(tree);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreeEventTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(tf.getText());
		TreePath path = tree.getSelectionPath();
		DefaultMutableTreeNode selNode = (DefaultMutableTreeNode)path.getLastPathComponent();
		if(e.getSource()==btnAdd){
			((DefaultTreeModel)(tree.getModel())).insertNodeInto(node,selNode, selNode.getChildCount());
			//tree.expandPath(path);
			//tree.collapsePath(path);
			
		}else{
			((DefaultTreeModel)(tree.getModel())).removeNodeFromParent(selNode);
		}
	}

}
