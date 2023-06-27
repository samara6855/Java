public class Main {
	public static void main(String[] args) {
		Animal animal=new Dog(); //UPCASTINGG
		animal.eat();
		animal.run();
	}
}
abstract class Animal{
	public void run(){
		System.out.println("Animal is running!!!!!");
	}
	abstract void eat();
}
class Dog extends Animal{
	@Override
	public void eat(){
		System.out.println("I'm eating!!");
	}
}
