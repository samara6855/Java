public class Main {
	public static void main(String[] args) {
		Rectangle r= new Rectangle();
		Rectangle r1=new Rectangle(5.6f,10.7f);
	}
}
class Rectangle{
	float length;
	float breadth;
	public Rectangle(){
		System.out.println("This is default constructor"); // default constructor
	}
	public Rectangle(float l,float b){   // parameterized constructor
		length=l;
		breadth=b;
		System.out.println("The length of the rectangle is "+length);
		System.out.println("The breadth of the rectangle is "+ breadth);

	}
}
