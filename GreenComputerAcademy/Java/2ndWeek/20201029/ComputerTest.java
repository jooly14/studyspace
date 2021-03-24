class Computer{
	protected boolean power; 
	public void screenOutput(){
		if(power){
			System.out.println("화면을 출력합니다.");
		}else{
			System.out.println("전원이 꺼져있어 화면을 출력할 수 없습니다.");
		}
	}
	public void turnOn(){
		power = true;
		System.out.println("전원이 켜집니다.");
	}
	public void turnOff(){
		power = false;
		System.out.println("전원이 꺼집니다.");
	}
}
class Notebook extends Computer{
	int battery = 100;
	
	public void useBattery(){
		battery = battery - 5;
		System.out.println("배터리를 사용합니다.");
		System.out.println("배터리량 : "+ battery);
	}
	public void chargeBattery(){
		battery = battery +5;
		System.out.println("배터리를 충전합니다.");
		System.out.println("배터리량 : "+ battery);
	}
}

class Desktop extends Computer{
	public void turnOn(){
		System.out.print("데스크탑 ");
		super.turnOn();
	}
	public void turnOff(){
		System.out.print("데스크탑 ");
		super.turnOff();
	}
}
class Smartphone extends Notebook{
	public void call(){
		System.out.println("통화를 합니다.");
	}
	public void turnOn(){
		System.out.print("스마트폰 ");
		super.turnOn();
	}
	public void turnOff(){
		System.out.print("스마트폰 ");
		super.turnOff();
	}
	
}
public class ComputerTest{
	public static void main(String args[]){
		Smartphone sp = new Smartphone();
		sp.turnOn();
		sp.screenOutput();
		sp.turnOff();
		sp.useBattery();
		sp.useBattery();
		sp.chargeBattery();
		sp.call();
		Desktop d = new Desktop();
		
		d.turnOn();
		d.turnOff();
		d.screenOutput();
		
	}
}
/*
컴퓨터 클래스 작성
컴퓨터를 상속받은 노트북/데스크탑
노트북을 상속받은 스마트폰

공통기능
화면출력
전원켜기
전원끄기

*/