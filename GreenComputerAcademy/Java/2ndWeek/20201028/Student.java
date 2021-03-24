public class Student{
	int grade;
	String name;
	String gender;
	
	public Student(int grade, String name, String gender){
		this.grade = grade;
		this.name = name;
		this.gender = gender;
	}
	
	public String toString(){
		return "학년 : "+grade+"\n이름 : "+name+"\n성별 : "+gender;
		
	}
	
}