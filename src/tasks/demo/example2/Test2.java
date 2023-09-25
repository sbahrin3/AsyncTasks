package tasks.demo.example2;

import java.util.List;

import tasks.util.DivideAndRunTask;

public class Test2 {
	
	public static void main(String... args) {
		
		long startTime = System.currentTimeMillis();
		
		List<DemoObject> demoObjects = DemoObjectRecords.getDemoObjects(559);
		
		DivideAndRunTask drt = new DivideAndRunTask(demoObjects, s -> SlowTaskService.doSomething(s) );
		
		drt.execute();
		
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime; 
		System.out.println("Execution time: " + executionTime + " milliseconds");
		
		
	}

}
