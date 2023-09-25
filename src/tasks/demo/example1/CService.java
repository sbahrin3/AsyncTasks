package tasks.demo.example1;

import java.util.List;
import java.util.Random;

import tasks.util.Util;

public class CService {
	
	public static void doOtherThings(List<DemoObject> demoObjects) {
		System.out.println("Service C is RUNNING");
		
		Random random = new Random();
		demoObjects.stream().forEach(d -> {
			Util.sleep(30);
			d.statusB = random.nextInt(5) + 1;
		});
		
		System.out.println("Service C has COMPLETED");
	}


}
