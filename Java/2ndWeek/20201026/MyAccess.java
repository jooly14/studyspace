public class MyAccess{
	private void print(){
		System.out.println("private");
	}
	public void print2(){
		System.out.println("public");
	}
	public static void main(String args[]){
		MyAccess ma = new MyAccess();
		ma.print();
		ma.print2();
		
		
	}
}