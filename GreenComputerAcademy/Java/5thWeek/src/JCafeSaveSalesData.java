import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
//������ ������ ���� ����Ʈ�� �ִ� ���� �Ǹŷ��� ���� �ڷῡ �ݿ��Ѵ�.
public class JCafeSaveSalesData {
	static void saveSalesData(DefaultTableModel model){
		//������ ù �������� ��� ���ο� ������ ����� �ʱ�ȭ �ڷḦ �������� ���� �Ǹŷ��� ������ų ������ �����. 
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);
		
		//���� ���� �� : jcafe_20201119/coffee.txt �������� ����
		//�ʱ�ȭ �ڷḦ files/coffee.txt�� ���
		File dir = new File("./jcafe_"+dt+"/");
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		File file1 = new File("./jcafe_"+dt+"/coffee.txt");
		File file2 = new File("./jcafe_"+dt+"/latte.txt");
		File file3 = new File("./jcafe_"+dt+"/tea.txt");
		
		initFile(file1,"./files/coffee.txt");
		initFile(file2,"./files/latte.txt");
		initFile(file3,"./files/tea.txt");
		
		//���⼭���� ���������� �����ϴ� �κ�
		for(int i=0;i<model.getRowCount();i++){
			String[] data = new String[2];
			data[0] = (String)model.getValueAt(i, 0);
			data[1] = (String)model.getValueAt(i, 1);
			
			FileReader fr = null;
			BufferedReader br = null;
			PrintWriter pw = null;
			FileWriter fw = null;
			
			saveSales(data,"./jcafe_"+dt+"/coffee.txt");
			saveSales(data,"./jcafe_"+dt+"/latte.txt");
			saveSales(data,"./jcafe_"+dt+"/tea.txt");
		}
	}
	static void initFile(File file,String fileName){
		if(!(file.exists())){
			FileReader fr = null;
			BufferedReader br = null;
			PrintWriter pw = null;
			FileWriter fw = null;
			try {
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);
				fw = new FileWriter(file.getPath());
				pw = new PrintWriter(fw);
				String readData = null;
				while((readData = br.readLine())!=null){
					pw.println(readData);
				}
				
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
		
		
		}
	}
	static void saveSales(String[] data,String fileName){
		FileReader fr = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(fileName);
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
			fw = new FileWriter(fileName);
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
	}
	//����ϴ��� Ȯ���Ϸ��� �־��� �ڵ�
	/*public static void main(String[] args) {
		String[] header = {"1","2"};
		String[][] contents = {{"�Ƹ޸�ī��","10"},{"��������","10"}};
		DefaultTableModel model = new DefaultTableModel(contents,header);
		JCafeSaveSalesData.saveSalesData(model);
	}*/
}
