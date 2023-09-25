package tasks.demo.example1;

import java.util.List;
import java.util.Random;

import tasks.util.Util;

public class BService {
	
	public static void doSomething(List<DemoObject> students) {
		System.out.println("Service B is RUNNING");
		
		Random random = new Random();
		students.stream().forEach(d -> {
			Util.sleep(30);
			d.statusB = random.nextInt(5) + 1;
		});
		
		System.out.println("Service B has COMPLETED");
	}

}
