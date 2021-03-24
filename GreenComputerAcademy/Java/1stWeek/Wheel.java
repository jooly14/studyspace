public class Wheel{
	int cnt;
	int inch;
	String wheelType;
	//생성자가 없으면 기본생성자를 자동으로 생성해준다. 내가 다른 생성자를 만들어 주면 기본생성자는 따로 만들지 않는 이상 사용할 수 없다.
	//생성자
	Wheel(){
		cnt = 4;
		inch = 19;
	}
	
	//매개변수를 갖는 생성자
	Wheel(int c, int i){
		cnt = c;
		inch = i;
		wheelType = "chrome";
	}
	Wheel(int c, int i , String wt){
		cnt = c;
		inch = i;
		wheelType = wt;
	}
	/*
	public static void main(String args[]){
		Wheel w = new Wheel();
		Wheel w2 = new Wheel(5, 7);
		Wheel w3 = new Wheel(10,20,"Iron");
		System.out.println(w.cnt);
		System.out.println(w2.cnt);
		System.out.println(w3.cnt);
		System.out.println(w.wheelType);
		System.out.println(w2.wheelType);
		System.out.println(w3.wheelType);
		
	}
	*/
}