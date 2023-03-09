import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> namesMap=new HashMap();
		namesMap.put(5,"Simha");
		namesMap.put(25,"Values");
		namesMap.put(12,"Super");
		namesMap.put(15,"Enjoy");
		String name=namesMap.get(5);
		System.out.println(name);
		for(Map.Entry<Integer, String> entry: namesMap.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}
