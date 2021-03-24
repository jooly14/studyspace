import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JCafeIpGo {
	static boolean chk;
	public static void ipgo(){
		if(!chk){
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -1);
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			String dt = transFormat.format(cal.getTime());
			System.out.println(dt);
			File dir = new File("./jcafe_order_registration/" + dt + "_orderlist.txt");
			if (dir.exists()) {
				ipgoing(dir);
			}
			chk = true;
		}
	}
	static void ipgoing(File file){
		
		FileReader fr=null;
		BufferedReader br = null;
		String readDataSplit = "";
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String readData = null;
			
			
			while((readData = br.readLine())!=null){
				readDataSplit = readDataSplit + readData + "!";
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] orderDataSplit = readDataSplit.split("!");
		String[][] orderData = new String[3][orderDataSplit.length];
		for(int i=0;i<orderDataSplit.length;i++){
			String[] str = orderDataSplit[i].split("/");
			orderData[0][i] = str[0];
			orderData[1][i] = str[1];
			orderData[2][i] = str[2];
			/*System.out.println(orderData[0][i]);
			System.out.println(orderData[1][i]);
			System.out.println(orderData[2][i]);*/
		}
		
		changeInventory(orderData);
		
		
	}
	
	
	
	static void changeInventory(String[][] orderData) {
		JCafeGetStockData gsd = new JCafeGetStockData();
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("files/inventory.txt");
			pw = new PrintWriter(fw);
			for(int j=0;j<orderData[0].length;j++){
				for(int i=0;i<gsd.inventoryArray[0].length;i++){
					if(gsd.inventoryArray[0][i].equals(orderData[0][j])){
						int bigunit = Integer.parseInt(orderData[1][j]);
						if (orderData[2][j].equals("L")) {
							orderData[2][j] = "ml";
							bigunit = bigunit *1000;
						} else if (orderData[2][j].equals("Kg")) {
							orderData[2][j] = "g";
							bigunit = bigunit *1000;
						} else if (orderData[2][j].equals("Box")) {
							orderData[2][j] = "ea";
							bigunit = bigunit *24;
						} 
						orderData[1][j] =  (Integer.parseInt(gsd.inventoryArray[1][i])+bigunit)+"";
						break;
					}
					
				}
				pw.println(orderData[0][j]+"/"+orderData[1][j]+"/"+orderData[2][j]);
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pw != null) {
					pw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
/*	public static void main(String[] args) {
		JCafeIpGo.ipgo();
	}*/
}
