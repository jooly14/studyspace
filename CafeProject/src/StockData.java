import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StockData {
	static void stockManage(){
		FileReader fr = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		FileWriter fw = null;
		
		String coffeIdx = "";
		String materialStr = "";
		
		
		try {
			fr = new FileReader("files/coffe.txt");
			br = new BufferedReader(fr);
			String readData = null;
			String saveData = "";
			int idx=0;
			while((readData = br.readLine())!=null){
				String[] splitdata = readData.split("/");
				//���������� ���Ե� �޴��� ������Ű�� �������� �ҷ��� ���� �״�� saveData�� �״�� �ٽ� ���� �� ���Ͽ� ����
				if(!(splitdata[2].equals("0"))){
					coffeIdx = coffeIdx + idx +"/";
				}
				idx++;
			}
				
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
		
		//���  ǰ�� �������� // � ��� ������ �ִ��� ã�ƿ´�
		try {
			fr = new FileReader("files/inventory.txt");
			br = new BufferedReader(fr);
			String readData = null;
			
			
			while((readData = br.readLine())!=null){
				String[] materialData = readData.split("/");
				materialStr = materialStr+materialData[0]+"/";
				
			}
			/*fw = new FileWriter("files/coffe.txt");
			pw = new PrintWriter(fw);
			pw.print(saveData);*/
				
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
		
		
		//��� ǰ���� �迭�� �־���. �׿� �����ϴ� ��뷮 �迭�� ����
		//�ε����� ���� ����� ����
		String[] materialArray = materialStr.split("/");
		int[] useTotal = new int[materialArray.length];
		//������ ���������� �ִ� �޴����� ã�Ƽ� ��� ��뷮�� �����´�.
		//���� �޴� ���� ������ �ݿ����� ����.
		try {
			fr = new FileReader("files/coffe_material.txt");
			br = new BufferedReader(fr);
			String readData = null;
			String materStr = "";
			int idx=0;
			String[] cofIdxArray = coffeIdx.split("/");
			for(int i=0;i<cofIdxArray.length;i++){
				while((readData = br.readLine())!=null){
					if(idx==Integer.parseInt(cofIdxArray[i])){
						String[] usemat = readData.split("/");
						for(int k=0;k<materialArray.length;k++){
							for(int j=1;j<usemat.length;j+=2){
								if(usemat[j].equals(materialArray[k])){
									System.out.println(usemat[j]);
									useTotal[k] = useTotal[k] + Integer.parseInt(usemat[j+1]);
									System.out.println(useTotal[k]);
								}
							}
							
						}
						break;
					}
					idx++;
				}
				
			}
			System.out.println(materStr);
			/*fw = new FileWriter("files/coffe.txt");
			pw = new PrintWriter(fw);
			pw.print(saveData);*/
				
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
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockData sd = new StockData();
		sd.stockManage();
	}

}
