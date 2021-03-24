import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScanTest {
	public static void main(String[] args) {
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new BufferedReader(new FileReader("input.txt")));
			
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (scanner!=null) {
				scanner.close();
			}
		}
	}
}
