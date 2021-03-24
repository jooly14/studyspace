import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class ReadWriteEx {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		
		Vector<Integer> intList = new Vector<>();
		
		try {
			fr = new FileReader("aaa.txt");
			br = new BufferedReader(fr);
			String str;
			while((str = br.readLine())!=null){
				intList.add(Integer.parseInt(str));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fr != null){
						fr.close();
					}
					if(br!=null){
						br.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

//		Collections.sort(intList);
		int temp;
		for (int i = 0; i < intList.size()-1; i++) {
			for (int j = 0; j < intList.size()-1; j++) {
				if(intList.get(j)>intList.get(j+1)){
					temp = intList.get(j);
					intList.remove(j);
					intList.add(j+1,temp);
					
				}
			}
		}
		
		for (int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		
		try {
			fw = new FileWriter("bbb.txt");
			pw = new PrintWriter(fw);
			for (int i = 0; i < intList.size(); i++) {
				pw.println(intList.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fw!=null){
					fw.close();
				}
				if(pw!=null){
					pw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
}
