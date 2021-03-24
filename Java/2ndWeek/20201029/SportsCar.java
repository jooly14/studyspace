class Car{
	int speed;
	int gear;
	public String color;
	/*
	Car(){
		color = "red";
	}
	*/
	Car(String color){
		this.color = color;
	}
	
	public void speedUp(int increment){
		speed +=increment;
	}
	public void speedDown(int decrement){
		speed -= decrement;
	}
	public void carPrint(){
		System.out.println(speed+" "+color);
	}
	
}
public class SportsCar extends Car{
	boolean turbo;
	public String color ="purple";	//부모클래스와 같은 변수명을 사용하면 본인의 변수가 우선 사용됨. 부모클래스의 변수를 사용하려면 super를 반드시 붙여야함 Car형으로 선언해도 마찬가지 가상메서드랑 비슷한듯
	SportsCar(){
		super("red");	//따로 부모클래스의 생성자를 명시하지 않으면 부모클래스의 디폴트 생성자가 호출된다.
	}
	@Override
	public void carPrint(){
		System.out.println(color);
		System.out.println(this.color);
		System.out.println(super.color);
	}
	public void setTurbo(boolean newValue){
		turbo = newValue;
		this.speedDown(10);
	}
	@Override
	public void speedUp(int i){	//오버라이드 _매개변수 이름은 상관없음
		super.speed+=i;
		super.speed+=i;
	}
	public static void main(String args[]){
		Car sc = new SportsCar();
		//sc.color ="Red";
		//sc.speedUp(100);
		//sc.speedDown(30);
		//sc.setTurbo(true);
		//sc.carPrint();
		//sc.print();
		Car c = new Car("silver");
		System.out.println(c.getClass());
		System.out.println(c.getClass().getName());
		System.out.println(sc.getClass().getName());
	}
}