import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> names = new ArrayList();
		names.add("A");   // index:0
		names.add("B");  // 1
		names.add("C");  // 2
		names.add("D");  // 3
		names.add("E");  // 4
		System.out.println(names.get(1));
		System.out.println(names.get(2));
		for(String name: names){
			System.out.println(name);
		}
		Car c1=new Car("Ferrari");
		Car c2=new Car("Bugatti");
		Car c3=new Car("Ford");
		Car c4=new Car("Bentley");
		List<Car> carsList=new ArrayList();
		carsList.add(c1);
		carsList.add(c2);
		carsList.add(c3);
		carsList.add(c4);
		for(Car car: carsList){
			System.out.println(car);
		}

	}
}
class Car{
	String brand;
	public Car(String brand){
		this.brand=brand;
	}
}
