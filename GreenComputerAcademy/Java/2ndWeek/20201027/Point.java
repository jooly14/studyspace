class Point{
	private int x;
	private int y;
	public void set(int x , int y ){
		this.x = x;
		this.y = y;
	}
	void print(){
		System.out.println("점의 좌표 : ("+x+","+y+")");
	}
	public static void main(String args[]){
		Point p = new Point();
		p.set(12,15);
		p.print();
	}
}