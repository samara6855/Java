public class Main {
	public static void main(String[] args) {
		Dog dog=new Dog();
		dog.name="Goldy";
		dog.breed="Golden Retriever";
		dog.bark();
		dog.run();

		Cat cat=new Cat();
		cat.name="Kitty";
		cat.pattern="Persian cat";
		cat.meow();
		cat.run();
	}
}
class Animal{
	String name;
	public void run(){
		System.out.println("The Animal is running!!!!!!");
	}
}
class Dog extends Animal{
	String breed;
	public void bark(){
		System.out.println("Bow! Bow!");
	}
}
class Cat extends Animal{
	String pattern;
	public void meow(){
		System.out.println("Meow! Meow!");
	}
}
