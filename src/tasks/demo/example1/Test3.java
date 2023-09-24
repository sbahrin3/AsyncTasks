package tasks.demo.example1;

import java.util.List;

import tasks.util.AsyncTasks;

public class Test3 {
	
	public static void main(String... args) {
		
		long startTime = System.currentTimeMillis();
		
		List<DemoObject> demoObjects = DemoObjectRecords.getDemoObjects();
		
		AsyncTasks asyncTasks = new AsyncTasks();
		
		asyncTasks.addTask( () -> { AService.doTask(demoObjects); } );
		
		asyncTasks.addTask( () -> { BService.doSomething(demoObjects); } );
		
		asyncTasks.addTask( () -> { CService.doOtherThings(demoObjects); } );
		
		asyncTasks.execute();
		
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		
		System.out.println("Execution time: " + executionTime + " milliseconds");
		
		
	}

}
