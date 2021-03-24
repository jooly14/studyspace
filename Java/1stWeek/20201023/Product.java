public class Product{
	String productName;
	boolean danger;
	int price;
	String producer;
	
	Product(String name,int p){
		productName = name;
		danger = false;
		price = p;
		producer = "PP";
	}
	Product(String name, boolean b ,int p){
		productName = name;
		danger = b;
		price = p;
		producer = "PP";
	}
	Product(String name,int p, String pro){
		productName = name;
		danger = false;
		price = p;
		producer = pro;
	}
	Product(String name, boolean b ,int p, String pro){
		productName = name;
		danger = b;
		price = p;
		producer = pro;
	}
}
/*
Product 클래스
변수
제품명,위험여부, 가격, 생산자
위험여부는 입력하지 않을 시 false, 
생산자 입력하지 않을 시 "PP"
*/