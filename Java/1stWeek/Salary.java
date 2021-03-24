//월급에서 세금 보험료를 계산하고 실수령액을 계산한다.
public class Salary{
	int salary;
	double tax;
	int insurance;
	double total;
	
	void insertSalary(int salary){
		this.salary = salary;
	}
	void calTax(int i){
		this.tax = i*0.01;
	}
	void calInsurance(int insurance){
		this.insurance = insurance;
		calcTotal();
	}
	void calcTotal(){
		this.total = salary*(1-tax)-insurance;
	}
	
	void showRealSalary(){
		System.out.println("월급 "+salary+"만원, 세금" +(int)(tax*100)+"%, 보험료 "+insurance+"만원");
		System.out.println("실 수령액 "+ (int)total +"만원");
	}
	public static void main(String args[]){
		Salary s = new Salary();
		s.insertSalary(1000);
		s.calTax(5);
		s.calInsurance(50);
		s.showRealSalary();		//월급 1000만원, 세금 5%, 보험료  50만원 //실 수령액 xxx만원
	}
}