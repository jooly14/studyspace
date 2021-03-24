
public class Rambda1 {
	public static void main(String[] args) {
		Person p = new Person();
		p.hi((a,b)->{return a+b;});
	}
}
@FunctionalInterface
interface Say{
	int something(int x, int y);
}

class Person{
	public void hi(Say line){
		int num = line.something(3, 4);
		System.out.println("°ªÀº "+num);
	}
}