class DeskLamp{
	private boolean isOn;
	public void turnOn(){
		isOn = true;
	}
	public void turnOff(){
		isOn = false;
	}
	@Override	//애노테이션을 붙여 오버라이딩했음을 표시하고 있다. 오버라이딩하지 않는 경우 에러 발생
	public String toString(){	//object클래스의 메서드를 오버라이딩(Overriding) ~~ String클래스에서도 오버라이딩했음.
		return "현재 상태는 "+(isOn?"켜짐":"꺼짐");
	}
	
}
public class DeskLampTest{
	public static void main(String args[]){
		DeskLamp myLamp = new DeskLamp();
		myLamp.turnOn();
		System.out.println(myLamp);
		// System.out.println(myLamp.toString());	이렇게 써도 결과가 똑같음
		myLamp.turnOff();
		System.out.println(myLamp);
	}
}