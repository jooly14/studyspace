public class Car{
	String color;	//변수
	int speed;
	boolean gear;
	void print(){	//기능
		System.out.println(color + speed +gear);
	}
	void print(int a, String x){
		System.out.println(a+x);	//이름은 같지만 매개변수가 다른 경우 에러가 나지 않는다. 
	}								//하지만 같은 자료형의 매개변수를 쓰거나 반환값이 다른 것은 같은 메서드로 취급해서 오류가 난다.
	int myMethod(int num1 , int num2){
		int result =num1+num2; 	
		return result;
	}
	
	public static void main(String args[]){
		Car hsCar = new Car();	//new가 새로운 객체를 만들어냄
		Car hsCar2 = new Car();
		
		hsCar.color = "red";
		hsCar.speed = 10;
		hsCar.gear = true;
		
		hsCar2.color = "blue";
		hsCar2.speed = 20;
		hsCar2.gear = false;
		
		/*
		System.out.println(hsCar.color);
		System.out.println(hsCar.speed);
		System.out.println(hsCar.gear);
		*/
		hsCar.print();
		hsCar2.print();
		hsCar.print(10, "aaa");
		
		int x = hsCar.myMethod(5,10);
		System.out.println(x);
	}
}