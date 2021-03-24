import java.util.Scanner;
public class ScanTest9{
	public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	System.out.println("직육면체의 가로 :");
	int i = scanner.nextInt();
	System.out.println("직육면체의 세로 :");
	int j = scanner.nextInt();
	System.out.println("직육면체의 높이 :");
	int k = scanner.nextInt();
	int cuboid = (i*j)*2 + ((i+j)*k*2);	//밑넓이*2+옆넓이
	int cuboidVolume = i*j*k;	//가로*세로*높이
	System.out.println("직육면체의 겉넓이 : "+cuboid);
	System.out.println("직육면체의 부피 : "+cuboidVolume);
	
	System.out.println("====================================");
	System.out.println("정육면체의 모서리 하나의 길이 :");
	int ㅣ = scanner.nextInt();
	int cube = (ㅣ*ㅣ)*6;	//한면의 넓이*6
	System.out.println("정육면체의 겉넓이 : "+cube);
	
	System.out.println("====================================");
	System.out.println("원의 반지름 길이 :");
	int m = scanner.nextInt();
	double circleLength = m*2*Math.PI; 	//반지름*2*3.14
	double circleArea = m*m*Math.PI;	 	//반지름*반지름*3.14
	System.out.println("원주 : "+circleLength);
	System.out.println("원의 넓이 : "+circleArea);
	}
}

//8 java 폴더의 "초등학교 6학년 수학 공식"을 보고 각 프로그램을 작성하시오.