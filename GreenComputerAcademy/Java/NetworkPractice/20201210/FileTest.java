import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		File dir = new File("D:/kyj_java/workspace");
		String[] filenames = dir.list();
		for(String s : filenames){
			File f = new File(s);
			System.out.println("========================================");
			System.out.println("�̸� "+f.getName());
			System.out.println("��� "+f.getPath());
			System.out.println("�θ� "+f.getParent());
			System.out.println("������ "+f.getAbsolutePath());
			System.out.println("���԰�� "+f.getCanonicalPath());
			System.out.println("���丮 ���� "+f.isDirectory());
			System.out.println("���� ���� "+f.isFile());
			System.out.println("========================================");
			
		}
		
		
	}
}
