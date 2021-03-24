public class MyCalc implements CalculatorEx{
	@Override
	public void plus(){	//public을 반드시 붙여야됨
		
	}
	@Override
	public void minus(){
		
	}
	public static void main(String args[]){
		MyCalc m = new MyCalc();
		//m.i = 20; 		//인터페이스에서 상수로 구현하지 않았지만 자동으로 final이 붙었다.
	}
}