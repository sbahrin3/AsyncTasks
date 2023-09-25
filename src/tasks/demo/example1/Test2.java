package tasks.demo.example1;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {

	public static void main(String... args) {

		long startTime = System.currentTimeMillis();
		List<DemoObject> demoObjects = DemoObjectRecords.getDemoObjects();

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
			AService.doTask(demoObjects);
		}, executorService);

		CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
			BService.doSomething(demoObjects);
		}, executorService);
		
		CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> {
			CService.doOtherThings(demoObjects);
		}, executorService);

		CompletableFuture<Void> allOf = CompletableFuture.allOf(task1, task2, task3);

		try {
			allOf.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		executorService.shutdown();

		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " milliseconds");

		//demoObjects.forEach(System.out::println);
	}

}
