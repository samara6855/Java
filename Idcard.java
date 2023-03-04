import java.util.Scanner;
public class Idcard{
	public static void main(String[] args){
		String name;
		int age;
		String bloodGroup;
		String groupName;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		name = scanner.nextLine();
		System.out.println("Enter you age: ");
		age = scanner.nextInt();
		System.out.println("Enter your blood group: ");
		bloodGroup = scanner.next();
		scanner.close();
		if (age>=20) {
			groupName="RED";
		} else if (age>=15){
			groupName="BLUE";
		} else {
			groupName="YELLOW";
		}
		System.out.println("---------------------------");
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Blood Group:"+bloodGroup);
		System.out.println("---------------------------");
		System.out.println("Your group is "+groupName);
		System.out.println("---------------------------");

	}
}

