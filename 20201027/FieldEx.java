public class FieldEx{
	int i;	//전역변수
			//전역변수는 자동으로 초기화됨 int i = 0;
	void sum(){
		int y=2; //지역변수 자동으로 초기화 안됨
		System.out.println(i+y);
	}
	
	public static void main(String args[]){
		FieldEx fe = new FieldEx();
		fe.sum();
	}
}