import java.util.Scanner;
public class ScanTest10{
	public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	System.out.println("소금의 양 : ");
	float salt = scanner.nextFloat();
	System.out.println("소금물의 양 : ");
	float saltWater = scanner.nextInt();
	float density = (salt/saltWater)*100;//(소금의 양/소금물의 양)*100
	System.out.println("소금물의 농도는 : "+density);
	
	
	System.out.println("=============================");
	System.out.println("부채꼴의 반지름 : ");
	float r = scanner.nextFloat();
	System.out.println("부채꼴의 중심각 : ");
	float x = scanner.nextFloat();
	double arcLength = 2*Math.PI * r *(x/360); //부채꼴 호의 길이 = 2*Pi *r *(x/360)
	double sectorArea = 0.5*r*arcLength; //부채꼴의 넓이 = 0.5*r*arcLength r은 반지름 x는 부채꼴의 중심각
	System.out.println("부채꼴의 호의 길이 : "+arcLength);
	System.out.println("부채꼴의 넓이 : "+ sectorArea);
	
	System.out.println("=============================");
	System.out.println("이동거리 : ");
	float distance = scanner.nextFloat();
	System.out.println("걸린시간 : ");
	float time = scanner.nextFloat();
	double speed = distance/time;	//속력 = 이동거리/걸린시간
	System.out.println("속력 : " +speed);
	int velocity;	//속도 = 이동거리/걸린시간???
	}
}
//9 소금물의 농도, 부채콜 호의 길이와 넓이, 속력, 속도