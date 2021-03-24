class Box{
	int width;
	int length;
	int height;
	
	public int getWidth(){
		return width;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public int getLength(){
		return length;
	}
	public void setLength(int length){
		this.length = length;
	}
	public int getHeight(){
		return height;
	}
	public void setHeight(int height){
		this.height = height;
	}
	int getVolume(){
		return width*length*height;
	}
	void print(){
		System.out.println(width +" "+length+" "+height);
	}
	
}
public class BoxTest{
	public static void main(String args[]){
		Box box1 = new Box();
		box1.setWidth(100);
		box1.setLength(100);
		box1.setHeight(100);
		System.out.println(box1.getVolume());
		Box box2 = new Box();
		box2.setWidth(200);
		box2.setLength(200);
		box2.setHeight(200);
		box1 = box2;
		box1.print();
		
	}
}