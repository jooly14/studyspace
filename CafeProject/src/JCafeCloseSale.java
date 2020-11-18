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
class toDaysale{//당일 판매표를 파일로 만들어줌
	PrintWriter pw=null;
	FileWriter fw=null;
	Date toDay;
	
	toDaysale(){
		toDay=new Date();
		fileSave();
	}
	void fileSave(){//판매 정보가 갱신될때 마다 새로저장
		try {
			fw=new FileWriter("files/"+toDay,true);//저장된 상태에서 추가로 저장
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
public class JCafeCloseSale extends JDialog implements ActionListener{  //금일 판매량, 금액이 저장될 공간
	JTable closeTable;
	String contents[][]={};
	JButton close,cancel;
	DefaultTableModel model;
	BufferedReader br=null;
	FileReader fr=null;
	PrintWriter pw=null;
	FileWriter fw=null;
	int idx,minusidx;//삭제된줄의 개수
	UtilDateModel dmodel;
	String day1,day2;
	int row;//마우스 클릭위치
	
	JCafeCloseSale(){
		this.setSize(500,550);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel title=new JLabel("금일 판매량");
		JPanel titlep=new JPanel();
		titlep.add(title,"Center");
		
		//날짜 선택 별도 파일 다운받아야함
		dmodel=new UtilDateModel();
		JDatePanelImpl datePanel=new JDatePanelImpl(dmodel);
		JDatePickerImpl datePicker=new JDatePickerImpl(datePanel);
		titlep.add(datePicker);
		day1=dmodel.getYear()+"."+(dmodel.getMonth()+1)+"."+dmodel.getDay();
		//System.out.println(day1); 테스트파일
		datePicker.addActionListener(this);
		
		
		//금일 판매량이들어갈 테이블
		JPanel panel=new JPanel();
		String[] header={"시간","품목","금액"};
		model=new DefaultTableModel(contents,header);
		closeTable=new JTable(model);
		JScrollPane closeSp=new JScrollPane(closeTable);
		panel.add(closeSp);
		closeSp.getViewport().setBackground(Color.WHITE);//table 배경색 설정 
		
		cancel=new JButton("판매취소");
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
		
		
		if(e.getSource()==cancel){          //클릭한 줄 삭제
			row=closeTable.getSelectedRow();
			model.removeRow(row);
			minusidx++;//
		}
		else {
			day1=dmodel.getYear()+"."+(dmodel.getMonth()+1)+"."+dmodel.getDay();
			//System.out.println(day1); 테스트코드
			fileOpen();
		}
			
		fileSave();
		
	}
	
	void fileOpen(){//그 날짜의 파일 열기
		fileClose();//이전 파일을 닫아야 다음 파일이 열리게
		try {
			fr=new FileReader("files/"+day1);//파일이름을 받아온 날짜로 지정
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
	void fileSave(){//판매 정보가 갱신될때 마다 새로저장
		
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
	void fileClose(){//새로 파일 열때 깔끔하도록 지워줌
		for(int i=0;i<idx-minusidx;idx--){
			model.removeRow(idx-1-minusidx);
		}
	}
}

