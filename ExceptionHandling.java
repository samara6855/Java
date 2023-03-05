public class Main {

	public static void main(String[] args) {
		System.out.println("Program begins");
		String str = null;
		int[] array1= {1,4,5,5};
		try{
			 int div = array1[2]/ 0;
			System.out.println(div);
			String s = str.concat("Hello");
			System.out.println(s);
		} catch (NullPointerException | ArithmeticException ex){
			System.out.println(ex);
		}
		System.out.println("Program terminates");
	}
}
