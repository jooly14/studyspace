import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class JCafePayment extends JDialog implements ActionListener{
	JButton btnCard1,btnCard2,btnCash1,btnCash2,btnPayment,btnGoBack;
	JTextField tfInstallment,tfCardNumber;
	JButton btnReceipts,btnProofOfExpenditure,btnNull;
	JPanel pnlCash,pnlCard;
	boolean Receipts;
	void init(){
		pnlCard=new JPanel(null);
		pnlCash=new JPanel(null);
		tfInstallment=new JTextField(3);
		tfCardNumber=new JTextField(10);
		btnCard1=new JButton("ī��");
		btnCash1=new JButton("����");
		btnCard2=new JButton("ī��");
		btnCash2=new JButton("����");
		btnReceipts=new JButton("����");
		btnProofOfExpenditure=new JButton("�����");
		
		btnPayment=new JButton("����");
		btnGoBack=new JButton("����ȭ��");
	}
	public JCafePayment(JCafeMain jc) {
		super(jc,true);
		init();
		setSize(300,330);
		
		btnCard1.addActionListener(this);
		btnCash1.addActionListener(this);
		btnCard2.addActionListener(this);
		btnCash2.addActionListener(this);
		
		JPanel pnlSouth=new JPanel();
		
		tfInstallment.setText("1");
		btnProofOfExpenditure.addActionListener(this);
		btnReceipts.addActionListener(this);
		btnPayment.addActionListener(this);
		btnGoBack.addActionListener(this);
		
		btnCash1.setBounds(30,50,100,50);
		btnCard1.setBounds(170,50,100,50);
		btnReceipts.setBounds(30,130,100,50);
		btnProofOfExpenditure.setBounds(170,130,100,50);
		//���ݰ��� ȭ�� ��ǥ
		pnlCash.add(btnCash1);
		pnlCash.add(btnCard1);
		pnlCash.add(btnReceipts);
		pnlCash.add(btnProofOfExpenditure);
		//���ݰ��� ȭ�� �߰�
		JLabel lblInstallment=new JLabel("����"); 
		JLabel lblCardNumber=new JLabel("ī���ȣ");
		
		btnCash2.setBounds(30,50,100,50);
		btnCard2.setBounds(170,50,100,50);
		tfInstallment.setBounds(10, 120, 20, 30);
		tfCardNumber.setBounds(10, 200, 250, 30);
		lblInstallment.setBounds(40,120,60,30);
		lblCardNumber.setBounds(10,170,60,30);
		//ī����� ȭ�� ��ǥ
		pnlCard.add(lblCardNumber);
		pnlCard.add(lblInstallment);
		pnlCard.add(btnCash2);
		pnlCard.add(btnCard2);
		pnlCard.add(tfInstallment);
		pnlCard.add(tfCardNumber);
		//ī����� ȭ�� �߰�
		pnlSouth.add(btnPayment);
		pnlSouth.add(btnGoBack);
		btnCard1.setBackground(Color.white);
		btnCash1.setBackground(Color.white);
		btnProofOfExpenditure.setBackground(Color.WHITE);
		btnReceipts.setBackground(Color.WHITE);
		
		this.add(pnlCash);
		this.add(pnlSouth,"South");
		
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	void clickCash(){
		btnCard1.setBackground(Color.white);
		btnCard2.setBackground(Color.white);
		btnCash1.setBackground(Color.pink);
		btnCash2.setBackground(Color.pink);
		this.remove(pnlCard);
		this.add(pnlCash);
		repaint();
		revalidate();
	}
	void clickCard(){
		btnCard1.setBackground(Color.pink);
		btnCard2.setBackground(Color.pink);
		btnCash1.setBackground(Color.white);
		btnCash2.setBackground(Color.white);
		this.remove(pnlCash);
		this.add(pnlCard);
		repaint();
		revalidate();
	}
	void clickReceipts(){
		Receipts=true;
		btnProofOfExpenditure.setBackground(Color.WHITE);
		btnReceipts.setBackground(Color.pink);
		repaint();
		revalidate();
	}
	void clickProofOfExpenditure(){
		Receipts=false;
		btnReceipts.setBackground(Color.WHITE);
		btnProofOfExpenditure.setBackground(Color.pink);
		repaint();
		revalidate();
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCash1||e.getSource()==btnCash2)
			clickCash();
		if(e.getSource()==btnCard1||e.getSource()==btnCard2)
			clickCard();
		if(e.getSource()==btnPayment)
			this.setVisible(false);
		if(e.getSource()==btnGoBack)
			this.setVisible(false);
		if(e.getSource()==btnProofOfExpenditure)
			clickProofOfExpenditure();
		if(e.getSource()==btnReceipts)
			clickReceipts();
	}
}