/*
전원 인터페이스 만들기
컴퓨터
에어컨
라디오 클래스 만들기
전부 전원 인터페이스를 이용
*/
interface Power{
	public void powerOn();
	public void powerOff();
}
class Computer2 implements Power{
	@Override
	public void powerOn(){
		System.out.println("컴퓨터 전원을 켭니다.");
	}
	@Override
	public void powerOff(){
		System.out.println("컴퓨터 전원을 끕니다.");}
}
class Aircon implements Power{
	@Override
	public void powerOn(){
		System.out.println("에어컨 전원을 켭니다.");
	}
	@Override
	public void powerOff(){
		System.out.println("에어컨 전원을 끕니다.");}
}
class Radio implements Power{
	@Override
	public void powerOn(){
		System.out.println("라디오 전원을 켭니다.");
	}
	@Override
	public void powerOff(){
		System.out.println("라디오 전원을 끕니다.");}
}
public class PowerTest{
	private static Power powerArray[];
	public static void main(String args[]){
		init();
		powerON();
		powerOff();
	}
	public static void init(){
		powerArray = new Power[3];
		powerArray[0] = new Computer2();
		powerArray[1] = new Aircon();
		powerArray[2] = new Radio();
	}
	public static void powerON(){
		for(Power p:powerArray){
			p.powerOn();
		}
	}
	public static void powerOff(){
		for(Power p:powerArray){
			p.powerOff();
		}
	}
	
}