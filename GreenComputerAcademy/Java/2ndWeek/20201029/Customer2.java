class Person2{
	private String name;
	private String address;
	private String phone;
	public Person2(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public String toString(){
		return name+" "+address+" "+phone;
	}
	
}
class Customer2 extends Person2{
	private int id;
	private int mileage;
	public Customer2(int id, int mileage,String name, String address, String phone){
		super(name, address, phone);
		this.id = id;
		this.mileage = mileage;
	}
	public String toString(){
		return super.toString()+" "+id+" "+mileage;
	}
	public static void main(String args[]){
		Customer2 c = new Customer2(123,1000,"홍길동","부산시","010-2222-2222");
		System.out.println(c);
	}
}