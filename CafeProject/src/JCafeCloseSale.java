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

class GetTimesale extends JDialog implements ActionListener{  //당일 판매표를 파일로 만들어줌
	BufferedReader br=null;
	FileReader fr=null;
	PrintWriter pw=null;
	FileWriter fw=null;
	JTable dleTable;
	String contents[][]={};
	DefaultTableModel model;
	JButton delete,no;
	int x;
	
	GetTimesale(JCafeCloseSale s){  //당일 판매표를 파일로 만들어줌
		super(s,true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel panel=new JPanel();                
		JPanel panel2=new JPanel();
		String[] header={"시간","품목","수량","금액"};                      //table 만들기
		model=new DefaultTableModel(contents,header);
		dleTable=new JTable(model);
		JScrollPane dleSp=new JScrollPane(dleTable);
		panel.add(dleSp);
		dleSp.getViewport().setBackground(Color.WHITE);//table 배경색 설정 
		
		dleTable.getColumn("시간").setPreferredWidth(60);
		dleTable.getColumn("품목").setPreferredWidth(200);
		dleTable.getColumn("수량").setPreferredWidth(20);
		dleTable.getColumn("금액").setPreferredWidth(50);
		
		delete=new JButton("판매취소");
		no=new JButton("돌아가기");
		panel2.add(delete);
		panel2.add(no);
		delete.addActionListener(this);
		no.addActionListener(this);
		
		
		fileOpen();
		this.add(panel);
		this.add(panel2,"South");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==delete){
			int result=JOptionPane.showConfirmDialog(this, "판매취소하시겠습니까?");
			//System.out.println("ok");테스트코드
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
	void fileOpen(){//그 날짜의 파일 열기
		try {
			fr=new FileReader("files/Delete");//파일이름을 받아온 날짜로 지정
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
	
	void fileSave(){//판매 정보가 갱신될때 마다 새로저장
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
	JComboBox tm2;
	String combo[];
	int cnt=0;//콤보박스 시간 카운트
	
	PrintWriter pw2=null;//선택한 시간에 팔린것 파일로 따로 저장
	FileWriter fw2=null;
	
	JCafeCloseSale(){
		this.setSize(500,550);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.setDefaultCloseOperation(3);
		JPanel titlep=new JPanel();
		JLabel tm1=new JLabel("시간");
		
		
		JLabel title=new JLabel("날짜");
	
		titlep.add(title);
		
		//날짜 선택 별도 파일 다운받아야함
		dmodel=new UtilDateModel();
		JDatePanelImpl datePanel=new JDatePanelImpl(dmodel);
		JDatePickerImpl datePicker=new JDatePickerImpl(datePanel);
		titlep.add(datePicker);
		day1=(dmodel.getYear()+""+(dmodel.getMonth()+1)+""+dmodel.getDay());
		//System.out.println(day1); //테스트파일
		datePicker.addActionListener(this);
		
		
		//금일 판매량이들어갈 테이블
		JPanel panel=new JPanel();
		String[] header={"시간","품목","수량","금액"};
		model=new DefaultTableModel(contents,header);
		closeTable=new JTable(model);
		JScrollPane closeSp=new JScrollPane(closeTable);
		panel.add(closeSp);
		closeSp.getViewport().setBackground(Color.WHITE);//table 배경색 설정 
		
		closeTable.getColumn("시간").setPreferredWidth(60);
		closeTable.getColumn("품목").setPreferredWidth(200);
		closeTable.getColumn("수량").setPreferredWidth(20);
		closeTable.getColumn("금액").setPreferredWidth(50);
		
		cancel=new JButton("판매취소");
		cancel.addActionListener(this);
		JPanel panel2=new JPanel();
		panel2.add(cancel);
		
		titlep.setBackground(Color.PINK);
		panel.setBackground(Color.pink);
		panel2.setBackground(Color.pink);
		
		fileOpen();//파일을 테이블에 열어야 시간정보를 받아와 콤보박스에 넣을 수 있다./////////////////////////////////
		//콤보박스에 시간 넣어주기
		combo=new String[closeTable.getRowCount()];
		
		if(closeTable.getRowCount()==1){
			combo[cnt++]=closeTable.getValueAt(0,0).toString();
		}
		for(int i=1;i<closeTable.getRowCount();i++){
			String s1=closeTable.getValueAt(i-1,0).toString();
			String s2=closeTable.getValueAt(i,0).toString();
			if(i<closeTable.getRowCount()-1){
				if(s1.equals(s2)!=true){
					combo[cnt++]=s1;
					}
			}
			else if(i==closeTable.getRowCount()-1){
				//System.out.println(s1+" "+s2);테스트코드
				//System.out.println(s1.equals(s2));
				if(s1.equals(s2)!=true){
					combo[cnt++]=s1;
					combo[cnt++]=s2;
				}
				else{
					combo[cnt++]=s2;
				}
			}	
		}
		
		tm2=new JComboBox(combo);
		tm2.addActionListener(this);
		titlep.add(tm1);
		titlep.add(tm2);
		
		this.add(titlep,"North");
		this.add(panel,"Center");
		this.add(panel2,"South");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {                              //ActionListener
		if(e.getSource()==tm2){
			String getCombo=tm2.getSelectedItem().toString();
					try {
						fw2=new FileWriter("files/Delete");       //원하는 시간대의 주문만 따로 파일에 넣어서 테이블에 보여줄 예정
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
					}	                                              //여기까지
			GetTimesale g=new GetTimesale(this);                    //원하는 시간대의 주문만 보여주는 다이얼로그
			//System.out.println(g.reTurn());                        
			
			if(g.reTurn()==5){ //g.reTurn() 판매 취소를 누르면 5를 반환해줌
				fileSave2();//선택된 시간대 정보만 빼고 원래 day파일에 저장해줌 (선택된 시간의 주문 삭제)
				fileOpen();// 삭제한뒤 파일을 새로 열어주야함
			}
		}
		else {
			//day1=(dmodel.getYear()+(dmodel.getMonth()+1)+dmodel.getDay()+"");
			System.out.println(day1); //테스트코드
			fileOpen();
			fileSave();
			
		}	
	}
	
	void fileOpen(){//그 날짜의 파일 열기
		fileClose();//이전 파일을 닫아야 다음 파일이 열리게
		try {
			fr=new FileReader("JCafeDaySaleData/"+day1+".txt");//파일이름을 받아온 날짜로 지정
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
			fw=new FileWriter("JCafeDaySaleData//"+day1+".txt");
			pw=new PrintWriter(fw);
			
			String dataA="";
			for(int i=0;i<closeTable.getRowCount();i++){
				dataA=closeTable.getValueAt(i,0)+"/"+closeTable.getValueAt(i,1)+"/"+closeTable.getValueAt(i, 2)+"/"+closeTable.getValueAt(i, 3);
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
	void fileSave2(){
		try {
			fw=new FileWriter("JCafeDaySaleData//"+day1+".txt");
			pw=new PrintWriter(fw);
			String getCombo=tm2.getSelectedItem().toString();
			String dataA="";
			for(int i=0;i<closeTable.getRowCount();i++){
				String getRow=closeTable.getValueAt(i,0).toString();
				if(getRow.equals(getCombo)!=true){
					dataA=closeTable.getValueAt(i,0).toString()+"/"+closeTable.getValueAt(i,1).toString()+"/"+closeTable.getValueAt(i,2).toString()+"/"+closeTable.getValueAt(i, 3);
					//System.out.println(dataA);  테스트코드
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

