class Human{
	private String name;
	private int age;
	private String job;
	public Human(String name, int age){
		this.name = name;
		this.age = age;
		System.out.println("부모클래스 생성자 호출");
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	public void setJob(String job){
		this.job = job;
	}
	public String getJob(){
		return job;
	}
	public String toString(){
		return name +" "+age;
	}
	
}
public class Student2 extends Human{
	private String major;
	public Student2(String name ,int age ,String major){
		/*
		setName(name);
		setAge(age);
		*/
		super(name, age);
		setMajor(major);				
		System.out.println("자식클래스 생성자 호출");
	}
	public String getMajor(){
		return major;
	}
	public void setMajor(String major){
		this.major = major;
	}
	public String toString(){
		return super.toString()+" "+major;
	}
	public String getJob(){
		return "직업은 학생입니다.";
	}
	public static void main(String args[]){
		Human h1 = new Human("춘향",18);
		Human h2 = new Human("몽룡",21);
		Human h3 = new Human("사또",50);
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
		h3.setJob("선생님");
		System.out.println(h3.getJob());
		
		Student2 s1 = new Student2("명진",21,"컴퓨터");
		Student2 s2 = new Student2("미현",22,"경영");
		Student2 s3 = new Student2("용준",24,"경제");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s3.getJob());
		
		
	}
}