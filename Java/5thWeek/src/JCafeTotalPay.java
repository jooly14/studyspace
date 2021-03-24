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
	//������ ������ �����Ǹ� �հ�ݾ��� ��Ŭ���� totalSave()�޼ҵ忡�� ���Ϸ� ����ȴ�
	//�� ������ ��� �� ������ Ȯ�� �� �� �ִ�.
	//���� ������ �ڵ����� ������ ������ ������ְ� comboBox��Ͽ��� �� ���� �����.
	BufferedReader br=null;
	FileReader fr=null;
	PrintWriter pw=null;
	FileWriter fw=null;
	
	JCafeCloseSale c;
	JTable totalTable;
	DefaultTableModel model;
	String contents[][]={};
	JButton cancel;
	int idx,plust;//���������� ����
	JPanel titlep;
	JComboBox tcombo;
	String combo="2020��9��/2020��10��/",t="";//combo�ʱ� �ڷ�� �ڵ� ������ �ȵǹǷ� �־��ش�.
	int cnt=0,cnt2=2;
	JLabel l1;
	
	JCafeTotalPay(DeadLineRegistration deadLineRegistration){
		super(deadLineRegistration,true);
		c=new JCafeCloseSale();
		c.dispose();
		
		this.setSize(500,550);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		titlep=new JPanel();
		l1=new JLabel("�ϴ����Ǹ���Ȳ");
		
		//�Ѵ� �Ǹż����� ���� ���̺��� �������ش�.
		JPanel panel=new JPanel();
		String[] header={"��¥","����"};
		model=new DefaultTableModel(contents,header);
		totalTable=new JTable(model);
		JScrollPane totalSp=new JScrollPane(totalTable);
		panel.add(totalSp);
		totalSp.getViewport().setBackground(Color.WHITE);//table ���� ���� 
		
		totalTable.getColumn("��¥").setPreferredWidth(60); //table ���� ���� ���� ����
		totalTable.getColumn("����").setPreferredWidth(200);
		
		//â�� ���� ��ư�� �������ش�.
		cancel=new JButton("���ư���");
		cancel.addActionListener(this);
		JPanel panel2=new JPanel();
		panel2.add(cancel);
		
		titlep.setBackground(Color.PINK);
		panel.setBackground(Color.pink);
		panel2.setBackground(Color.pink);
		
		fileOpen();//�� ���� �� ������ �ڵ����� �����ش�.,comboBox�� �� �迭�� ���⼭ ȣ��
	
		tcombo.setSelectedIndex(cnt2);//�޺��ڽ� �ʱ⿡ ���õǴ� ���� �ش��ϴ� �޷� �����ش�. ������ ������ �ϳ� �þ ���� 1�� �ð� �����ص�
		tcombo.addActionListener(this);
		titlep.add(tcombo);
		
		this.add(titlep,"North");
		this.add(panel,"Center");
		this.add(panel2,"South");
		this.setLocationRelativeTo(null);//���̾�αװ� �߰��� ���������
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tcombo){
			fileOpen2();//�޺��ڽ��� ������ �� ���� �ش������� ������.
		}
		if(e.getSource()==cancel){
			dispose();//���ư��⸦ ������ â�� ���ش�.
		}
		
	}
	void setTCombo(){
		String str=c.day3;
		if(cnt==0){//ù�� ������ ������ combo��Ͽ� �߰����ش�.
			t=str;
			combo+=t+"/";
			cnt++;
			cnt2++;
		}
		if(t!=str){//���� �޶����� combo��Ͽ� ���λ��� ���� �����ش�.
			t=str;
			combo+=t+"/";
			cnt2++;//�޺��ڽ� �ʱ⿡ ���õǴ� ���� �ش��ϴ� �޷� �ٲ��ֱ� ���� +1 ����
		}
		String data[]=combo.split("/");// /�� ��� �־�� �������� �߶� comboBox������� �־��ش�.
		tcombo=new JComboBox(data);
		//tcombo.addActionListener(this);	
	}
	void fileOpen(){//������ �ش��ϴ� �� ���� ����
		fileClose();
		idx=0;
		try {
			fr=new FileReader("JCafeDaySaleData/"+c.day3+".txt");//�����̸��� ���� ���� ����
			br=new BufferedReader(fr);
			String l=null;
			while((l=br.readLine())!=null){//������ �о ���پ� ���̺� �־���
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
	void fileOpen2(){//�޺��ڽ� ������ ���� ���� ����
		fileClose();//�̹� ���̺� �ö���ִ� ������ �����
		idx=0;
		String getCombo=tcombo.getSelectedItem().toString();
		try {
			fr=new FileReader("JCafeDaySaleData/"+getCombo+".txt");//�����̸��� �޾ƿ� ���� ����
			br=new BufferedReader(fr);
			String l=null;
			while((l=br.readLine())!=null){//���پ� ���̺� �־��ֱ�
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
	void fileClose(){//���� ���� ���� ����ϵ��� ������
		for(int i=0;i<idx;idx--){
			model.removeRow(idx-1);
		}
	}

	void totalSave(){//(JCafeManagerMenu�� �����ϷḦ ������ �����)�Ǹ� ������ ���ŵɶ� ���� ���� ����(���� �ٸ��� �ٸ� ���Ͽ� ����)
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
