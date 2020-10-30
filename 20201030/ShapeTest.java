abstract class Shape implements Drawable{
	protected int x,y;
	public void draw(){
		System.out.println("Shape Draw");
	}
}
class Rectangle extends Shape{
	private int x;
	private int y;
	private int width, height;
	public void draw(){
		System.out.println("Rectangle Draw");
	}
	@Override
	public void move(int dx, int dy){
		System.out.println("Rectangle이 ("+dx+","+dy+")만큼 이동했습니다.");
		x = x + dx;
		y = y+ dy;
		System.out.println("Rectangle의 현재 위치는 ("+x+","+y+")입니다.");

	}
	@Override
	public void Draw(){
		System.out.println("("+x+","+y+")에 width는 "+width+", height는 "+height+"로 Rectangle을 그립니다.");
	}
}
class Triangle extends Shape{
	private int x;
	private int y;
	private int base, height;
	public void draw(){
		System.out.println("Triangle Draw");
	}
	@Override
	public void move(int dx, int dy){
		System.out.println("Triangle이 ("+dx+","+dy+")만큼 이동했습니다.");
		x = x + dx;
		y = y+ dy;
		System.out.println("Triangle의 현재 위치는 ("+x+","+y+")입니다.");

	}
	@Override
	public void Draw(){
		System.out.println("("+x+","+y+")에 base는 "+base+", height는 "+height+"로 Triangle을 그립니다.");
	}
}
class Circle extends Shape{
	private int x;
	private int y;
	private int radius;
	public void draw(){
		System.out.println("Circle Draw");
	}
	@Override
	public void move(int dx, int dy){
		System.out.println("Circle이 ("+dx+","+dy+")만큼 이동했습니다.");
		x = x + dx;
		y = y+ dy;
		System.out.println("Circle의 현재 위치는 ("+x+","+y+")입니다.");

	}
	@Override
	public void Draw(){
		System.out.println("("+x+","+y+")에 radius는 "+radius+"로 Circle을 그립니다.");
	}
}
public class ShapeTest{
	private static Shape arrayOfShape[];
	public static void main(String args[]){
		init();
		drawAll();
		/*
		Movable[] arrayOfMovable = new Movable[3];
		arrayOfMovable[0] = new Rectangle();
		arrayOfMovable[1] = new Triangle();
		arrayOfMovable[2] = new Circle();
		
		arrayOfMovable[index].move(10,5);
		*/
		Drawable[] arrayOfDrawable = new Drawable[3];
		arrayOfDrawable[0] = new Rectangle();
		arrayOfDrawable[1] = new Triangle();
		arrayOfDrawable[2] = new Circle();
		for(int i =0;i<30;i++){
			int index = (int)(Math.random()*3);
			arrayOfDrawable[index].move(5,5);
			arrayOfDrawable[index].Draw();			
		}
	}
	public static void init(){
		arrayOfShape = new Shape[3];
		arrayOfShape[0] = new Rectangle();
		arrayOfShape[1] = new Triangle();
		arrayOfShape[2] = new Circle();
	}
	public static void drawAll(){
		for(Shape s:arrayOfShape){
			s.draw();		//동적 바인딩
		}
	}
}