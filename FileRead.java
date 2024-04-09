import java.io.FileInputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("file1.txt");
			int i=0;
			while((i=fis.read())!= -1){
				System.out.print((char) i);
			}
			fis.close();
		} catch (IOException e){
			System.out.println("There is an error!!!!!");
		}
	}

}
