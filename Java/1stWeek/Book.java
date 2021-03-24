//도서입력
public class Book{
	String title;
	int price;
	boolean stock;
	double score;
	
	void insertTitle(String title){
		this.title = title;
	}
	void insertPrice(int price){
		this.price = price;
	}
	void insertStock(boolean stock){
		this.stock = stock;
	}
	void insertScore(double score){
		this.score = score;
	}
	
	void showData(){
		System.out.println(title +", "+price +"원, " +(stock?"재고있음":"재고없음")+", 평점 "+score);
	}
	
	public static void main(String args[]){
		Book b = new Book();
		b.insertTitle("오만과 편견");
		b.insertPrice(12000);
		b.insertStock(true); //현재 재고가 있는가?
		b.insertScore(9.5);
		b.showData(); //오만과 편견, 12000원, 재고있음, 평점 9.5
	}
}