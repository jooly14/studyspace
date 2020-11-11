import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class ComboBoxTest2 extends JFrame implements ActionListener{
	JComboBox combo;
	JLabel lbl;
	String[] str = {"개","고양이","원숭이"};
	String[] name = {"dog","cat2","monkey"};
	ImageIcon[] icon = new ImageIcon[3];
	public ComboBoxTest2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setTitle("콤보박스 테스트");
		
		combo = new JComboBox(str);
		combo.addActionListener(this);
		lbl = new JLabel("선택하세요");
		makeImage(0);
		makeImage(1);
		makeImage(2);
		
		
		add(combo,"North");
		add(lbl);
		setVisible(true);
	}
	void makeImage(int i){
		icon[i] = new ImageIcon(name[i]+".png");
		changeSize(i);
	}
	void changeSize(int i){
		Image img = icon[i].getImage();
		img = img.getScaledInstance(280, 200, Image.SCALE_SMOOTH);
		icon[i]= new ImageIcon(img);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComboBoxTest2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(combo.getSelectedIndex()==0){
			lbl.setIcon(icon[0]);
		}else if(combo.getSelectedIndex()==1){
			lbl.setIcon(icon[1]);
		}else if(combo.getSelectedIndex()==2){
			lbl.setIcon(icon[2]);
		}
		lbl.setText("");
	}

}
