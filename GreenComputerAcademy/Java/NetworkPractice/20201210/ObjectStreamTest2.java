import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ObjectStreamTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		
		System.out.print("�о�� ���� ��ġ�� �Է��ϼ���:");
		String fileLocationIn = sc.nextLine();
		System.out.print("����� ��ġ�� �Է��ϼ���:");
		String fileLocationOut = sc.nextLine();
		System.out.println(fileLocationOut);
		
		File file = new File(fileLocationIn);
		
		try {
			out = new ObjectOutputStream(new FileOutputStream("d:/tmp.dat"));
			out.writeObject(file);
			
			
			in = new ObjectInputStream(new FileInputStream("d:/tmp.dat"));
			file = (File)in.readObject();
			file.renameTo(new File(fileLocationOut));
			if(file.createNewFile()){
				System.out.println("����Ǿ���");
			}else{
				System.out.println("���� ����");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(out!=null){
						out.close();
					}
					if(in!=null){
						in.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
