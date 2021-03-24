public class RemoteController implements Power{
	int battery;
	
	boolean isOn;
	@Override
	public void powerOn(){
		isOn =true;
		System.out.println("컴퓨터 전원을 켭니다.");
	}
	@Override
	public void powerOff(){
		isOn =false;
		System.out.println("컴퓨터 전원을 끕니다.");
	}
	public void setBattery(int b){
		battery = b;
	}
	public void showEnergy(){
		System.out.println("배터리 잔량 : "+ battery);
	}

	public static void main(String args[]){
		AirconRemoteCon a = new AirconRemoteCon();
		a.showEnergy();
		a.setBattery(50);
		a.showEnergy();
		a.temperatureDown();
		a.powerOn();
		a.temperatureUp();
		a.temperatureUp();
		a.temperatureUp();
		System.out.println(a);
	}
}
class AirconRemoteCon extends RemoteController{
	int temperature;
	public void temperatureDown(){
		if(isOn){
			temperature--;
			System.out.println("리모컨을 이용하여 설정온도를 낮춥니다.");
		}
	}
	public void temperatureUp(){
		if(isOn){
			temperature++;
			System.out.println("리모컨을 이용하여 설정온도를 높입니다.");
		}
	}
	@Override
	public String toString(){
		return isOn+" "+battery+" "+temperature;
	}
}