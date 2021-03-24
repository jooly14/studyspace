import java.util.Scanner;

public class ArrayEx2{
	final int STUDENTS =5;
	int total;
	int[] points = new int[STUDENTS];
	Scanner sc;
	private void init(){
		sc = new Scanner(System.in);
	}
	private void input(){
		for(int i=0; i<STUDENTS;i++){
		System.out.println("점수를 입력하시오 : ");
		points[i]  = sc.nextInt();
		}
	}
	private String getAve(){
		for(int i=0;i<STUDENTS;i++){
			total = total + points[i];
		}
		return "평균 성적은 "+total/STUDENTS+ "입니다.";
	}
	public String run(){
		init();
		input();
		return getAve();
	}
	public static void main(String args[]){
		ArrayEx2 ae = new ArrayEx2();
		System.out.println(ae.run());
		
	}
}