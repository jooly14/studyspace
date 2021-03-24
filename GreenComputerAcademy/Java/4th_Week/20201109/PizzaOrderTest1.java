import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PizzaOrderTest1 extends JFrame implements ActionListener{
	
	JButton btnOk;
	JButton btnCancel;
	JTextField price;
	JRadioButton btnCombo;
	JRadioButton btnPotato;
	JRadioButton btnBulgogi;
	JRadioButton btnPimento;// 피망
	JRadioButton btnCheese;
	JRadioButton btnPepperoni;
	JRadioButton btnBacon;
	JRadioButton btnSmall;
	JRadioButton btnMedium;
	JRadioButton btnLarge;
	
	ButtonGroup gType;
	ButtonGroup gTopping;
	ButtonGroup gSize;
	
	int temp1;
	int temp2;
	int temp3;
	
	JPanel pnlSouth;
	
	public PizzaOrderTest1(){
		setTitle("피자 주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,250);
		JPanel pnlWelcome = new JPanel();
		JLabel lblWelcome = new JLabel("자바 피자에 오신 것을 환영합니다.");
		pnlWelcome.add(lblWelcome);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(0,3));
		JPanel pnlType = new JPanel();
		pnlType.setBorder(BorderFactory.createTitledBorder("종류"));
		JPanel pnlTopping = new JPanel();
		pnlTopping.setBorder(BorderFactory.createTitledBorder("추가 토핑"));
		JPanel pnlSize = new JPanel();
		pnlSize.setBorder(BorderFactory.createTitledBorder("크기"));
		
		btnCombo = new JRadioButton("콤보");
		btnPotato = new JRadioButton("포테이토");
		btnBulgogi = new JRadioButton("불고기");
		gType = new ButtonGroup();
		gType.add(btnCombo);
		gType.add(btnPotato);
		gType.add(btnBulgogi);
		btnPimento = new JRadioButton("피망");
		btnCheese = new JRadioButton("치즈");
		btnPepperoni = new JRadioButton("페페로니");
		btnBacon = new JRadioButton("베이컨");
		gTopping = new ButtonGroup();
		gTopping.add(btnPimento);
		gTopping.add(btnCheese);
		gTopping.add(btnPepperoni);
		gTopping.add(btnBacon);
		btnSmall = new JRadioButton("Small");
		btnMedium = new JRadioButton("Medium");
		btnLarge = new JRadioButton("Large");
		gSize = new ButtonGroup();
		gSize.add(btnSmall);
		gSize.add(btnMedium);
		gSize.add(btnLarge);
		
		
		
		pnlType.add(btnCombo);
		pnlType.add(btnPotato);
		pnlType.add(btnBulgogi);
		
		pnlTopping.add(btnPimento);
		pnlTopping.add(btnCheese);
		pnlTopping.add(btnPepperoni);
		pnlTopping.add(btnBacon);
		
		pnlSize.add(btnSmall);
		pnlSize.add(btnMedium);
		pnlSize.add(btnLarge);
		
		pnlCenter.add(pnlType);
		pnlCenter.add(pnlTopping);
		pnlCenter.add(pnlSize);
		
		pnlSouth = new JPanel();
		btnOk = new JButton("주문");
		btnCancel = new JButton("취소");
		price = new JTextField(10);
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		pnlSouth.add(btnOk);
		pnlSouth.add(btnCancel);
		
		
		add(pnlWelcome,"North");
		add(pnlSouth,"South");
		add(pnlCenter);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PizzaOrderTest1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOk){
			if(btnCombo.isSelected()){
				temp1 = 100;
			}else if(btnPotato.isSelected()){
				temp1 = 200;
			}else if(btnBulgogi.isSelected()){
				temp1 = 300;
			}
			if(btnPimento.isSelected()){
				temp2 = 100;
			}else if(btnCheese.isSelected()){
				temp2 = 200;
			}else if(btnPepperoni.isSelected()){
				temp2 = 300;
			}else if(btnBacon.isSelected()){
				temp2 = 400;
			}
			if(btnSmall.isSelected()){
				temp3 = 10000;
			}else if(btnMedium.isSelected()){
				temp3 = 15000;
			}else if(btnLarge.isSelected()){
				temp3 = 20000;
			}	
			price.setText(temp1+temp2+temp3+"");
			pnlSouth.add(price);
		}else{
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			pnlSouth.remove(price);
		}
		
		repaint();
		revalidate();
	}

}
