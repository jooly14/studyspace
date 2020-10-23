import java.util.Scanner;
public class Metropolis{
	Scanner sc;
	int population;	//인구수
	int richPop; //소득이 1억이상인 인구수
	boolean capital; //수도여부
	String metro = ""; //메트로폴리스 여부
	//스캐너 초기화
	void init(){
		sc = new Scanner(System.in);
	}
	//인구수, 연소득 1억이상 인구수, 수도여부를 입력받음, 조건에 일치하는 경우 메트로폴리스라고 저장
	void insertInfo(){
		metro = "";
		System.out.print("도시의 인구수를 입력하시오 : ");
		population =sc.nextInt();
		System.out.print("연 소득 1억 이상인 인구수를 입력하시오 : ");
		richPop = sc.nextInt();
		System.out.print("수도 여부를 입력하시오(1.YES ,2.NO) : ");
		int i = sc.nextInt();
			if(i==1){
				capital=true;
			}else{
				capital=false;
			}
		if(population>=1000000&&richPop>=500000&&capital){
			metro = "메트로폴리스입니다.";
		}else{
			metro = "메트로폴리스가 아닙니다.";
		}
	}
	//메트로폴리스 여부를 출력
	void print(){
		System.out.println(metro);
	}
	//메뉴를 보여줌
	void menu(){
		init();
		for(;;){
			System.out.print("원하시는 메뉴를 선택하시오(1.정보입력, 2.출력, 3.종료) : ");
			int sel = sc.nextInt();
			if(sel==1){
				insertInfo();
			}else if(sel==2){
				print();
			}else if(sel==3){
				break;
			}else{
				System.out.println("숫자 1,2,3 중에 입력하시오");
			}
		}
	}
	
	public static void main(String args[]){
		Metropolis mp = new Metropolis();
		mp.menu();
		
	}
}
/*
인구수/ 연소득 50만불 이상 인구수/수도 여부 <-입력받음
메트로폴리스(거대도시)
입력을 하고 나면 메트로폴리스인지 여부가 출력되면 됨.
*/
//\\192.168.100.247