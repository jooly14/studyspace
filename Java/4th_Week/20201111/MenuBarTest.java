import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBarTest extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu menu1;
	JMenu menu2;
	JMenu info;
	JMenuItem item1;
	JMenuItem item2;
	JMenuItem item3;
	JMenuItem item4;
	public MenuBarTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		menu1 = new JMenu("파일");
		item1 = new JMenuItem("Open File");
		item2 = new JMenuItem("Save File");
		item3 = new JMenuItem("Close");
		item3.addActionListener(this);
		menu1.add(item1);
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		
		menu2 = new JMenu("편집");
		info = new JMenu("정보");
		item4 = new JMenuItem("서브 정보");
		info.add(item4);
		
		bar = new JMenuBar();
		bar.add(menu1);
		bar.add(menu2);
		menu1.add(info);
		setJMenuBar(bar);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuBarTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==item3){
			int i =JOptionPane.showConfirmDialog(this, "종료하시겠습니까?");
			if(i==JOptionPane.OK_OPTION){
				System.exit(0);
			}
		}
	}

}
