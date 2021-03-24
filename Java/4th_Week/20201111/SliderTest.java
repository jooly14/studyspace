import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest extends JFrame implements ChangeListener{
	JSlider slider;
	JLabel lbl;
	ImageIcon icon;
	int width = 10;
	int height = 10;
	JPanel pnl1;
	JPanel pnl2;
	public SliderTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		pnl1 = new JPanel();
		
		
		slider = new JSlider(0, 30, 15);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.addChangeListener(this);
		//slider.setOrientation(JSlider.VERTICAL);
		
		changeSize(15);
		lbl = new JLabel(icon);
		
		pnl1.setLayout(new FlowLayout());
		pnl1.add(new JLabel("슬라이더를 움직여보세요"));
		pnl1.add(slider);
		add(pnl1,"North");
		add(lbl);
		setVisible(true);
	}
	void changeSize(int i){
		if(i==0){
			i=1;
		}
		icon = new ImageIcon("monkey.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(width*i, height*i, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SliderTest();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int size = slider.getValue();
		changeSize(size);
		lbl.setIcon(icon);
	}

}
