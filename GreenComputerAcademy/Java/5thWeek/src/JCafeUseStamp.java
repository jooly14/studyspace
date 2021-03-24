import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JCafeUseStamp extends JDialog implements ActionListener{
	boolean save;
	JPanel pnl;
	JTable table;
	int changeLine;
	
	int useStemp; // ������ � ����ߴ��� ����
	JLabel lblStemp; // ������ � ���Ҵ��� ǥ��
	String[][]strPrice; //�޴� ���̺��� �ϳ��� ������ ����
	String[][]strTable;		//�޴� ���̺��� String�迭�� ������ > ������ ��� ���� ���̺��� ���� ��
	String[] tableHeader={"�̸�","����","�ݾ�"};	//���
	DefaultTableModel model;
	String userNumber=null;		//�մ� ��ȣ 
	String userStempCnt=null;	
	int stempNum,coffeeCnt;				//�մ� ����������, �� Ŀ�Ǽ���
	JButton btnEnter,btnGoBack;
	JButton btnUse,btnComplete,btnCancel;
	JTextField tfPhoneNum;
	
	String changeStemp;
	public JCafeUseStamp(JCafePayment jcp) {// ó�� UI, ��������ó��
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
		this.setLocale(null);
		this.pack();
		setVisible(true);
	}
	void init(){// ������Ʈ �߰�& �̺�Ʈ �߰� ��� �ڷ� �ʱ�ȭ
		table=new JTable(model);
		for(int i=0;i<table.getRowCount();i++)
			coffeeCnt+=Integer.parseInt((String) table.getValueAt(i, 1));
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
		
		strPrice=new String[table.getRowCount()][3];
		strTable=new String[table.getRowCount()][3];
		
		for(int i=0;i<table.getRowCount();i++){
			int n=Integer.parseInt((String) table.getValueAt(i,1));//n�� Ŀ�� ����
			for(int j=0;j<3;j++){
				strTable[i][j]=(String)table.getValueAt(i,j);
				if(j==2){//strPrice[RowCnt][2]�� ��� �Ѱ���/���� �ؼ� �ϳ��� ������ strPrice [RowCnt][2]�� ���δ��
					int a=Integer.parseInt(strTable[i][j])/Integer.parseInt(strTable[i][1]);
					strPrice[i][j]=""+a;
				}
			}
		}
		
		tfPhoneNum=new JTextField(10);
	}
	void stempEnter(){ // �ʱ�ȭ�鿡�� ��ȣ �Է� �� Ȯ�� ������ ��Ÿ���� ȭ��
		this.remove(pnl);
		setSize(500,550);
		JScrollPane sp=new JScrollPane(table);
		pnl=new JPanel(null);
		lblStemp=new JLabel(tfPhoneNum.getText()+"�� ������ ������ : " + stempNum +" ��");
		
		sp.setBounds(10, 10, 460, 450);
		btnUse.setBounds(100,465,80,30);
		btnComplete.setBounds(190,465,80,30);
		btnCancel.setBounds(280,465,80,30);
		
		pnl.add(sp);
		pnl.add(btnUse);
		pnl.add(btnComplete);
		pnl.add(btnCancel);
		
		this.add(pnl);
		this.add(lblStemp,"South");
	}
	void clickBtnUse(){ // ����ư ������ �̺�Ʈ
			if(stempNum>=5){
				if((Integer.parseInt( strTable[table.getSelectedRow()][2] )>0)){
					useStemp++; //����� ������ �����ֱ�
					stempNum-=5;//���� ������ ���
					lblStemp.setText(tfPhoneNum.getText()+"�� ������ ������ : " + stempNum +" ��"+
									  "               ��� �� ������ : "+(useStemp*5)+" ��");
					//� ���Ұ� � ����ϴ��� �ؽ�Ʈ�� ������ label
					
					int a=Integer.parseInt(strTable[table.getSelectedRow()][2]);//���̺��� �ݾ�
					int b=Integer.parseInt(strPrice[table.getSelectedRow()][2]);//���õȰ� �Ѱ� �ݾ�
					a=a-b; //���̺�ݾ׿��� �Ѱ��ݾ� ����
					
					strTable[table.getSelectedRow()][2]=a+""; // �迭���� �ݾ� ���ɷ� ����
					table.setValueAt(a, table.getSelectedRow(), 2);// ���̺� ���̴°� �ٲ��ֱ�
					repaint();
					revalidate();
				} else JOptionPane.showMessageDialog(this, "����� �� �ִ� ��ǰ�� �ƴմϴ�.");
			}else JOptionPane.showMessageDialog(this, "�������� �����մϴ�.");
	}
	boolean phoneNumCheck(){// �Է��� ��ȣ�� ������ �����Ϳ� ������ userNumber, userStempCnt ���� �� true��ȯ, ������ false ��ȯ
		FileReader fr = null;
		BufferedReader br=null;
		try {
			fr=new FileReader(new File("JCafeStempData\\JCafeStempData.txt"));
			br=new BufferedReader(fr);
			
			String l=null;
			while((l=br.readLine())!=null){
				String[]str=l.split("/");//str[0]�� ��ȭ��ȣ ��´�.
				if(str[0].equals(tfPhoneNum.getText())){//��ȭ��ȣ�� tfPhoneNum�� �ԷµȰŶ� ������
					userNumber=str[0];					//userNumber�� ��ȭ��ȣ ����
					userStempCnt=str[1];				//userStempCnt�� ���������� ����(string)
					stempNum=Integer.parseInt(str[1]);	//stempNum�� ���������� ����(int)
					return true;						//�Է��ѹ�ȣ�� �����Ϳ� ������ true ��ȯ����
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}try{
			if(fr!=null) fr.close();
			if(br!=null) br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return false; //�Է��� ��ȣ�� �����Ϳ� ������ false ��ȯ����
	}
	void clickBtnComplete(){// �Ϸ��ư ������ model,save ���������� �������� �� ȭ�鲨��
		model=new DefaultTableModel(strTable,tableHeader);
		save=true;

		dispose();
	}
	void clickBtnCancel(){// ��ҹ�ư ������ save=false �ϰ� ȭ�鲨��
		save=false;
		dispose();
	}

	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEnter){// Ȯ�� ��ư
			if(phoneNumCheck()){
				stempEnter();
			}else
				JOptionPane.showMessageDialog(this, "�Է��� ��ȣ�� ������ �����ϴ�.");
		}else if(e.getSource()==btnGoBack){// ��� ��ư
			dispose();
		}
		//������� JCafePayment���� ���������� ���� ȭ��, �����δ� Ȯ�� �� ȭ��
		else if(e.getSource()==btnUse){// ��� ��ư
			clickBtnUse();
		}else if(e.getSource()==btnComplete){//�Ϸ� ��ư
			clickBtnComplete();//save=true, �𵨳Ѱ��ֱ�
		}else if(e.getSource()==btnCancel){// ��� ��ư
			clickBtnCancel(); // save=false, �� �ȳѰ���
		}
	}
}