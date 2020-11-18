import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.JSpinner.DateEditor;
import javax.swing.table.*;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
class toDaysale{//���� �Ǹ�ǥ�� ���Ϸ� �������
	PrintWriter pw=null;
	FileWriter fw=null;
	Date toDay;
	
	toDaysale(){
		toDay=new Date();
		fileSave();
	}
	void fileSave(){//�Ǹ� ������ ���ŵɶ� ���� ��������
		try {
			fw=new FileWriter("files/"+toDay,true);//����� ���¿��� �߰��� ����
			pw=new PrintWriter(fw);
			String dataA="";
			//dataA=toDayTable.getValueAt(i,0)+"/"+toDayTable.getValueAt(i,1)+"/"+toDayTable.getValueAt(i, 2);
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
	DefaultTableModel model;
	BufferedReader br=null;
	FileReader fr=null;
	PrintWriter pw=null;
	FileWriter fw=null;
	int idx,minusidx;//���������� ����
	UtilDateModel dmodel;
	String day1,day2;
	int row;//���콺 Ŭ����ġ
	
	JCafeCloseSale(){
		this.setSize(500,550);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel title=new JLabel("���� �Ǹŷ�");
		JPanel titlep=new JPanel();
		titlep.add(title,"Center");
		
		//��¥ ���� ���� ���� �ٿ�޾ƾ���
		dmodel=new UtilDateModel();
		JDatePanelImpl datePanel=new JDatePanelImpl(dmodel);
		JDatePickerImpl datePicker=new JDatePickerImpl(datePanel);
		titlep.add(datePicker);
		day1=dmodel.getYear()+"."+(dmodel.getMonth()+1)+"."+dmodel.getDay();
		//System.out.println(day1); �׽�Ʈ����
		datePicker.addActionListener(this);
		
		
		//���� �Ǹŷ��̵� ���̺�
		JPanel panel=new JPanel();
		String[] header={"�ð�","ǰ��","�ݾ�"};
		model=new DefaultTableModel(contents,header);
		closeTable=new JTable(model);
		JScrollPane closeSp=new JScrollPane(closeTable);
		panel.add(closeSp);
		closeSp.getViewport().setBackground(Color.WHITE);//table ���� ���� 
		
		cancel=new JButton("�Ǹ����");
		cancel.addActionListener(this);
		JPanel panel2=new JPanel();
		panel2.add(cancel);
		
		titlep.setBackground(Color.PINK);
		panel.setBackground(Color.pink);
		panel2.setBackground(Color.pink);
		
		fileOpen();
		this.add(titlep,"North");
		this.add(panel,"Center");
		this.add(panel2,"South");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==cancel){          //Ŭ���� �� ����
			row=closeTable.getSelectedRow();
			model.removeRow(row);
			minusidx++;//
		}
		else {
			day1=dmodel.getYear()+"."+(dmodel.getMonth()+1)+"."+dmodel.getDay();
			//System.out.println(day1); �׽�Ʈ�ڵ�
			fileOpen();
		}
			
		fileSave();
		
	}
	
	void fileOpen(){//�� ��¥�� ���� ����
		fileClose();//���� ������ �ݾƾ� ���� ������ ������
		try {
			fr=new FileReader("files/"+day1);//�����̸��� �޾ƿ� ��¥�� ����
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
	}
	void fileSave(){//�Ǹ� ������ ���ŵɶ� ���� ��������
		
		try {
			fw=new FileWriter("files/"+day1);
			pw=new PrintWriter(fw);
			
			String dataA="";
			for(int i=0;i<closeTable.getRowCount();i++){
				dataA=closeTable.getValueAt(i,0)+"/"+closeTable.getValueAt(i,1)+"/"+closeTable.getValueAt(i, 2);
				pw.println(dataA);
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
	void fileClose(){//���� ���� ���� ����ϵ��� ������
		for(int i=0;i<idx-minusidx;idx--){
			model.removeRow(idx-1-minusidx);
		}
	}
}

