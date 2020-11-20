import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

class JCafePayment extends JDialog implements ActionListener{
	JButton btnCard1,btnCard2,btnCash1,btnCash2,btnPayment,btnGoBack,btnStemp1,btnStemp2;
	JTextField tfInstallment,tfCardNumber;
	JButton btnReceipts,btnProofOfExpenditure,btnNull;
	JPanel pnlCash,pnlCard;
	DefaultTableModel model;
	int useStempCnt,userStemp,coffeeCnt;
	String userPhoneNum;
	boolean payment;
	JCafeMain jc;
	
	void init(){// ������Ʈ �߰�& �̺�Ʈ �߰�
		pnlCard=new JPanel(null);
		pnlCash=new JPanel(null);
		tfInstallment=new JTextField(3);
		tfCardNumber=new JTextField(10);
		btnCard1=new JButton("ī��");
		btnCash1=new JButton("����");
		btnCard2=new JButton("ī��");
		btnCash2=new JButton("����");
		btnStemp1=new JButton("������");
		btnStemp2=new JButton("������");
		
		btnReceipts=new JButton("����");
		btnProofOfExpenditure=new JButton("�����");
		btnPayment=new JButton("����");
		btnGoBack=new JButton("����ȭ��");
		
		btnCard1.addActionListener(this);
		btnCash1.addActionListener(this);
		btnStemp1.addActionListener(this);
		btnCard2.addActionListener(this);
		btnCash2.addActionListener(this);
		btnStemp2.addActionListener(this);

		btnProofOfExpenditure.addActionListener(this);
		btnReceipts.addActionListener(this);
		btnPayment.addActionListener(this);
		btnGoBack.addActionListener(this);
	}
	public JCafePayment(JCafeMain jc) {//�� �Ѱܹް� UI ����, ��������ó��
		super(jc,true);
		this.jc = jc;
		model=jc.model;
		for(int i=0;i<jc.tableOrderList.getRowCount();i++)// �ֹ��Ǵ� ���� ���� ����
			coffeeCnt+=Integer.parseInt((String) jc.tableOrderList.getValueAt(i,1));
		init();
		setSize(300,330);
		
		JPanel pnlSouth=new JPanel();
		
		tfInstallment.setText("1");//ó�� ī����� �Һ� 1����
		btnPayment.setEnabled(true);
		btnCash1.setBounds(15,25,80,50);
		btnCard1.setBounds(105,25,80,50);
		btnStemp1.setBounds(195,25,80,50);
		btnReceipts.setBounds(30,105,100,50);
		btnProofOfExpenditure.setBounds(170,105,100,50);
		//���ݰ��� ȭ�� ��ǥ
		pnlCash.add(btnCash1);
		pnlCash.add(btnCard1);
		pnlCash.add(btnStemp1);
		pnlCash.add(btnReceipts);
		pnlCash.add(btnProofOfExpenditure);
		//���ݰ��� ȭ�� �߰�
		JLabel lblInstallment=new JLabel("����"); 
		JLabel lblCardNumber=new JLabel("ī���ȣ");

		JTextField tf=new JTextField(10);
		JLabel lbl=new JLabel("��");
		btnCash2.setBounds(15,25,80,50);
		btnCard2.setBounds(105,25,80,50);
		btnStemp2.setBounds(195,25,80,50);
		tfInstallment.setBounds(10, 105, 20, 30);
		tfCardNumber.setBounds(10, 185, 250, 30);
		lblInstallment.setBounds(40,105,60,30);
		lblCardNumber.setBounds(10,155,60,30);
		//ī����� ȭ�� ��ǥ
		pnlCard.add(lblCardNumber);
		pnlCard.add(lblInstallment);
		pnlCard.add(btnCash2);
		pnlCard.add(btnCard2);
		pnlCard.add(btnStemp2);
		pnlCard.add(tfInstallment);
		pnlCard.add(tfCardNumber);
		//ī����� ȭ�� �߰�
		pnlSouth.add(btnPayment);
		pnlSouth.add(btnGoBack);
		btnCard1.setBackground(Color.white);
		btnCash1.setBackground(Color.white);
		btnStemp1.setBackground(Color.white);
		btnStemp2.setBackground(Color.WHITE);
		btnProofOfExpenditure.setBackground(Color.WHITE);
		btnReceipts.setBackground(Color.WHITE);
		
		this.add(pnlCash);
		this.add(pnlSouth,"South");
		
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	void clickCash(){// ���ݹ�ư Ŭ�� �̺�Ʈ
		btnCard1.setBackground(Color.white);
		btnCash1.setBackground(Color.pink);
		this.remove(pnlCard);
		this.add(pnlCash);
		repaint();
		revalidate();
	}
	void clickCard(){// ī���ư Ŭ�� �̺�Ʈ
		btnCard2.setBackground(Color.pink);
		btnCash2.setBackground(Color.white);
		this.remove(pnlCash);
		this.add(pnlCard);
		repaint();
		revalidate();
	}
	void clickReceipts(){// ���ݿ����� ���ι�ư Ŭ�� �̺�Ʈ
		btnProofOfExpenditure.setBackground(Color.WHITE);
		btnReceipts.setBackground(Color.pink);
		repaint();
		revalidate();
	}
	void clickProofOfExpenditure(){// ���ݿ����� ����ڹ�ư Ŭ�� �̺�Ʈ
		btnProofOfExpenditure.setBackground(Color.pink);
		btnReceipts.setBackground(Color.WHITE);
		repaint();
		revalidate();
	}
	void clickStemp(){//��������ư Ŭ�� �̺�Ʈ
		JCafeUseStamp jus=new JCafeUseStamp(this);
		if(jus.save){//��������� �Ϸ�Ǹ� ����� ���ǹ�
			model=jus.model;
			useStempCnt=jus.useStemp*5;	//����� ������ ����
			userStemp=jus.stempNum;		//���� ������ ����
			userPhoneNum=jus.userNumber;//����� ��ȭ��ȣ
			coffeeCnt=jus.coffeeCnt;	//Ŀ�� ��
		}
	}
	void clickPayment(){// ������ư Ŭ�� �̺�Ʈ
		JCafeSaveSalesData.saveSalesData(model);
		new JCafeDaySaleData(jc, this, model);// JCafeDaySaleData������ ���ϸ�(���ϳ�¥)�� ������ �����ϴ� Ŭ����
		payment=true; // ���� �ߴ��� ���ߴ��� ����
		if(userPhoneNum==null){ //��ȣ�Է� �� ���������� ���ִ� ���ǹ�
			JCafePhoneNum jcpn=new JCafePhoneNum(this);
			userPhoneNum=jcpn.getPhoneNum();
		}
		new JCafeUseStempToSave(userPhoneNum,userStemp);//������ ���� ������ȭ(���Ͽ� ����)
		new JCafeStempAdd(userPhoneNum, (coffeeCnt - (useStempCnt/5) ) ); // ������ �߰� (�������� ������ Ŀ�� �� ��ŭ ������ ����������)
	}
	void clickGoBack(){// ����ȭ���ư Ŭ�� �̺�Ʈ
		dispose();
		payment=false;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnStemp1||e.getSource()==btnStemp2) clickStemp();	//������ ��ư
		if(e.getSource()==btnCash1||e.getSource()==btnCash2) clickCash();	// ���ݹ�ư
		if(e.getSource()==btnCard1||e.getSource()==btnCard2) clickCard();	// ī���ư
		if(e.getSource()==btnPayment)clickPayment();// ������ư
		if(e.getSource()==btnGoBack) clickGoBack(); // ����ȭ�� ��ư
		if(e.getSource()==btnProofOfExpenditure) clickProofOfExpenditure(); // ����� �������� ��ư
		if(e.getSource()==btnReceipts) clickReceipts(); // ���� ���ݿ����� ��ư
	}
}