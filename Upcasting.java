public class Main {
	public static void main(String[] args) {
		Animal animal1=new Animal();
		animal1.run();
		Animal animal2=new Dog();   // --UPCASTING
		animal2.run();
		//Dog dog=new Animal(); --NOT ALLOWED
		//Dog dog=(Dog) new Animal(); --DOWNCASTING
	}
}
class Animal{
	public void run(){
		System.out.println("Animal is running!!!!!");
	}
}
class Dog extends Animal{
	public void run(){
		System.out.println("Dog is running!!!!!");
	}
}
