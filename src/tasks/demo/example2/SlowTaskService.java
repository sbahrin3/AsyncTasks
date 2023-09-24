package tasks.demo.example2;

import java.util.List;
import java.util.Random;

import tasks.util.Util;

public class SlowTaskService {
	
	
	public static void doSomething(List<DemoObject> demoObjects) {
		System.out.println("SlowTaskService is RUNNING: " + demoObjects.get(0) + "-" + demoObjects.get(demoObjects.size()-1));
		
		Random random = new Random();
		demoObjects.stream().forEach(d -> {
			Util.sleep(30);
			d.statusB = random.nextInt(5) + 1;
		});
		
		System.out.println("SlowTaskService has COMPLETED: " + demoObjects.get(0) + "-" + demoObjects.get(demoObjects.size()-1));
	}

}
