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
//결제가 끝나면 메인 리스트에 있던 음료 판매량을 누적 자료에 반영한다.
public class JCafeSaveSalesData {
	static void saveSalesData(DefaultTableModel model){
		//오늘의 첫 결제였던 경우 새로운 폴더를 만들고 초기화 자료를 바탕으로 오늘 판매량을 누적시킬 파일을 만든다. 
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);
		
		//폴더 파일 명 : jcafe_20201119/coffee.txt 형식으로 저장
		//초기화 자료를 files/coffee.txt를 사용
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
		
		//여기서부터 본격적으로 저장하는 부분
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
				//결제내역에 포함된 메뉴만 증가시키고 나머지는 불러온 내역 그대로 saveData에 그대로 다시 저장 후 파일에 저장
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
	//기능하는지 확인하려고 넣었던 코드
	/*public static void main(String[] args) {
		String[] header = {"1","2"};
		String[][] contents = {{"아메리카노","10"},{"아포가토","10"}};
		DefaultTableModel model = new DefaultTableModel(contents,header);
		JCafeSaveSalesData.saveSalesData(model);
	}*/
}
