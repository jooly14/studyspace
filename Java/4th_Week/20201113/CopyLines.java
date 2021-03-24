import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("files/input.txt");
			fw = new FileWriter("output.txt", true);
			inputStream = new BufferedReader(fr);
			outputStream = new PrintWriter(fw);

			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}

				if (outputStream != null) {
					outputStream.close();
				}
				if (fr != null) {
					fr.close();
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

}
