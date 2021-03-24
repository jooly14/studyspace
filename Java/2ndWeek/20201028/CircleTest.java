class Point{
	int x;
	int y;
	public Point(int x , int y){
		this.x = x;
		this.y = y;
	}
}
class Circle{
	int radius;
	Point center;
	
	public Circle(int radius, Point p){
		this.radius = radius;
		center = p;
	}
}
public class CircleTest{
	public static void main(String args[]){
		Point p = new Point(25, 78);
		Circle c = new Circle(10,p);
		System.out.println(c.center.x +" "+c.center.y +" "+c.radius);
	}
}