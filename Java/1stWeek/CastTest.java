public class CastTest{
	public static void main(String args[]){
		//형변환이란 현재의 타입을 다른 타입으로 바꾸는 것
		
		String str = "안녕";
		int num = 1234;
		//str+num //문자랑 다른 자료형을 더하면 자동으로 문자로 형변환
		
		double result1;
		result1 = num + 0.5; //double과 int를 더하면 자동으로 double 타입으로 변환
		System.out.println(result1);
		
		int result2;
		result2 = num + (int)1.5; //double형을 int로 형 변환 하면 0.5가 사라짐
		System.out.println(result2);
		
		double d = 100;	//double형에 넣으면 자동으로 소수점이 생김
		System.out.println(d);
		
		// int byte boolean char 기본 자료형
		// String 레퍼런스타입 참조자료형 클래스타입변수 <= 클래스이므로 메서드가 있다.
		
		String str1 = "abcdefg";
		System.out.println(str1.charAt(1));
		
		//기본자료형들도 래퍼클래스를 가지고 있다.
		//Integer Byte Boolean Character
		
		Integer.parseInt("123");	//문자를 숫자로 변환
		Boolean.parseBoolean("true"); //문자를 불린형으로 변환
		String str3 = 123+""; //숫자를 문자로 변환
		
		String num1 = "123";
		String num2 = "2";
		int num3 = 5;
		System.out.println(Integer.parseInt(num1)+Integer.parseInt(num2)+num3);
		
	}
}