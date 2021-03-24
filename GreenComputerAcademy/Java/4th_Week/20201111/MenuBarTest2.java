import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

public class MenuBarTest2 extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu menu1;
	JMenu menu2;
	JMenu submenu;
	JMenuItem item1;
	JMenuItem item2;
	JMenuItem subitem1;
	JMenuItem subitem2;
	public MenuBarTest2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		bar = new JMenuBar();
		menu1 = new JMenu("첫번째 메뉴");
		menu2 = new JMenu("두번째 메뉴");
		submenu = new JMenu("서브메뉴");
		
		ImageIcon icon = new ImageIcon("monkey.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		bar.add(menu1);
		bar.add(menu2);
		
		item1 = new JMenuItem("메뉴 항목1");
		item1.addActionListener(this);
		item1.setMnemonic(KeyEvent.VK_M);
		KeyStroke ctrlVKeyStroke = KeyStroke.getKeyStroke("alt M");
	    item1.setAccelerator(ctrlVKeyStroke);
		item2 = new JMenuItem("메뉴 항목2",icon);
		
		JRadioButton radiobtn1 = new JRadioButton("라디오 버튼 메뉴 항목1");
		JRadioButton radiobtn2 = new JRadioButton("라디오 버튼 메뉴 항목2");
		ButtonGroup g = new ButtonGroup();
		g.add(radiobtn1);
		g.add(radiobtn2);
		
		JCheckBox checkbox1 = new JCheckBox("체크 박스 메뉴 항목1");
		JCheckBox checkbox2 = new JCheckBox("체크 박스 메뉴 항목2");
		
		subitem1 = new JMenuItem("서브 메뉴 항목1");
		subitem1.addActionListener(this);
		subitem1.setMnemonic(KeyEvent.VK_1);
		KeyStroke stroke = KeyStroke.getKeyStroke("alt 1");
		subitem1.setAccelerator(stroke);
		subitem2 = new JMenuItem("서브 메뉴 항목2");
		submenu.add(subitem1);
		submenu.add(subitem2);
		
		menu1.add(item1);
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(radiobtn1);
		menu1.add(radiobtn2);
		menu1.addSeparator();
		menu1.add(checkbox1);
		menu1.add(checkbox2);
		menu1.addSeparator();
		menu1.add(submenu);
		
		setJMenuBar(bar);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuBarTest2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==item1){
			System.out.println("item1이 선택되었습니다.");
		}else if(e.getSource() == subitem1){
			System.out.println("subitem1이 선택되었습니다.");
			
		}
	}

}
