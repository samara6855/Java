public class Main {
	public static void main(String[] args) {
		Employee E1= new Employee();
		E1.name="ABCDE";
		//E1.Company;  --gives error
		System.out.println(Employee.Company); //Using class name to access static methods
		Employee.Salary();

	}
}
class Employee{
	String name;
	public static final String Company="Google";
	public static void Salary(){
		System.out.println("The salary provided is : "+ 90000);
	}
}
