import java.awt.GridLayout;
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

//class JCafeStempTable extends JDialog implements ActionListener{
class JCafeStempTable extends JDialog implements ActionListener{
	JButton btnChangeNumber,btnRefresh;
	String[]strHeader={"��ȭ��ȣ","������ ����"};
	String[][]strTable;
	BufferedReader br;
	FileReader fr;
	DefaultTableModel model;
	JTable table;
	void init(Boolean b){ //�� �ʱ�ȭ(Boolean���� ������ ���̺� true or false �ϴ� ���)
		setSize(400,500);
		
		model=new DefaultTableModel(strTable,strHeader);
		table=new JTable(model);
		JScrollPane spTable=new JScrollPane(table);
		showData();
		
		btnRefresh=new JButton("���ΰ�ħ");
		btnChangeNumber=new JButton("��ȣ����");
		table.setEnabled(b);
		btnRefresh.addActionListener(this);
		
		JPanel pnl=new JPanel(new GridLayout(1,2));
		pnl.add(btnChangeNumber);
		pnl.add(btnRefresh);
		this.add(pnl,"South");
		this.add(spTable);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	JCafeStempTable(JCafeMain jcm) {//���ο��� ũ�����ӽ� ��ȣ���� �׼Ǹ����� x
		super(jcm,true);
		init(false);
		btnChangeNumber.addActionListener(this);
	}
	JCafeStempTable(JCafeManagerMenu jcmm){// ���⸸ ��ȣ���� �׼Ǹ����� �߰�
		super(jcmm,true);
		init(true);
		btnChangeNumber.addActionListener(this);
	}
	void showData(){// ������������ �о�ͼ� ȭ�鿡 �ѷ��ִ� ����
		for(int i=0;i<model.getRowCount();)
			model.removeRow(i);
		try {
			fr = new FileReader(new File("JCafeStempData\\JCafeStempData.txt"));//������������ ��������
			br = new BufferedReader(fr);//
			
			String l=null;
			while((l=br.readLine())!=null){
				String[] str=l.split("/");
				model.addRow(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr !=null) fr.close();
				if(br != null) br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	void numDataChange(){// ��ȣ���� Ŭ���� ������ �����ϴ� â ����, Ȯ�� ������ ��ȣ �����ϰ� ������ ������� ���ִ� ����
			PrintWriter pw=null;
			FileWriter fw = null;
			
			try {
				fw = new FileWriter(new File("JCafeStempData\\JCafeStempData.txt"));// (true�����Ƿ� �ʱ�ȭ ��) JCafeStempData�� ���ڴ�. 
				pw = new PrintWriter(fw);
				
				JCafePhoneNum jcn=new JCafePhoneNum(this);	// PhoneNum ȭ�� ����
				String getNumber=jcn.getPhoneNum();		// getNumber�� �޴�����ȣ
				table.setValueAt(getNumber, table.getSelectedRow(), 0);//���̺� ���õ� ���� 0��° ���� getNumber�� �ִ´�.
				String data=null;
				for(int i=0;i<table.getRowCount();i++){
					data=table.getValueAt(i, 0)+"/"+table.getValueAt(i, 1);
					pw.println(data);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(fw!=null) fw.close();
					if(pw!=null) pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRefresh)
			showData();
		if(e.getSource()==btnChangeNumber)
			numDataChange();
	}
}