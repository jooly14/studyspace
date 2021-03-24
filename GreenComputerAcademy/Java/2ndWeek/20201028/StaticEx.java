class StaticEx{
	int wheel;
	static String color;	//static변수는 모든 객체가 공유하기 위해 사용한다.
	public StaticEx(int wheel, String color){
		this.wheel = wheel;
		this.color = color;
	}
	@Override
	public String toString(){
		return this.wheel +" "+this.color;
	}
	
	public static void main(String args[]){
		
		System.out.println(StaticEx.color);	//객체를 생성하지 않아도 사용할 수 있다. 프로그램이 시작될때 메모리(스택)에 올라간다.
		StaticEx se = new StaticEx(4,"red");
		System.out.println(se);
		StaticEx se2 = new StaticEx(8,"blue");
		System.out.println(se);
		System.out.println(se2);
		
	}
}