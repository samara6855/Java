import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter first number: ");
		int x=sc.nextInt();
		System.out.println("Enter second number: ");
		int y=sc.nextInt();
		int c = Sum(x,y); // Sum
		System.out.println("The sum of give two integers is: "+c);
	}
	public static int Sum(int a,int b){
		int c=a+b;
		return c;
	}
}
