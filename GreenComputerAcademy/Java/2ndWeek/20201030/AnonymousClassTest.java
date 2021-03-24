interface RemoteControl2{
	void turnON();
	void turnOFF();
}
public class AnonymousClassTest{
	public static void main(String args[]){
		RemoteControl2 r = new RemoteControl2(){
			@Override
			public void turnON(){
				System.out.println("TV turnON()");
			}
			@Override
			public void turnOFF(){
				System.out.println("TV turnOFF()");
			}
		};
		r.turnON();
		r.turnOFF();
	}
}