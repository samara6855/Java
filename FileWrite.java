import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String data="Welcome to Java";
		try {
			FileOutputStream fos = new FileOutputStream("file1.txt");
			byte[] byteData = data.getBytes();
			fos.write(byteData);
			fos.close();
		} catch (IOException e){
			System.out.println("There is an error!!!!!");
		}
	}
}
