import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JCafeUseStempToSave {
	
	FileReader fr;
	BufferedReader br;
	
	FileWriter fw;
	PrintWriter pw;
	
	public JCafeUseStempToSave(String phoneNum,int stempCnt) {
		try {

			fr=new FileReader(new File("JCafeStempData\\JCafeStempData.txt"));
			br=new BufferedReader(fr);
			
			String[]data=null;
			String l=null;
			String save="";
			int cnt=0;
			while((l=br.readLine())!=null){
				save=save+l+"!";
				cnt++;
			}
			data=save.split("!");//���⼭ a �迭�� ���� ������ ����������
			
			fw=new FileWriter(new File("JCafeStempData\\JCafeStempData.txt"));//���⼭ ���� �����Ͱ� �ʱ�ȭ��
			pw=new PrintWriter(fw);
			
			boolean haveOrNot=true; // �űԻ�������� ������������� �Ǻ�
			
			for(int i=0;i<data.length;i++){
				String[] str=data[i].split("/"); // �迭�� ������ ��ȣ,���������� �޾ƿ�
				if(str[0].equals(phoneNum)){ // ������ �������� ��ȣ�� �Է��� ��ȭ��ȣ�� ���ٸ�
					pw.println(phoneNum+"/"+stempCnt); // �Է��ѹ�ȣ/��� �� ������  �Է�
					haveOrNot=false;//�űԻ���������� false�� �ٲ۴�.
				}else//�Է��� ��ȣ�� �ƴ϶��
					pw.println(data[i]);// ������ �����͸� �ٽ� �Է�
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}try{
			if(fw!=null) fw.close();
			if(fr!=null) fr.close();
			if(br!=null) br.close();
			if(pw!=null) pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JCafeUseStempToSave("01073745309", 3);
	}
}
