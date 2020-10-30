class RemoteController implements Power{
	@Override
	public void powerOn(){
		System.out.println("리모컨을 이용하여 전원을 켭니다.");
	}
	@Override
	public void powerOff(){
		System.out.println("리모컨을 이용하여 전원을 끕니다.");
	}
}
class AirconRemoteCon extends RemoteController{
	public void temperatureDown(){
		System.out.println("리모컨을 이용하여 설정온도를 낮춥니다.");
	}
	public void temperatureUp(){
		System.out.println("리모컨을 이용하여 설정온도를 높입니다.");
	}
}