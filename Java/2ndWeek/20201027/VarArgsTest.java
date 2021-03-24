class Test{
	void sub(String s,int...v){//가변길이인수	가변길이인수 앞에 딱 한개 다른 타입의 매개변수를 넣을 수 있다.
		System.out.println("인수의 개수 : "+v.length);	//string.length()	배열.length	컬렉션타입.size()
		for(int x:v){
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
}
public class VarArgsTest{ 
	public static void main(String args[]){
		Test t = new Test();
		t.sub("hi",1);
		t.sub("hi",2,3,4,5,6);
		t.sub("hi");
	}
}