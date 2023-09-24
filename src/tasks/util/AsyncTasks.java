package tasks.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 
 * @author shamsulbahrin
 * @since 24 Sep 2023
 */

public class AsyncTasks {
	
	List<Runnable> tasks = new ArrayList<>();
	
	public void addTask(Runnable task) {
		tasks.add(task);
	}

	
	public void execute() {
		
		ExecutorService executorService = Executors.newFixedThreadPool(tasks.size());
		
		CompletableFuture<?>[] cfarr = new CompletableFuture<?>[tasks.size()];
		
		for ( int i=0; i < tasks.size(); i++ ) {
			Runnable r = tasks.get(i);
			cfarr[i] = CompletableFuture.runAsync(() -> {
				r.run();
			}, executorService);
		}
				
		CompletableFuture<?> allOf = CompletableFuture.allOf(cfarr);
		
		try {
			allOf.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		executorService.shutdown();
		
	}

}
