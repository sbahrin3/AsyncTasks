package tasks.demo.example1;

import java.util.List;
import java.util.Random;

import tasks.util.Util;

public class AService {
	
	public static void doTask(List<DemoObject> students) {
		System.out.println("Service A is RUNNING");

		Random random = new Random();
		students.stream().forEach(d -> {
			Util.sleep(10);
			d.statusA = random.nextInt(5) + 1;
		});
		
		System.out.println("Service A has COMPLETED");
	}

}
