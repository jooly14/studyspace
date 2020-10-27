class Car{
	String color;
	int speed;
	int gear;
	void print(){
		System.out.println("( "+color+", "+speed+", "+gear+" )");
	}	
}
public class CarTest{	//메인메서드가 있는 클래스이름을 기준으로 파일명 작성해야된다. 반드시 public이 붙어있어야한다.
	public static void main(String args[]){
		
		Car myCar =new Car();
		myCar.color ="red";
		myCar.speed = 0;
		myCar.gear = 1;
		myCar.print();
		
		Car yourCar =new Car();
		yourCar.color ="blue";
		yourCar.speed = 60;
		yourCar.gear = 3;
		yourCar.print();
		
		
	}
}