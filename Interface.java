public class Main {
	public static void main(String[] args) {
		Animal animal=new Dog(); //UPCASTING
		animal.eat();
		animal.run();
	}
}
interface Animal{
	abstract public void run();
	abstract public void eat();
}
class Dog implements Animal{
	@Override
	public void run() {
		System.out.println("Dog is running!!");
	}

	@Override
	public void eat(){
		System.out.println("I'm eating!!");
	}
}
