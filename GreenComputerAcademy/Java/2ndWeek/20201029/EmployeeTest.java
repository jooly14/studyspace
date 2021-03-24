import java.util.Scanner;
class Employee{
	String name;
	String address;
	int salary;
	String phone;
	public Employee(String name, String address, int salary, String phone){
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.phone = phone;
	}
	
	public String toString(){
		return name +" "+address+" "+salary+" "+phone;
	}
}
public class EmployeeTest{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Employee[] employees = new Employee[3];
		for(int i=0; i<employees.length;i++){
			System.out.println("직원 정보 입력");
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("주소 : ");
			String address = sc.next();
			System.out.print("연봉 : ");
			int salary = sc.nextInt();
			System.out.print("전화번호 : ");
			String phone = sc.next();
			employees[i] = new Employee(name,address,salary,phone);
		}
		for(int i=0; i<employees.length;i++){
			System.out.println(employees[i]);
		}	
	}
}