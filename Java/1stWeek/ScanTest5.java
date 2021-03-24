import java.util.Scanner;
public class ScanTest5{
	public static void main(String args[]){
	//4.키와 몸무게를 입력받아 체지방률을 출력하시오.
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("몸무게를 입력해주세요 : ");
		float weight=scanner.nextFloat();//몸무게
		System.out.println("키를 입력해주세요 : ");
		float height=scanner.nextFloat();//키
		float result= (1.1f*weight) - (128f*((weight*weight)/(height*height)));//남성의 제지방량 계산
		//float fResult= (1.07f*weight) - (128f*((weight*weight)/(height*height)));//여성의 제지방량 계산
		//float result1 = weight - result;//체지방량 계산
		float result2 = (result*100)/weight;//제지방률 계산
		float result3 = 100-result2;//제지방률을 이용해서 체지방률 계산
		//float result3_1 = (result1*100)/weight;//체지방량을 이용해서 체지방률을 계산
		System.out.println(result3);
	
	
	}
}