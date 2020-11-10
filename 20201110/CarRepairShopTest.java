import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarRepairShopTest extends JFrame implements ActionListener{
	JCheckBox engineOil;
	JCheckBox transmission;
	JCheckBox airconFilter;
	JCheckBox tire;
	JLabel priceLbl;
	int price;
	public CarRepairShopTest(){
		engineOil = new JCheckBox("엔진오일 교환");
		transmission = new JCheckBox("자동변속기오일교환");
		airconFilter = new JCheckBox("에어컨필터교환");
		tire = new JCheckBox("타이어교환");
		engineOil.addActionListener(this);
		transmission.addActionListener(this);
		airconFilter.addActionListener(this);
		tire.addActionListener(this);
		
		priceLbl = new JLabel();
		priceLbl.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 30));
		
		JPanel pnlN = new JPanel();
		JPanel pnlC = new JPanel();
		
		pnlN.add(engineOil);
		pnlN.add(transmission);
		pnlN.add(airconFilter);
		pnlN.add(tire);
		pnlC.add(priceLbl);
		
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Car Repair Shop Test");
		
		add(pnlN,"North");
		add(pnlC);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CarRepairShopTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==engineOil){
			if(engineOil.isSelected()){
				price = price+45000;
			}else{
				price = price-45000;
			}
		}else if(e.getSource()==transmission){
			if(transmission.isSelected()){
				price = price+80000;
			}else{
				price = price-80000;
			}
		}else if(e.getSource()==airconFilter){
			if(airconFilter.isSelected()){
				price = price+30000;
			}else{
				price = price-30000;
			}
		}else if(e.getSource()==tire){
			if(tire.isSelected()){
				price = price+100000;
			}else{
				price = price-100000;
			}
		}
		priceLbl.setText("현재까지의 가격은 "+price+"원입니다.");
	}

}
