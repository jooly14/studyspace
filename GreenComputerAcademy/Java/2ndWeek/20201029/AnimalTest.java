class Dog extends Animal{
	public void sound(){
		System.out.println("월월!");
	}
}
class Frog extends Animal{
	public void sound(){
		System.out.println("개굴개굴");
	}
}
class Cat extends Animal{
	public void sound(){
		System.out.println("야옹~~");
	}
}
class Animal{
	public void sound(){
		System.out.println("동물소리");
	}
}
public class AnimalTest{
	public void makeSound(Animal ani){
		ani.sound();
	}
	public static void main(String args[]){
		Cat c = new Cat();
		Dog d = new Dog();
		Frog f =new Frog();
		AnimalTest at = new AnimalTest();
		at.makeSound(c);
		at.makeSound(d);
		at.makeSound(f);
		
	}
}