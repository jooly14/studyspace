import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CaesarTest {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw  = null;
		PrintWriter pw = null;
		String str = null;
		StringBuffer bf = null;
		char c;
		
		//암호화
		try {
			fr = new FileReader("ccc.txt");
			br = new BufferedReader(fr);
			fw = new FileWriter("ddd.txt");
			pw = new PrintWriter(fw);
			while((str = br.readLine())!=null){
				bf = new StringBuffer(str);
				for (int i = 0; i < bf.length(); i++) {
					c = bf.charAt(i);
					if(c!=32){
						c = (char)((int)c-29);
						bf.setCharAt(i, c);
					}
				}
				pw.println(bf);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fr!=null){
						fr.close();
					}
					if (br!=null) {
						br.close();
					}
					if(fw!=null){
						fw.close();
					}
					if (pw!=null) {
						pw.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		
		//복호화
		try {
			fr = new FileReader("ddd.txt");
			br = new BufferedReader(fr);
			fw = new FileWriter("eee.txt");
			pw = new PrintWriter(fw);
			while((str = br.readLine())!=null){
				bf = new StringBuffer(str);
				for (int i = 0; i < bf.length(); i++) {
					c = bf.charAt(i);
					if(c!=32){
						c = (char)((int)c+29);
						bf.setCharAt(i, c);
					}
				}
				pw.println(bf);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fr!=null){
						fr.close();
					}
					if (br!=null) {
						br.close();
					}
					if(fw!=null){
						fw.close();
					}
					if (pw!=null) {
						pw.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
	}
}
