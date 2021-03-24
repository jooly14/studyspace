import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CombineFile {
	String name1;
	String name2;
	String name3;
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fw  = null;
	PrintWriter pw = null;
	String str = null;
	public CombineFile(String name1, String name2, String name3) {
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
	}
	void combineFile(){
		try {
			fr = new FileReader("ccc.txt");
			br = new BufferedReader(fr);
			fw = new FileWriter("fff.txt");
			pw = new PrintWriter(fw);
			while((str = br.readLine())!=null){
				pw.println(str);
			}
			if(fr!=null){
				fr.close();
			}
			if(br!=null){
				br.close();
			}
			fr = new FileReader("ddd.txt");
			br = new BufferedReader(fr);
			while((str = br.readLine())!=null){
				pw.println(str);
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
	public static void main(String[] args) {
		new CombineFile("ccc.txt", "ddd.txt", "fff.txt").combineFile();
	}
}
