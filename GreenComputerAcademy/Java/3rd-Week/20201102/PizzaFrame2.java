import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PizzaFrame2 extends JFrame {
	public PizzaFrame2(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new BoxLayout());
		setTitle("피자주문");
		JPanel pa = new JPanel();
		pa.add(new JLabel("어떤 피자를 주문하시겠습니까?"));
		
		JPanel pb = new JPanel();
		pb.setPreferredSize(new Dimension(300,30));
		String[] pizzaList = {"small","regular","large"};
		JComboBox combo = new JComboBox(pizzaList);
		combo.setPreferredSize(new Dimension(250,20));
		pb.add(combo);
		
		JPanel pc = new JPanel();
		pc.add(new JCheckBox("치즈 추가"));
		pc.add(new JCheckBox("피클 추가"));
		pc.add(new JCheckBox("콜라 추가"));
		
		JPanel pd  = new JPanel();
		pd.add(new JButton("OK"));
		pd.add(new JButton("Cancel"));
		JPanel p1 = new JPanel();
		p1.add(pa);
		p1.add(pb);
		p1.add(pc);
		p1.add(pd);
		add(p1);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PizzaFrame2();
	}

}
