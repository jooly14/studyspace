import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.JSpinner.DateEditor;
import javax.swing.table.*;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

class GetTimesale extends JDialog implements ActionListener{  //���� �Ǹ�ǥ�� ���Ϸ� �������
	BufferedReader br=null;
	FileReader fr=null;
	PrintWriter pw=null;
	FileWriter fw=null;
	JTable dleTable;
	String contents[][]={};
	DefaultTableModel model;
	JButton delete,no;
	int x;
	
	GetTimesale(JCafeCloseSale s){  //���� �Ǹ�ǥ�� ���Ϸ� �������
		super(s,true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel panel=new JPanel();
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		
		String[] header={"�ð�","ǰ��","����","�ݾ�"};                      //table �����
		model=new DefaultTableModel(contents,header);
		dleTable=new JTable(model);
		JScrollPane dleSp=new JScrollPane(dleTable);

		panel.add(dleSp);
		dleSp.getViewport().setBackground(Color.WHITE);//table ���� ���� 
		
		dleTable.getColumn("�ð�").setPreferredWidth(60);
		dleTable.getColumn("ǰ��").setPreferredWidth(200);
		dleTable.getColumn("����").setPreferredWidth(20);
		dleTable.getColumn("�ݾ�").setPreferredWidth(50);
		
		delete=new JButton("�Ǹ����");
		no=new JButton("���ư���");
		panel2.add(delete);
		panel2.add(no);
		delete.addActionListener(this);
		no.addActionListener(this);
		
		
		fileOpen();
		
		JLabel label=new JLabel(dleTable.getValueAt(0, 0)+" �Ǹų���");
		panel1.add(label);
		
		panel1.setBackground(Color.pink);
		panel.setBackground(Color.pink);
		panel2.setBackground(Color.pink);
		this.setBackground(Color.pink);
		
		this.add(panel1,"North");
		this.add(panel);
		this.add(panel2,"South");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==delete){
			int result=JOptionPane.showConfirmDialog(this, "�Ǹ�����Ͻðڽ��ϱ�?");
			//System.out.println("ok");�׽�Ʈ�ڵ�
			if(result==JOptionPane.YES_NO_OPTION){
				x=5;
				dispose();
			}
			else
				x=0;
		}
		else if(e.getSource()==no){
			x=0;
			dispose();
		}
		
	}
	int reTurn(){
		return x;
	}
	void fileOpen(){//�� ��¥�� ���� ����
		try {
			fr=new FileReader("files/Delete");//�����̸��� �޾ƿ� ��¥�� ����
			br=new BufferedReader(fr);
			String l=null;
			
			while((l=br.readLine())!=null){
				String data[]=l.split("/");					
				model.addRow(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(fr!=null)fr.close();
				if(br!=null)br.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}	
	}
	
	void fileSave(){//�Ǹ� ������ ���ŵɶ� ���� ��������
		try {
			fw=new FileWriter("files/Delete");
			pw=new PrintWriter(fw);
			String dataA="";
			pw.println(dataA);
	
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw!=null)
				try {
					fw.close();
					if(pw!=null)pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
////////////////////////////////////////////////////////////////////////////
public class JCafeCloseSale extends JDialog implements ActionListener{  //���� �Ǹŷ�, �ݾ��� ����� ����
	JTable closeTable;
	String contents[][]={};
	JButton close,cancel;
	JLabel totalLabel,tm1,title;//�� �Ǹűݾ��� �� ���̺�,�ð�,��¥
	String totalc;
	DefaultTableModel model;
	BufferedReader br=null;
	FileReader fr=null;
	PrintWriter pw=null;
	FileWriter fw=null;
	int idx;//���������� ����
	UtilDateModel dmodel;
	String day1,day2,day3;
	int row;//���콺 Ŭ����ġ
	JComboBox tm2;
	String combo[],fcombo[];
	int cnt=0;//�޺��ڽ� �ð� ī��Ʈ
	int total;
	JPanel titlep;
	JDatePickerImpl datePicker;
	
	PrintWriter pw2=null;//������ �ð��� �ȸ��� ���Ϸ� ���� ����
	FileWriter fw2=null;
	
	JCafeCloseSale(){
		this.setSize(500,550);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.setDefaultCloseOperation(3);
		titlep=new JPanel();
		tm1=new JLabel("�ð�");
		
		
		title=new JLabel("��¥");
	
		//titlep.add(title);
		
		//��¥ ���� ���� ���� �ٿ�޾ƾ���
		dmodel=new UtilDateModel();
		JDatePanelImpl datePanel=new JDatePanelImpl(dmodel);
		datePicker=new JDatePickerImpl(datePanel);
		//titlep.add(datePicker);
		day1=(dmodel.getYear()+""+(dmodel.getMonth()+1)+""+dmodel.getDay());
		day2=(dmodel.getYear()+"�� "+(dmodel.getMonth()+1)+"�� "+dmodel.getDay()+"�� ");
		//System.out.println(day1); //�׽�Ʈ����
		datePicker.addActionListener(this);
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy��MM��");
		Date day=new Date();
		day3=format.format(day);
		
		
		//���� �Ǹŷ��̵� ���̺�
		JPanel panel=new JPanel();
		String[] header={"�ð�","ǰ��","����","�ݾ�"};
		model=new DefaultTableModel(contents,header);
		closeTable=new JTable(model);
		JScrollPane closeSp=new JScrollPane(closeTable);
		panel.add(closeSp);
		closeSp.getViewport().setBackground(Color.WHITE);//table ���� ���� 
		
		closeTable.getColumn("�ð�").setPreferredWidth(60); //table ���� ���� ���� ����
		closeTable.getColumn("ǰ��").setPreferredWidth(200);
		closeTable.getColumn("����").setPreferredWidth(20);
		closeTable.getColumn("�ݾ�").setPreferredWidth(50);
		
		totalLabel=new JLabel();
		cancel=new JButton("���ư���");
		cancel.addActionListener(this);
		JPanel panel2=new JPanel();
		panel2.add(totalLabel);
		panel2.add(cancel);
		
		titlep.setBackground(Color.PINK);
		panel.setBackground(Color.pink);
		panel2.setBackground(Color.pink);
		
		fileOpen();//������ ���̺� ����� �ð������� �޾ƿ� �޺��ڽ��� ���� �� �ִ�./////////////////////////////////
		//�޺��ڽ��� �ð� �־��ֱ�
		
		//tm2=new JComboBox(fcombo);
		//tm2.addActionListener(this);
		titlep.add(tm1);
		titlep.add(tm2);
		
		this.add(titlep,"North");
		this.add(panel,"Center");
		this.add(panel2,"South");
		this.setLocationRelativeTo(null);//���̾��� �߰��� ���������
		this.setVisible(true);
		
	}
	void setcomboBox(){//�ð�����â�� ���� �ð����� �޺��ڽ��� �־��ش�.
		combo=new String[closeTable.getRowCount()];//���̺��� Row��ŭ �޺� ũ�⸦ Ű���ش�
		if(closeTable.getRowCount()==1){//ù�ֹ��� 1�ܸ� �������� 
			combo[cnt++]=closeTable.getValueAt(0,0).toString();
		}
		for(int i=1;i<closeTable.getRowCount();i++){
			String s1=closeTable.getValueAt(i-1,0).toString();
			String s2=closeTable.getValueAt(i,0).toString();
			if(i<closeTable.getRowCount()-1){
				if(s1.equals(s2)!=true){//�սð��� �޽ð��� �� �ٸ��� �սð��� �־��ش�
					combo[cnt++]=s1;
					}
			}
			else if(i==closeTable.getRowCount()-1){//������ �ֹ��� ���
				//System.out.println(s1+" "+s2);�׽�Ʈ�ڵ�
				//System.out.println(s1.equals(s2));
				if(s1.equals(s2)!=true){//�սð��� �ֹ��ð��� ���� ������ �հ� �� �ֹ� ����� �ð��� ����
					combo[cnt++]=s1;
					combo[cnt++]=s2;
				}
				else{//�սð��� �ֹ��ð��� ������ �޽ð� ����
					combo[cnt++]=s2;
				}
			}	
		}
		fcombo=new String[cnt];
		for(int i=0;i<cnt;i++){
			fcombo[i]=combo[i];
		}/*
		int x=fcombo.length;    //�׽�Ʈ�ڵ� �޺��ڽ��� �� ���� �ִ���
		System.out.println("-------------------------");
		for(int j=0;j<x;j++){
			System.out.println(fcombo[j]);
		}*/
		cnt=0;
		tm2=new JComboBox(fcombo);
		tm2.addActionListener(this);
		titlep.removeAll();
		
		titlep.add(title);
		titlep.add(datePicker);
		titlep.add(tm1);
		titlep.add(tm2);
		
		this.repaint();
		this.revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {                              //ActionListener
		if(e.getSource()==tm2){
			String getCombo=tm2.getSelectedItem().toString();//�޺��ڽ����� ������ �ð�
					try {
						fw2=new FileWriter("files/Delete");       //���ϴ� �ð����� �ֹ��� ���� Delete���Ͽ� �־��ش�.
						pw2=new PrintWriter(fw2);
						for(int i=0;i<closeTable.getRowCount();i++){
							String getRow=closeTable.getValueAt(i,0).toString();
							if(getRow.equals(getCombo)==true){
								String dataB="";
								dataB=closeTable.getValueAt(i,0).toString()+"/"+closeTable.getValueAt(i,1).toString()+"/"+closeTable.getValueAt(i,2).toString()+"/"+closeTable.getValueAt(i, 3);
								//System.out.println(dataB);
								pw2.println(dataB);
							}
						}
				
					} catch (IOException e1) {
						e1.printStackTrace();
					}finally{
						if(fw2!=null)
							try {
								fw2.close();
								if(pw2!=null)pw2.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
					}	                                              //�������
			GetTimesale g=new GetTimesale(this);                    //���ϴ� �ð����� �ֹ��� �����ִ� ���̾�α�
			//System.out.println(g.reTurn());                        
			
			if(g.reTurn()==5){ //g.reTurn() �Ǹ� ��Ҹ� ������ 5�� ��ȯ����
				fileSave2();//���õ� �ð��� ������ ���� ���� day���Ͽ� �������� (���õ� �ð��� �ֹ� ����)
				fileOpen();// �����ѵ� ������ ���� �����־���
			}
		}
		else if(e.getSource()==cancel){
			dispose();
		}
		else {
			day1=(dmodel.getYear()+""+(dmodel.getMonth()+1)+""+dmodel.getDay()+"");
			day2=(dmodel.getYear()+"�� "+(dmodel.getMonth()+1)+"�� "+dmodel.getDay()+"�� ");
			//System.out.println(day1); //�׽�Ʈ�ڵ�
			fileOpen();
			//fileSave();
		}
	}
	
	void fileOpen(){//�� ��¥�� ���� ����
		fileClose();//���� ������ �ݾƾ� ���� ������ ������
		total=0;//������ ��¥ �Ǹ� �ѱݾ� �ʱ�ȭ
		try {
			fr=new FileReader("JCafeDaySaleData/"+day1+".txt");//�����̸��� �޾ƿ� ��¥�� ����
			br=new BufferedReader(fr);
			String l=null;
			
			while((l=br.readLine())!=null){
				String data[]=l.split("/");					
				model.addRow(data);
				idx++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(fr!=null)fr.close();
				if(br!=null)br.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		
		setcomboBox(); 
		
		//////////�׳� ����
		for(int i=0;i<closeTable.getRowCount();i++){
			String str=(String) closeTable.getValueAt(i, 3);
			total+=Integer.parseInt(str);
		}			
		//System.out.println(total); �׽�Ʈ�ڵ�
		DecimalFormat dc=new DecimalFormat("#,###");
		totalc=String.format("%,d", total);     //3�ڸ����� , �����
		totalLabel.setText(day2+"�� ���� : "+totalc+"��");		
	}
	
	String totalReturn(){//////////////////////�Ϸ� �Ǹż��� ��ȯ���ִ� �޼ҵ�
		return day2+"/"+totalc+"�� /";
		
	}
	void fileClose(){//���� ���� ���� ����ϵ��� ������
		for(int i=0;i<idx;idx--){
			model.removeRow(idx-1);
		}
	}
	void fileSave2(){
		try {
			fw=new FileWriter("JCafeDaySaleData/"+day1+".txt");
			pw=new PrintWriter(fw);
			String getCombo=tm2.getSelectedItem().toString();
			String dataA="";
			for(int i=0;i<closeTable.getRowCount();i++){
				String getRow=closeTable.getValueAt(i,0).toString();
				if(getRow.equals(getCombo)!=true){
					dataA=closeTable.getValueAt(i,0).toString()+"/"+closeTable.getValueAt(i,1).toString()+"/"+closeTable.getValueAt(i,2).toString()+"/"+closeTable.getValueAt(i, 3);
					//System.out.println(dataA);  �׽�Ʈ�ڵ�
					pw.println(dataA);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw!=null)
				try {
					fw.close();
					if(pw!=null)pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}

