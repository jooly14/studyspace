public class ArrayErrorEx{
	public static void main(String args[]){
		Student[] students = new Student[10];
		Student std = new Student() ;
		students[0] =std;
		/*
		students[10] =std;
		//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10
		at ArrayErrorEx.main(ArrayErrorEx.java:5)
		
		Student[] students;
		students[0] =std;
		//ArrayErrorEx.java:5: error: variable students might not have been initialized
		students[0] =std;
		^
		1 error
		*/
		
		int[] ints = {1,2,3,4,5,6,7,8,9,0};
		for(int x : ints){
			System.out.print(x+" ");
		}
		
	}
}