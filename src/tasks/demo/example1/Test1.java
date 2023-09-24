package tasks.demo.example1;

import java.util.List;

public class Test1 {
	
	public static void main(String... args) {
		
		long startTime = System.currentTimeMillis();
		
		List<DemoObject> demoObjects = DemoObjectRecords.getDemoObjects();
		
		AService.doTask(demoObjects);
		
		BService.doSomething(demoObjects);
		
		CService.doOtherThings(demoObjects);

		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime; 
		System.out.println("Execution time: " + executionTime + " milliseconds");
		
		
		//demoObjects.forEach(System.out::println);
	}

}
