import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JCafeUseStamp extends JDialog implements ActionListener{
	JCafeMain jc;
	JCafePayment jp;
	boolean save;
	JPanel pnl;
	JTable table;
	int changeLine;
	int stampNum=33;
	int useStamp; // ������ � ����ߴ��� ����
	JLabel lblStamp; // ������ � ���Ҵ��� ǥ��
	String[][]strPrice; //�޴� ���̺��� �ϳ��� ������ ����
	String[][]strTable;		//�޴� ���̺��� String�迭�� ������ > ������ ��� ���� ���̺��� ���� ��
	String[] tableHeader={"�޴�","����","����"};	//���
	DefaultTableModel model;
	String userNumber=null;
	String userStampCnt=null;
	
	JButton btnEnter,btnGoBack;
	JButton btnUse,btnComplete,btnCancel;
	JTextField tfPhoneNum;
	
	void init(){
		table=new JTable(model);
		btnCancel=new JButton("���");
		btnEnter=new JButton("Ȯ��");
		btnUse=new JButton("���");
		btnComplete=new JButton("�Ϸ�");
		btnGoBack=new JButton("���");
		
		btnCancel.addActionListener(this);
		btnEnter.addActionListener(this);
		btnUse.addActionListener(this);
		btnComplete.addActionListener(this);
		btnGoBack.addActionListener(this);
		
		strPrice=new String[3][table.getRowCount()];
		strTable=new String[3][table.getRowCount()];
		
		for(int i=0;i<table.getRowCount();i++){
			int n=Integer.parseInt((String) table.getValueAt(i,1));//n�� Ŀ�� ����
			for(int j=0;j<3;j++){
				strTable[j][i]=(String)table.getValueAt(i,j);
				if(j==2){
					int a=Integer.parseInt(strTable[j][i])/Integer.parseInt(strTable[1][i]);
					strPrice[j][i]=""+a;
				}
			}
		}
		tfPhoneNum=new JTextField(10);
	}
	public JCafeUseStamp(JCafePayment jcp) {
		super(jcp,true);
		model=jcp.jc.model;
		init();
		
		pnl=new JPanel();
		JLabel lbl=new JLabel("��ȭ��ȣ");
		pnl.add(lbl);
		pnl.add(tfPhoneNum);
		pnl.add(btnEnter);
		pnl.add(btnCancel);
		
		this.add(pnl);
		this.pack();
		this.setLocale(null);
		setVisible(true);
	}
	void stempEnter(){
		this.remove(pnl);
		setSize(500,550);
		JScrollPane sp=new JScrollPane(table);
		pnl=new JPanel(null);
		lblStamp=new JLabel(tfPhoneNum.getText()+"�� ������ ������ : " + stampNum +" ��");
		
		sp.setBounds(10, 10, 460, 450);
		btnUse.setBounds(100,465,80,30);
		btnComplete.setBounds(190,465,80,30);
		btnCancel.setBounds(280,465,80,30);
		
		pnl.add(sp);
		pnl.add(btnUse);
		pnl.add(btnComplete);
		pnl.add(btnCancel);
		
		this.add(pnl);
		this.add(lblStamp,"South");
	}
	// ��ȣ�Է��� Ȯ�δ����� ������ ȭ��
	void stempFindUserNumber(){
		String[]stempCnt=null;
		String[]phoneNum=null;
		String strStemp="";
		String strNum="";
		try {
			FileReader fr = new FileReader(new File("JCafeStempData\\JCafeStempData.txt"));
			BufferedReader br=new BufferedReader(fr);
			
			String l=null;
			while((l=br.readLine())!=null){
				String[] read=l.split("/"); //  br������ ���پ� /�� ��� read�迭�� ��´�.
				strStemp=strStemp+read[1]+"/"; // read[1]�� ������ ������ �����̹Ƿ� (����������/)�� ���ڿ��� �߰�
				strNum=strNum+read[0]+"/"; // read[0]�� ������ ��ȣ�̹Ƿ� (��ȣ/)�� ���ڿ��� �߰�
			}
			phoneNum=strNum.split("/");//phoneNum�迭�� ��ȣ���� �ϳ��� �����Ѵ�.
			stempCnt=strStemp.split("/");//stempCnt�迭�� ������������ �ϳ��� �����Ѵ�.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0;i<phoneNum.length;i++){
			if(phoneNum[i].equals(tfPhoneNum.getText())){
				userNumber=phoneNum[i]; // userNumber�� ����� ��ȣ�� ��´�.
				userStampCnt=stempCnt[i];//userStempCnt�� ������ ������ ��´�.
			}
		}
	}
	// userNumber   ����	��ȭ��ȣ
	// stempNum 	����	����������
	void clickBtnUse(){
			if(stampNum>=5){
				if((Integer.parseInt(strTable[2][table.getSelectedRow()])>0)){
					useStamp++;
					stampNum-=5;//������ ���
					lblStamp.setText(tfPhoneNum.getText()+"�� ������ ������ : " + stampNum +" ��"+"               ��� �� ������ : "+(useStamp*5)+" ��");
					
					int a=Integer.parseInt(strTable[2][table.getSelectedRow()]);//���̺��� �ݾ�
					int b=Integer.parseInt(strPrice[2][table.getSelectedRow()]);//���õȰ� �Ѱ� �ݾ�
					a=a-b; //���̺�ݾ׿��� �Ѱ��ݾ� ����
					
					strTable[2][table.getSelectedRow()]=a+""; // �迭���� �ݾ� ���ɷ� ����
					table.setValueAt(a, table.getSelectedRow(), 2);// ���̺� ���̴°� �ٲ��ֱ�
					repaint();
					revalidate();
				} else JOptionPane.showMessageDialog(this, "����� �� �ִ� ��ǰ�� �ƴմϴ�.");
			}else JOptionPane.showMessageDialog(this, "�������� �����մϴ�.");
//		else JOptionPane.showMessageDialog(this, "��밡���� ��ǰ�� �ƴմϴ�.");
	}
	// ���̺� ������ ����ư ������ ����� �̺�Ʈ
	void clickBtnComplete(){
		model=new DefaultTableModel(strTable,tableHeader);
		save=true;
		dispose();
	}
	void clickBtnCancel(){
		save=false;
		dispose();
	}
	// �Ϸ� ������ ����� �̺�Ʈ
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEnter){// ��ȣ�Է��ϰ� Ȯ�δ�����
			//ȸ������ Ȯ���ϴ� �޼ҵ�
			stempEnter();
		}else if(e.getSource()==btnGoBack){
			dispose();
		}else if(e.getSource()==btnUse){
			clickBtnUse();
		}else if(e.getSource()==btnComplete){
			clickBtnComplete();
			//
		}else if(e.getSource()==btnCancel){
			clickBtnCancel();
		}
	}
}