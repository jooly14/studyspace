class BankAccount{
	private int accountNumber;
	private String owner;
	private int balance;
	
	public void deposit(int amount){
		balance+=amount;
	}
	public void withdraw(int amount){
		balance-=amount;
	}
	public String toString(){
		return "현재 잔액은 "+balance+"입니다.";
	}
	public void transfer(int amount, BankAccount otherAccount){
		withdraw(amount);
		otherAccount.deposit(amount);
	}
}

public class BankAccountTest{
	public static void main(String args[]){
		BankAccount myAccount = new BankAccount();
		myAccount.deposit(10000);
		System.out.println(myAccount);
		myAccount.withdraw(8000);
		System.out.println(myAccount);		
		BankAccount yourAccount = new BankAccount();
		myAccount.deposit(10000);
		myAccount.transfer(6000,yourAccount);
		System.out.println(myAccount);		
		System.out.println(yourAccount);		
		
	}
}