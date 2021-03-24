import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {
	public static void main(String[] args) {
		DataInputStream in  = null;
		DataOutputStream out = null;
		
		try {
			int c;
			out  = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bin")));
			
			out.writeDouble(3.14);
			out.writeInt(100);
			out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다.");
			
			out.flush();

			in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));
			
			System.out.println(in.readDouble());
			System.out.println(in.readInt());
			System.out.println(in.readUTF());
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(in!=null){
						in.close();
					}
					if (out!=null) {
						out.close();
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
