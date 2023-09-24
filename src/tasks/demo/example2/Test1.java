package tasks.demo.example2;

import java.util.List;

import tasks.util.DivideAndRunTask;

public class Test1 {
	
	
	public static void main(String... args) {
		
		long startTime = System.currentTimeMillis();
		
		List<DemoObject> demoObjects = DemoObjectRecords.getDemoObjects(559);
		
		SlowTaskService.doSomething(demoObjects);
		
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime; 
		System.out.println("Execution time: " + executionTime + " milliseconds");
		
		
	}

}
