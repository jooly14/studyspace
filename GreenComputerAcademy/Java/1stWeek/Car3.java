public class Car3{
	int inch;
	int cnt;
	
	
	Car3(Wheel w){
		inch = w.inch;
		cnt = w.cnt;
	}
	
	public static void main(String args[]){
		Wheel w = new Wheel(20,17,"Iron");
		Car3 c = new Car3(w);
		System.out.println(c.cnt);
	}
}