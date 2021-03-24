public class Order{
	int orderNum;
	String id;
	String name;
	String productName;
	String address;
	
	Order(int orderNum, String id, String address){
		this.orderNum = orderNum;
		this.id = id;
		this.name = "무기명";
		this.productName = "표시안함";
		this.address = address;
	}
	Order(int orderNum, String id,String name, String address){
		this.orderNum = orderNum;
		this.id = id;
		this.name = name;
		this.productName = "표시안함";
		this.address = address;
	}
	Order(int orderNum, String id, String productName, String address){
		this.orderNum = orderNum;
		this.id = id;
		this.name = "무기명";
		this.productName = productName;
		this.address = address;
	}

	Order(int orderNum, String id, String name, String productName, String address){
		this.orderNum = orderNum;
		this.id = id;
		this.name = name;
		this.productName = productName;
		this.address = address;
	}
}
/*
Order 클래스
변수
주문번호, 아이디, 이름, 제품명, 주소
이름과 제품명은 없을 시 "무기명", "표시안함"
나머지는 무조건 입력받기
*/