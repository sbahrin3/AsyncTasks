package tasks.demo.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DemoObjectRecords {	
	
	public static List<DemoObject> getDemoObjects() {
		return getDemoObjects(5000);
	}
	
	public static List<DemoObject> getDemoObjects(int howMany) {
		
		List<DemoObject> demoObjects = new ArrayList<DemoObject>();
		IntStream.range(0, howMany).forEach(i -> {
			demoObjects.add(new DemoObject(i));
		});
		return demoObjects;
	}



}
