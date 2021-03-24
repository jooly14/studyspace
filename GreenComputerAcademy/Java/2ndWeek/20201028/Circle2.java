public class Circle2{
	private double radius;
	static final double PI = 3.141592;
	Circle2(double radius){
		this.radius = radius;
	}
	public void setRadius(double radius){
		this.radius = radius;
	}
	public double getRadius(){
		return radius;
	}
	private double square(double d){
		return d*d;
	}
	public double getArea(){
		return PI*square(radius);
	}
	public double getPerimeter(){
		return 2*PI*radius;
	}
	public static double getPI(){
		return PI;
	}
	public static void main(String args[]){
		Circle2 c = new Circle2(10.0);
		System.out.println(c.getPI());
		System.out.println(c.getArea());
		System.out.println(c.getPerimeter());
		
	}
}