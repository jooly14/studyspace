public class Order2{
	String id;
	String name;
	String pName;
	int price;
	
	Order2(People p,Product pro){
		id = p.id;
		name = p.name;
		pName = pro.productName;
		price = pro.price;
	}
	void print(){
		System.out.println(id +" "+name+" "+pName+" "+price);
		
	}
	
	public static void main(String args[]){
		Product milk = new Product("우유",1200);
		Product ramen = new Product("라면",800);
		People cus1 = new People("aaa","최홍석",true,"대연동",20);
		Order2 o = new Order2(cus1, milk);
		o.print();
		Order2 o2 = new Order2(cus1, ramen);
		o2.print();
		// 아이디 aaa인 최홍석이 우유 1200짜리를 샀다.
	}
}