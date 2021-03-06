package mainFORKJOINFRAMEWORK;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import forkjoinframework.Document;
import forkjoinframework.DocumentTask;
import forkjoinframework.Product;
import forkjoinframework.ProductListGenerator;
import forkjoinframework.Task;

public class Main {

	public static void main(String[] args) {

		/*
		 * Creating a Fork/Join pool
		 */
//		ProductListGenerator generator = new ProductListGenerator();
//		List<Product> products = generator.generate(10000);
//		Task task = new Task(products, 0, products.size(), 0.20);
//		ForkJoinPool pool = new ForkJoinPool();
//		pool.execute(task);
//		do {
//			System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
//			System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
//			System.out.printf("Main: Parallelism: %d\n" ,pool.getParallelism());
//			try {
//				TimeUnit.MILLISECONDS.sleep(5);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		} while (!task.isDone());
//		pool.shutdown();
//		if (task.isCompletedNormally()) {
//			System.out.printf("Main: The process has completed normally.\n");
//		}
//		for (int i = 0; i < products.size(); i++) {
//			Product product = products.get(i);
//			if (product.getPrice() != 12) {
//				System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
//			}
//		}
//		System.out.println("Main: End of the program.\n");
		
		/*
		 * Joining the results of the tasks
		 */
		Document mock = new Document();
		String[][] document = mock.generateDocument(100, 1000, "the");
		DocumentTask task = new DocumentTask(document, 0, 100, "the");
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			System.out.printf("******************************************\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.printf("Main: The word appears %d in the	document", task.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
