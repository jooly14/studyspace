import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class JCafeTotalPay extends JDialog implements ActionListener {
	//마감을 누르면 당일판매 합계금액이 이클래스 totalSave()메소드에서 파일로 저장된다
	//그 파일을 열어서 달 단위로 확인 할 수 있다.
	//달이 지나면 자동으로 다음달 파일을 만들어주고 comboBox목록에도 그 달이 생긴다.
	BufferedReader br=null;
	FileReader fr=null;
	PrintWriter pw=null;
	FileWriter fw=null;
	
	JCafeCloseSale c;
	JTable totalTable;
	DefaultTableModel model;
	String contents[][]={};
	JButton cancel;
	int idx,plust;//삭제된줄의 개수
	JPanel titlep;
	JComboBox tcombo;
	String combo="2020년9월/2020년10월/",t="";//combo초기 자료는 자동 저장이 안되므로 넣어준다.
	int cnt=0,cnt2=2;
	JLabel l1;
	
	JCafeTotalPay(DeadLineRegistration deadLineRegistration){
		super(deadLineRegistration,true);
		c=new JCafeCloseSale();
		c.dispose();
		
		this.setSize(500,550);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		titlep=new JPanel();
		l1=new JLabel("일단위판매현황");
		
		//한달 판매수익을 담을 테이블을 구성해준다.
		JPanel panel=new JPanel();
		String[] header={"날짜","수익"};
		model=new DefaultTableModel(contents,header);
		totalTable=new JTable(model);
		JScrollPane totalSp=new JScrollPane(totalTable);
		panel.add(totalSp);
		totalSp.getViewport().setBackground(Color.WHITE);//table 배경색 설정 
		
		totalTable.getColumn("날짜").setPreferredWidth(60); //table 가로 길이 각각 조정
		totalTable.getColumn("수익").setPreferredWidth(200);
		
		//창을 나갈 버튼을 설정해준다.
		cancel=new JButton("돌아가기");
		cancel.addActionListener(this);
		JPanel panel2=new JPanel();
		panel2.add(cancel);
		
		titlep.setBackground(Color.PINK);
		panel.setBackground(Color.pink);
		panel2.setBackground(Color.pink);
		
		fileOpen();//그 날의 달 파일을 자동으로 열어준다.,comboBox에 들어갈 배열도 여기서 호출
	
		tcombo.setSelectedIndex(cnt2);//콤보박스 초기에 셋팅되는 값을 해당하는 달로 정해준다. 다음달 파일이 하나 늘어날 수록 1씩 늘게 설정해둠
		tcombo.addActionListener(this);
		titlep.add(tcombo);
		
		this.add(titlep,"North");
		this.add(panel,"Center");
		this.add(panel2,"South");
		this.setLocationRelativeTo(null);//다이얼로그가 중간에 띄워지도록
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tcombo){
			fileOpen2();//콤보박스를 누르면 그 달의 해당파일이 열린다.
		}
		if(e.getSource()==cancel){
			dispose();//돌아가기를 누르면 창을 꺼준다.
		}
		
	}
	void setTCombo(){
		String str=c.day3;
		if(cnt==0){//첫달 파일이 없을시 combo목록에 추가해준다.
			t=str;
			combo+=t+"/";
			cnt++;
			cnt2++;
		}
		if(t!=str){//달이 달라지면 combo목록에 새로생긴 달을 더해준다.
			t=str;
			combo+=t+"/";
			cnt2++;//콤보박스 초기에 셋팅되는 값을 해당하는 달로 바꿔주기 위해 +1 해줌
		}
		String data[]=combo.split("/");// /로 끊어서 넣어둔 정보들을 잘라 comboBox목록으로 넣어준다.
		tcombo=new JComboBox(data);
		//tcombo.addActionListener(this);	
	}
	void fileOpen(){//당일의 해당하는 월 파일 열기
		fileClose();
		idx=0;
		try {
			fr=new FileReader("JCafeDaySaleData/"+c.day3+".txt");//파일이름을 당일 월로 지정
			br=new BufferedReader(fr);
			String l=null;
			while((l=br.readLine())!=null){//파일을 읽어서 한줄씩 테이블에 넣어줌
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
		setTCombo();
	}
	void fileOpen2(){//콤보박스 선택한 월의 파일 열기
		fileClose();//이미 테이블에 올라와있던 정보들 지우기
		idx=0;
		String getCombo=tcombo.getSelectedItem().toString();
		try {
			fr=new FileReader("JCafeDaySaleData/"+getCombo+".txt");//파일이름을 받아온 월로 지정
			br=new BufferedReader(fr);
			String l=null;
			while((l=br.readLine())!=null){//한줄씩 테이블에 넣어주기
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
	void fileClose(){//새로 파일 열때 깔끔하도록 지워줌
		for(int i=0;i<idx;idx--){
			model.removeRow(idx-1);
		}
	}

	void totalSave(){//(JCafeManagerMenu에 마감완료를 누르면 실행됨)판매 정보가 갱신될때 마다 누적 저장(월이 다르면 다른 파일에 저장)
		try {
			fw=new FileWriter("JCafeDaySaleData/"+c.day3+".txt");
			pw=new PrintWriter(fw,true);
			String dataA=c.totalReturn();
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
