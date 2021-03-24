
public class GenericEx2 {
	public static <T> T getLast(T[] a){
		return a[a.length-1];
	}
	//밑에처럼 일일이 정의하지 않고 하나로 모든 것을 커버할 수 있다!!!
//	public static String getLast(String[] a){
//		return a[a.length-1];
//	}
//	public static Integer getLast(Integer[] a){
//		return a[a.length-1];
//	}
	public static void main(String[] args) {
		//Integer[] integerArray = new Integer[]{1,2,3};
		int i = getLast(new Integer[]{1,2,3});
		System.out.println(i);
		
	}
}
