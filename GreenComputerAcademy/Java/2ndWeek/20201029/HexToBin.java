import java.util.Scanner;
public class HexToBin{
	Scanner sc;
	String[] hexa2bin = {"0000","0001","0010","0011",
						 "0100","0101","0110","0111",
						 "1000","1001","1010","1011",
						 "1100","1101","1110","1111"};
	public HexToBin(){
		sc = new Scanner(System.in);
	}
	public void convert(){
		System.out.print("16진수 문자열을 입력하세요 : ");
		String str = sc.next();
		String[] alpha = {"a","b","c","d","e","f"};
		System.out.print(str+"에 대한 이진수는");
		for(int i =0;i<str.length();i++){ 
			String s1 = str.substring(i,i+1);
			int n1 = 0;
			boolean check = false;
			for(int j=0;j<alpha.length;j++){
				if(s1.equals(alpha[j])){	//문자열은 ==으로 비교불가능
					n1= j+10;
					check = true;
				}
			}
			if(!check){
				n1 = Integer.parseInt(s1);
			}
			System.out.print(" "+hexa2bin[n1]);
			
		}
		System.out.print("입니다.");
		
	}
	public static void main(String args[]){
		HexToBin hb = new HexToBin();
		hb.convert();
	}
}