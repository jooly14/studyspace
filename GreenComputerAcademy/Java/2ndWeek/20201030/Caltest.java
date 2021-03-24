class Cal1 implements CalculatorEx{
	public int m = 30;
	@Override
	public void plus(){}
	@Override
	public void minus(){}
	public void MyMethod1(){}
}
class Cal2 implements CalculatorEx{
	@Override
	public void plus(){}
	@Override
	public void minus(){}
	public void MyMethod2(){}
}
public class Caltest{
	public static void main(String args[]){
	CalculatorEx c1 = new Cal1();
	CalculatorEx c2 = new Cal2();
	
	Cal1 c3 = new Cal1();
	Cal2 c4 = new Cal2();
	//c1.MyMethod1();
	//c2.MyMethod2();
	//c1.m = 0;
	c3.m = 0;
	c3.MyMethod1();
	c4.MyMethod2();
	}
}