import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.*;

public class JCafeTable extends JFrame implements ActionListener{
	JTable table;
	JTextField tname,tpay;//새메뉴,금액 받는 text
	String contents[][]={};
	int idx;
	JButton newMenu,delMenu;//메뉴추가,삭제 버튼
	DefaultTableModel model;
	/////
	String content;
	JFileChooser chooser;

	BufferedReader br=null;
	FileReader fr=null;
	
	int row;//마우스로 클릭한 위치
	
	JCafeTable(){
		this.setSize(500,550);
		this.setDefaultCloseOperation(3);
		JLabel title=new JLabel("메뉴관리");
		JPanel titlep=new JPanel();
		titlep.add(title,"Center");
	
		JPanel panel=new JPanel();
		JPanel panel2=new JPanel();
		
		//메뉴관리 테이블 구성
		String[] header={"메뉴","가격"};
		model=new DefaultTableModel(contents,header);
		table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		panel.add(sp);
		
		//메뉴 금액 입력, 추가 삭제 하는 부분
		JLabel name=new JLabel("메뉴:");
		tname=new JTextField(8);
		JLabel pay=new JLabel("금액:");
		tpay=new JTextField(8);
		newMenu=new JButton("메뉴추가");
		delMenu=new JButton("메뉴삭제");
		
		newMenu.addActionListener(this);
		delMenu.addActionListener(this);
		
		panel2.add(name);
		panel2.add(tname);
		panel2.add(pay);
		panel2.add(tpay);
		panel2.add(newMenu);
		panel2.add(delMenu);
		
		this.add(panel);
		this.add(titlep,"North");
		this.add(panel2,"South");
		fileOpen();  //창 열릴때 자동으로 파일 불러오게
		this.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {//버튼 클릭시
		if(e.getSource()==newMenu){  //새메뉴 추가
			input();
		
		}
		if(e.getSource()==delMenu){  //클릭한 행 지우기
			row = table.getSelectedRow();                 
			model.removeRow(row);
		}
		fileSave();
		repaint();
		revalidate();
	}
	
	void fileOpen(){   //table에 파일 불러옴
		
		try {
			
			fr=new FileReader("files/list");//파일경로 지정
			br=new BufferedReader(fr);//읽어온 파일 buffer에 담기 버퍼는 한줄
			
			String l=null;
			while((l=br.readLine())!=null){//버퍼에담긴거 한줄씩 읽어오기 빈줄 나올때까지
				String data[]=l.split("/");
				model.addRow(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
				try {
					if(fr!=null)fr.close();
					if(br!=null)br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	void input(){ //메뉴추가
		content=tname.getText()+"/"+tpay.getText()+"/"+0;
		String data[]=content.split("/");
		model.addRow(data);
		idx++;
	}

	void fileSave(){//정보가 갱신될때 마다 새로저장
		
		PrintWriter pw=null;
		FileWriter fw = null;
		try{
			fw = new FileWriter("files/list");//저장위치  true 안써줘서 초기화하고 새로 저장
			pw = new PrintWriter(fw);
			
			String boData[] = new String[idx];
			//String dataA="";
			for(int i=0;i<idx;i++){	
				System.out.println(idx);
				boData[i]=table.getValueAt(i, 0)+"/"+table.getValueAt(i, 1);
				System.out.println(boData[i]);
				pw.println(boData[i]);//초기화는 처음생성될때만 해줘서 착착 쌓인다.
				
			}
			
		}catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(fw !=null) fw.close();
				if(pw != null) pw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	void fileDelete(){
		
	}

	public static void main(String[] args) {
		new JCafeTable();
	}
}
