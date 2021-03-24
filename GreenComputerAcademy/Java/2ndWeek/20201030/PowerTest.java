/*
전원 인터페이스 만들기
컴퓨터
에어컨
라디오 클래스 만들기
전부 전원 인터페이스를 이용
*/
public interface Power{	//인터페이스의 이름에 I대문자아이를 붙여주는 경우가 많음.
	public void powerOn();	//public 안 써도 기본적으로 public으로 됨
	public void powerOff();
}
class Computer2 implements Power{
	boolean isOn;
	String cpu;
	@Override
	public void powerOn(){
		isOn =true;
		System.out.println("컴퓨터 전원을 켭니다.");
	}
	@Override
	public void powerOff(){
		isOn =false;
		cpu= null;
		System.out.println("컴퓨터 전원을 끕니다.");
	}
	public void setCalc(){
		cpu = "사용중";
	}	
	@Override
	public String toString(){
		return isOn+" "+cpu;
	}		
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
	int frequency;
	@Override
	public void powerOn(){
		System.out.println("라디오 전원을 켭니다.");
	}
	@Override
	public void powerOff(){
		System.out.println("라디오 전원을 끕니다.");
	}
	public void setFrequency(int f){
		frequency = f;
	}
	@Override
	public String toString(){
		return frequency +"";
	}
}
public class PowerTest{
	public static Power powerArray[];
	public static void main(String args[]){
		init();
		powerON();
		System.out.println(powerArray[0]);
		((Computer2)powerArray[0]).setCalc();
		System.out.println(powerArray[0]);
		((Radio)powerArray[2]).setFrequency(130);
		System.out.println(powerArray[2]);
		powerOff();
		System.out.println(powerArray[0]);
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