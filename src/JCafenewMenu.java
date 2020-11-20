import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.table.*;

public class JCafenewMenu extends JDialog implements ActionListener{
	JTable table;
	JTextField tname,tpay,tcont;//���޴�,�ݾ�,���� �޴� text
	int cnt;//���� int�� ��ȯ
	String contents[][]={};
	int idx,plusidx=0,minusidx=0;
	JButton newMenu,delMenu;//�޴��߰�,���� ��ư
	DefaultTableModel model;
	/////
	String content; //�޴� �߰��� ��� input()�޼ҵ�

	BufferedReader br=null;//set
	FileReader fr=null;
	PrintWriter pw=null;//save
	FileWriter fw = null;
	String fstr="files/coffee.txt";
	
	int row;//���콺�� Ŭ���� ��ġ
	
	JComboBox comboMenu;
	
	JCafenewMenu(JCafeManagerMenu c, JCafeNewMenuPnl np){
		super(c);
		
		this.setSize(500,550);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel title=new JLabel("�޴�����");
		JPanel titlep=new JPanel();
		
		String str[]={"coffee","latte","tea"};
		comboMenu=new JComboBox(str);
		comboMenu.addActionListener(this);
		titlep.add(title,"Center");
		titlep.add(comboMenu);
		
	
		JPanel panel=new JPanel();
		JPanel panel2=new JPanel();
		
		//�޴����� ���̺� ����
		String[] header={"�޴�","����","����"};
		model=new DefaultTableModel(contents,header);
		table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		panel.add(sp);
		
		//�޴� �ݾ� �Է�, �߰� ���� �ϴ� �κ�
		JLabel name=new JLabel("�޴�:");
		tname=new JTextField(5);
		JLabel pay=new JLabel("�ݾ�:");
		tpay=new JTextField(5);
		JLabel cont=new JLabel("����");
		tcont=new JTextField(5);
		newMenu=new JButton("�޴��߰�");
		delMenu=new JButton("�޴�����");
		
		newMenu.addActionListener(this);
		delMenu.addActionListener(this);

		sp.getViewport().setBackground(Color.WHITE);//table ���� ���� 
		panel2.add(name);
		panel2.add(tname);
		panel2.add(pay);
		panel2.add(tpay);
		panel2.add(cont);
		panel2.add(tcont);
		panel2.add(newMenu);
		panel2.add(delMenu);
		
		
		titlep.setBackground(Color.PINK);
		panel.setBackground(Color.pink);
		panel2.setBackground(Color.WHITE);
		this.add(panel);
		this.add(titlep,"North");
		this.add(panel2,"South");
		fileOpen();  //â ������ �ڵ����� ���� �ҷ�����
		this.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {//��ư Ŭ����
		String combo=comboMenu.getSelectedItem().toString();
		if(e.getSource()==newMenu){  //���޴� �߰�
			input();
			tname.setText("");
			tpay.setText("");
			tcont.setText("");
			plusidx++;
		
		}
		else if(e.getSource()==delMenu){  //Ŭ���� �� �����
			row = table.getSelectedRow();
			System.out.println(row);
			model.removeRow(row);
			minusidx++;
		}
		fileSave();
		if(combo=="coffee"){
			fileClose();
			fstr="files/coffee.txt";
			fileOpen();
		}	
		else if(combo=="latte"){
			fileClose();
			fstr="files/latte.txt";
			fileOpen();
		}
		else if(combo=="tea"){
			fileClose();
			fstr="files/tea.txt";
			fileOpen();
		}
		repaint();
		revalidate();
	}
	
	void fileOpen(){   //table�� ���� �ҷ���
		
		try {
			
			fr=new FileReader(fstr);//���ϰ�� ����
			br=new BufferedReader(fr);//�о�� ���� buffer�� ��� ���۴� ����
			
			String l=null;
			while((l=br.readLine())!=null){//���ۿ����� ���پ� �о���� ���� ���ö�����
				String data[]=l.split("/");
				model.addRow(data);
				idx++;
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


	void fileSave(){//������ ���ŵɶ� ���� ��������
		
		
		try{
			fw = new FileWriter(fstr);//������ġ  true �Ƚ��༭ �ʱ�ȭ�ϰ� ���� ����
			pw = new PrintWriter(fw);
			
			
			String dataA="";
			for(int i=0;i<table.getRowCount();i++){	
				dataA=table.getValueAt(i, 0)+"/"+table.getValueAt(i, 1)+"/"+table.getValueAt(i, 2);//���ο� ���Ͽ� ����
				pw.println(dataA);
				
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
	void input(){ //�޴��߰�
		content=tname.getText()+"/"+tpay.getText()+"/"+tcont.getText();
		String data[]=content.split("/");
		model.addRow(data);
	}
	void fileClose(){//comboBox���� Ŀ��,��,Ƽ ���ý� �տ� ���� ���ﶧ ���
		
		for(int i=0;i<idx+plusidx-minusidx;idx--)
		{
			model.removeRow(idx-1+plusidx-minusidx);
			}
		
	}
}

