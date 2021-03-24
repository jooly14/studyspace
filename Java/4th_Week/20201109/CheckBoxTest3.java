import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBoxTest3 extends JFrame implements ItemListener{
	JCheckBox[] btns = new JCheckBox[7]; 
	String[] rainbow = {"빨강","주황","노랑","초록","파랑","남색","보라"};
	Color[] rainbowColors = {Color.red,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.blue,new Color(0,0,50),Color.magenta};
	JPanel[] colorPanel = new JPanel[7];
	
	public CheckBoxTest3(){
		JPanel checkboxPnl = new JPanel();
		for(int i=0; i<7;i++){
			btns[i] = new JCheckBox(rainbow[i]);
			btns[i].addItemListener(this);
			colorPanel[i]= new JPanel();
			colorPanel[i].setBackground(rainbowColors[i]);
			checkboxPnl.add(btns[i]);
		}
		add(checkboxPnl,"North");
		btns[0].setSelected(true);
		add(colorPanel[0]);
		
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RadioButtonTest2();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		Object color = arg0.getItemSelectable();
		
		for(int i=0;i<7;i++){
			if(btns[i].isSelected()){
				this.add(colorPanel[i]);
			}else{
				this.remove(colorPanel[i]);
			}
		}
			
		repaint();
		revalidate();
	}
		
		
}


