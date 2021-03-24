import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBoxTest2 extends JPanel implements ItemListener{
	JCheckBox[] btns = new JCheckBox[7]; 
	String[] rainbow = {"빨강","주황","노랑","초록","파랑","남색","보라"};
	Color[] rainbowColors = {Color.red,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.blue,new Color(0,0,50),Color.magenta};
	JPanel[] colorPanel = new JPanel[7];
	public CheckBoxTest2(){
		JPanel checkboxPnl = new JPanel();
		for(int i=0; i<7;i++){
			btns[i] = new JCheckBox(rainbow[i]);
			btns[i].addItemListener(this);
			colorPanel[i]= new JPanel();
			colorPanel[i].setBackground(rainbowColors[i]);
			checkboxPnl.add(btns[i]);
		}
		setLayout(new BorderLayout());
		add(checkboxPnl,"North");
		btns[0].setSelected(true);
		add(colorPanel[0]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,200);
		JComponent newContentPane = new CheckBoxTest2();
		frame.setContentPane(newContentPane);
		newContentPane.setOpaque(true);
		frame.setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		Object color = arg0.getItemSelectable();
		for(int i=0;i<7;i++){
			if(color==btns[i]){
				if(arg0.getStateChange()==ItemEvent.DESELECTED){
					this.remove(colorPanel[i]);
				}else{
					this.add(colorPanel[i]);
				}
			}
			repaint();
			revalidate();
			
			
		}
		
	}

}
