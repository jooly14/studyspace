import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		File dir = new File("D:/kyj_java/workspace");
		String[] filenames = dir.list();
		for(String s : filenames){
			File f = new File(s);
			System.out.println("========================================");
			System.out.println("이름 "+f.getName());
			System.out.println("경로 "+f.getPath());
			System.out.println("부모 "+f.getParent());
			System.out.println("절대경로 "+f.getAbsolutePath());
			System.out.println("정규경로 "+f.getCanonicalPath());
			System.out.println("디렉토리 여부 "+f.isDirectory());
			System.out.println("파일 여부 "+f.isFile());
			System.out.println("========================================");
			
		}
		
		
	}
}
