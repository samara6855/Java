public class Main {
	public static void main(String[] args) {
		puppy pup=new puppy();
		pup.name="Leo";
		pup.breed="Husky";
		pup.Run();
		pup.Bark();
		pup.Hungry();
	}
}
class Animal{
	String name;
	public void Hungry(){
		System.out.println("Hungry :(");
	}
}
class Dog extends Animal{
	String breed;
	public void Bark(){
		System.out.println("Bow! Bow!");
	}
}
class puppy extends Dog{
	public void Run(){
		System.out.println("puppy is running!!!!!");
	}
}
