package tasks.demo.example1;

import java.util.List;

import tasks.util.DivideAndRunTask;

public class Test4 {
	
	
	public static void main(String... args) {
		
		long startTime = System.currentTimeMillis();
		
		List<DemoObject> demoObjects = DemoObjectRecords.getDemoObjects();
		
		DivideAndRunTask drt = new DivideAndRunTask();
		drt.addTask(demoObjects, AService::doTask );
		drt.addTask(demoObjects, BService::doSomething );
		drt.addTask(demoObjects, CService::doOtherThings );

		drt.executeAll();
		
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		
		System.out.println("Execution time: " + executionTime + " milliseconds");
		
		
	}

}
