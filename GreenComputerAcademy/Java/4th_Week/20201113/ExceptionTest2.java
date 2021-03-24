package java.yj;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw;
		try {
			fw = new FileWriter("out.txt");
			PrintWriter pw = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
