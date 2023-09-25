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
public class DivideAndRunTask {
	
	List<?> elements;
	DividedTask task;
	
	public DivideAndRunTask(List<?> elements, DividedTask r) {
		this.elements = elements;
		this.task = r;
	}
	
	public void execute() {
		
		int numOfThreads = 5;
		int size = elements.size();
		int divSize = size / numOfThreads;
				
		int start = 0, limit = 0;
		List<List<?>> listOfList = new ArrayList<>();
		for ( int i=0; i < numOfThreads; i++ ) {
			start = limit;
			limit = divSize * (i + 1);
			listOfList.add(elements.subList(start, limit));
		}
		if ( limit < size ) {
			listOfList.add(elements.subList(limit, size));
		}
		
		int listSize = listOfList.size();
		
		ExecutorService executorService = Executors.newFixedThreadPool(listSize);
		CompletableFuture<?>[] cfarr = new CompletableFuture<?>[listSize];		
		
		for ( int i=0; i < listOfList.size(); i++ ) {
			List<?> sublist = listOfList.get(i);
			cfarr[i] = CompletableFuture.runAsync(() -> {
				task.run(sublist);
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
	
	
	List<DividedTask> allTasks;
	List<List<?>> allElements;
	
	public DivideAndRunTask() {
		allTasks = new ArrayList<>();
		allElements = new ArrayList<>();
	}
	
	public void addTask(List<?> elements, DividedTask task) {
		allTasks.add(task);
		allElements.add(elements);
	}
	
	public void executeAll() {
		
		List<List<?>> allSublist = new ArrayList<>();
		
		for ( int k=0; k < allElements.size(); k++ ) {
		
			List<?> elements = allElements.get(k);
			DividedTask task = allTasks.get(k);
			
			int numOfThreads = 5;
			int size = elements.size();
			int divSize = size / numOfThreads;
					
			int start = 0, limit = 0;
			List<List<?>> listOfList = new ArrayList<>();
			for ( int i=0; i < numOfThreads; i++ ) {
				start = limit;
				limit = divSize * (i + 1);
				listOfList.add(elements.subList(start, limit));
			}
			if ( limit < size ) {
				listOfList.add(elements.subList(limit, size));
			}
						
			for ( int i=0; i < listOfList.size(); i++ ) {
				List<?> sublist = listOfList.get(i);
				allSublist.add(sublist);
				allTasks.add(task);
			}
			
			
		}
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(allSublist.size());
		CompletableFuture<?>[] cfarr = new CompletableFuture<?>[allSublist.size()];	
		
		for ( int i=0; i < allSublist.size(); i++ ) {
			List<?> sublist = allSublist.get(i);
			DividedTask task = allTasks.get(i);
			cfarr[i] = CompletableFuture.runAsync(() -> {
				task.run(sublist);
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
