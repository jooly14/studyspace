import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.table.DefaultTableModel;

public class JCafeSaveSalesData {
	static void saveSalesData(DefaultTableModel model){
		for(int i=0;i<model.getRowCount();i++){
			String[] data = new String[2];
			data[0] = (String)model.getValueAt(i, 0);
			data[1] = (String)model.getValueAt(i, 1);
			FileReader fr = null;
			BufferedReader br = null;
			PrintWriter pw = null;
			FileWriter fw = null;
			//Ŀ�� ����
			try {
				fr = new FileReader("files/coffe.txt");
				br = new BufferedReader(fr);
				String readData = null;
				String saveData = "";
				while((readData = br.readLine())!=null){
					String[] splitdata = readData.split("/");
					//���������� ���Ե� �޴��� ������Ű�� �������� �ҷ��� ���� �״�� saveData�� �״�� �ٽ� ���� �� ���Ͽ� ����
					if(splitdata[0].equals(data[0])){
						int salesCount = Integer.parseInt(data[1]) + Integer.parseInt(splitdata[2]);
						saveData = saveData+splitdata[0]+"/"+splitdata[1]+"/"+salesCount +"\n";
					}else{
						saveData = saveData+readData+"\n";
					}
				}
				fw = new FileWriter("files/coffe.txt");
				pw = new PrintWriter(fw);
				pw.print(saveData);
					
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
					try {
						if(br!= null) br.close();
						if(fr!= null) fr.close();
						if(pw!= null) pw.close();
						if(fw!= null) fw.close();
					} catch (IOException e) {e.printStackTrace();}
			}
			//�� ����
			try {
				fr = new FileReader("files/latte.txt");
				br = new BufferedReader(fr);
				String readData = null;
				String saveData = "";
				while((readData = br.readLine())!=null){
					String[] splitdata = readData.split("/");
					//���������� ���Ե� �޴��� ������Ű�� �������� �ҷ��� ���� �״�� saveData�� �״�� �ٽ� ���� �� ���Ͽ� ����
					if(splitdata[0].equals(data[0])){
						int salesCount = Integer.parseInt(data[1]) + Integer.parseInt(splitdata[2]);
						saveData = saveData+splitdata[0]+"/"+splitdata[1]+"/"+salesCount +"\n";
					}else{
						saveData = saveData+readData+"\n";
					}
				}
				fw = new FileWriter("files/latte.txt");
				pw = new PrintWriter(fw);
				pw.print(saveData);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(br!= null){
						br.close();
					}
					if(fr!= null){
						fr.close();
					}
					if(pw!= null){
						pw.close();
					}
					if(fw!= null){
						fw.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//Ƽ ����
			try {
				fr = new FileReader("files/tea.txt");
				br = new BufferedReader(fr);
				String readData = null;
				String saveData = "";
				while((readData = br.readLine())!=null){
					String[] splitdata = readData.split("/");
					//���������� ���Ե� �޴��� ������Ű�� �������� �ҷ��� ���� �״�� saveData�� �״�� �ٽ� ���� �� ���Ͽ� ����
					if(splitdata[0].equals(data[0])){
						int salesCount = Integer.parseInt(data[1]) + Integer.parseInt(splitdata[2]);
						saveData = saveData+splitdata[0]+"/"+splitdata[1]+"/"+salesCount +"\n";
					}else{
						saveData = saveData+readData+"\n";
					}
				}
				fw = new FileWriter("files/tea.txt");
				pw = new PrintWriter(fw);
				pw.print(saveData);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(br!= null){
						br.close();
					}
					if(fr!= null){
						fr.close();
					}
					if(pw!= null){
						pw.close();
					}
					if(fw!= null){
						fw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
