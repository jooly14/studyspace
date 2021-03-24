import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CheckBoxTest1 extends JPanel implements ItemListener{
	JLabel[] pictureLabel = new JLabel[3];
	JCheckBox[] buttons = new JCheckBox[3];
	String[] fruits = {"apple","grape","orange"};
	ImageIcon[] icon = new ImageIcon[3];
	
	public CheckBoxTest1(){
		super(new GridLayout(0,4));
		for(int i =0; i<3;i++){
			buttons[i] = new JCheckBox(fruits[i]);
			buttons[i].addItemListener(this);
			pictureLabel[i] = new JLabel(fruits[i]+".jpg");
			icon[i] = new ImageIcon(fruits[i]+".jpg");
		}
		JPanel checkPanel = new JPanel(new GridLayout(0,1));
		for(int i=0;i<3;i++){
			checkPanel.add(buttons[i]);
		}
		
		add(checkPanel);
		add(pictureLabel[0]);
		add(pictureLabel[1]);
		add(pictureLabel[2]);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		ImageIcon image = null;
		
		Object source = e.getItemSelectable();
		for(int i=0;i<3;i++){
			if(source== buttons[i]){
				if(e.getStateChange()==ItemEvent.DESELECTED){
					pictureLabel[i].setIcon(null);
				}else{
					pictureLabel[i].setIcon(icon[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new CheckBoxTest1();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.setSize(700,200);
		frame.setVisible(true);
	}
}
