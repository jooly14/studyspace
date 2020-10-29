class ClassA{
	public void methodOne(int i){}
	public void methodTwo(int i){}
	public static void methodThree(int i){}
	public static void methodFour(int i){}
}
class ClassB extends ClassA{
	// public static void methodOne(int i){}	//정적메서드로는 인스턴스메서드를 오버라이드 할수 없다.
	public void methodTwo(int i){}
	//public void methodThree(int i){}	//인스턴스메서드로 정적메서드를 오버라이드 할수 없다.
	public static void methodFour(int i){}
}	//결론적으로 헤더가 같아야되는거 같다.