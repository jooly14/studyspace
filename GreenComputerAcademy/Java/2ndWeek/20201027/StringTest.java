import java.util.Scanner;
public class StringTest{
	public static void main(String args[]){
		String proverb = "A barking dog";
		String s1, s2, s3, s4;
		System.out.println("문자열의 길이 = " +proverb.length());
		char c1;
		s1 = proverb.concat(" never Bites!");	//+연산자로 대체 가능하기 때문에 잘 사용되지 않음
		s2 = proverb.replace('A','a');
		s3 = proverb.substring(2,5);	//글자를 자른다.
		s4 = proverb.toUpperCase();
		c1 = proverb.charAt(0);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(c1);
		System.out.println(proverb.equalsIgnoreCase("a Barking Dog"));
		System.out.println(proverb.replace("barking","sleeping"));
		//replaceAll()은 정규식을 이용
		System.out.println(proverb.toLowerCase());
		System.out.println("====================================");
		
		String str = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(str.indexOf("f"));
		System.out.println(str.substring(0,2));
		/*
		이를 이용하여 특정한 문자를 입력하면 (예를들어 bc)를 
		입력하면 bc 이후의 모든 글자를 출력하게 하세요.
		결과=> defghijklmn
		hint: length() 메서드를 추가로 이용하면 쉽습니다.
		*/
		System.out.println("알파벳을 입력하시오 : ");
		Scanner sc = new Scanner(System.in);
		String user = sc.next();
		int index = str.indexOf(user);
		String result = str.substring(index+user.length());
		System.out.println(result);
	}
}