public class Main {

	public static void main(String[] args) {
		Cake c = new Cake(); // Reference variable
		c.cakeName = "Black Forest";    
		c.price = 55.0f;                
		c.favCake();
	}

	public static class Cake {
		String cakeName; // instance variable
		float price; //instance variable
		String flavour; //instance variable
		boolean isAvailable; //instance variable

		public String favCake() {
      			int layers=4; //local variable
			System.out.println("My favourite cake is : " + cakeName + " with " + layers +" layers.");
			return null;
		}

	}
}
