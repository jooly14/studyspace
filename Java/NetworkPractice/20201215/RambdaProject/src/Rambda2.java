@FunctionalInterface
interface IRambda2{
	void sum(int x, int y);
}
public class Rambda2 {
	public static void main(String[] args) {
//		IRambda2 ram = new IRambda2() {
//			
//			@Override
//			public void sum(int x, int y) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		
		IRambda2 ram = (x, y) ->{System.out.println(x+y);};
		ram.sum(5, 10);
		
	}
}
