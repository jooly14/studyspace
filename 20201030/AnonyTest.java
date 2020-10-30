interface Controllable{
	void play();
	void stop();
}
public class AnonyTest{
	public static void main(String args[]){
		Controllable c = new Controllable(){
			@Override
			public void play(){
				System.out.println("play");
			}
			public void stop(){
				System.out.println("stop");
			}
		};
		c.play();
		c.stop();
	}
}