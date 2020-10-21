import java.util.Scanner;
public class ControlTest4{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("알파벳을 입력하세요");
		char c = scanner.next().charAt(0);
		
		switch(c){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'y':	System.out.println("모음");
			break;
			default: System.out.println("자음");
		
		}
		
	}
}
/*
case 'b': case 'c': case 'd': case 'f': case 'g':
			case 'h': case 'j': case 'k': case 'l': case 'm':
			case 'n': case 'p': case 'q': case 'r': case 's':
			case 't': case 'v': case 'w': case 'x': case 'z':
영문 알파벳 1개를 입력 받아 모음인지 자음인지 출력하는 프로그램
입력 : a
모음 <=  출력
*/