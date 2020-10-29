class Circle{
	private double radius;
	private String color;
	public Circle(){}
	public Circle(double radius){
		this.radius = radius;
	}
	public double getRadius(){
		return radius;
	}
	public double getArea(){
		return Math.PI*radius*radius; 
	}
	
	
}
class Cylinder extends Circle{
	private double height;
	public Cylinder(){}
	public Cylinder(double radius){
		super(radius);
	}
	public Cylinder(double radius,double height){
		super(radius);
		this.height = height;
	}
	public double getHeight(){
		return height;
	}
	public double getVolume(){
		return height*getArea();
	}
}
public class TestCylinder{
	public static void main(String args[]){
		Cylinder obj1 = new Cylinder();
		System.out.println(obj1.getHeight());
		System.out.println(obj1.getRadius());
		
		Cylinder obj2 = new Cylinder(5.0,3.0);
		System.out.println(obj2.getHeight());
		System.out.println(obj2.getRadius());
		System.out.println(obj2.getArea());
		System.out.println(obj2.getVolume());
		
	}
}