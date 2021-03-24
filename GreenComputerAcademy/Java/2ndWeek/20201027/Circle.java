class Circle{
	private int r;
	private int cx;
	private int cy;
	double area(){
		return (Math.PI*r*r);
	}
	public int getR(){
		return r;
	}
	public void setR(int r){
		this.r = r;
	}
	public int getCX(){
		return cx;
	}
	public void setCX(int cx){
		this.cx = cx;
	}
	public int getCY(){
		return cy;
	}
	public void setCY(int cy){
		this.cy = cy;
	}
	
	public static void main(String args[]){
		Circle c = new Circle();
		c.setR(10);
		System.out.println("원의 넓이는 " +c.area());
	}
}