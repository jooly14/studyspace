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
				//결제내역에 포함된 메뉴만 증가시키고 나머지는 불러온 내역 그대로 saveData에 그대로 다시 저장 후 파일에 저장
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
		
		//재고  품목 가져오기 // 어떤 재고를 가지고 있는지 찾아온다
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
		
		
		//재고 품목을 배열에 넣었다. 그에 상응하는 사용량 배열을 생성
		//인덱스를 같이 사용할 예정
		String[] materialArray = materialStr.split("/");
		int[] useTotal = new int[materialArray.length];
		//오늘의 결제내역에 있는 메뉴들을 찾아서 재고 사용량을 가져온다.
		//아직 메뉴 구매 갯수는 반영하지 못함.
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
