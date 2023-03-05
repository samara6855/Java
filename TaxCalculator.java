import java.util.Scanner;
import java.lang.String;

public class Main {
	public static void main(String[] args){
		System.out.println("Tax Calculator App");
		System.out.println("-----WELCOME-----");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter total person count:");
		int count = sc.nextInt();
		int[] aCount=new int[count];
		String[] names= new String[aCount.length];
		long[] incomes=new long[aCount.length];
		for(int i=0;i<aCount.length;i++){
			System.out.println("Enter name : ");
			names[i]=sc.next();
			System.out.println("Enter your Annual income: ");
			incomes[i]=sc.nextLong();
		}
		System.out.println("Names with liable taxes");
		System.out.println("-----------------------");
		for(int i=0;i<aCount.length;i++){
			calculateTax(names[i],incomes[i]);
		}
	}
	public static void calculateTax(String name,long income){
		double taxamount;
		if(income>=300000){
			taxamount=(0.20*income);
		} else if (income>=100000 && income<300000) {
			taxamount = (0.10 * income);
		} else {
			taxamount = 0;
		}
		System.out.println(name+" : ₹ "+taxamount);

	}
}
