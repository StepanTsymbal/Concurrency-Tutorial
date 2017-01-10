package mainTHREADMANAGEMENT;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

import threadmanagement.CleanerTask;
import threadmanagement.DataSourcesLoader;
import threadmanagement.Event;
import threadmanagement.ExceptionHandler;
import threadmanagement.FileClock;
import threadmanagement.FileSearch;
import threadmanagement.MyThreadFactory;
import threadmanagement.MyThreadGroup;
import threadmanagement.NetworkConnectionsLoader;
import threadmanagement.Result;
import threadmanagement.SafeTask;
import threadmanagement.SearchTask;
import threadmanagement.Task;
import threadmanagement.TaskFactory;
import threadmanagement.TaskGroup;
import threadmanagement.UnsafeTask;
import threadmanagement.WriterTask;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Creating and running a thread
		 */
//		for (int i = 1; i <= 10; i++) {
//			Calculator calculator = new Calculator(i);
//			Thread thread = new Thread(calculator);
//			thread.start();
//			/*new Thread (() -> System.out.println("i")).start();*/
//		}
		
		/*
		 * Getting and setting thread information
		 */
//		Thread threads[] = new Thread[10];
//		Thread.State status[] = new Thread.State[10];
//		for (int i = 0; i < 10; i++) {
//			threads[i] = new Thread(new Calculator(i));
//			if ((i % 2) == 0) {
//				threads[i].setPriority(Thread.MAX_PRIORITY);
//			} else {
//				threads[i].setPriority(Thread.MIN_PRIORITY);
//			}
//			threads[i].setName("Thread "+i);
//		}
//		try (FileWriter file = new FileWriter("log.txt"); PrintWriter pw = new PrintWriter(file);) {
//			for (int i = 0; i < 10; i++) {
//				pw.println("Main : Status of Thread "+i+" : " +	threads[i].getState());
//				status[i] = threads[i].getState();
//			}
//			for (int i = 0; i < 10; i++) {
//				threads[i].start();
//			}
//			
//			boolean finish = false;
//			while (!finish) {
//				for (int i = 0; i < 10; i++) {
//					if (threads[i].getState() != status[i]) {
//						writeThreadInfo(pw, threads[i], status[i]);
//						status[i] = threads[i].getState();
//					}
//				}
//				finish = true;
//				for (int i = 0; i < 10; i++) {
//					finish = finish && (threads[i].getState() == State.TERMINATED);
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*
		 * Interrupting a thread
		 */
//		Thread task = new PrimeGenerator();
//		task.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		task.interrupt();
		
		/*
		 * Controlling the interruption of a thread
		 */
		FileSearch searcher = new FileSearch("D:\\","msdia80.dll");
		Thread thread = new Thread(searcher);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();	
		
		/*
		 * Sleeping and resuming a thread
		 */
//		FileClock clock = new FileClock();
//		Thread thread = new Thread(clock);
//		thread.start();
//		try {
//			TimeUnit.SECONDS.sleep(5);
//			/*Thread.sleep(5000);*/
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		thread.interrupt();
		
		/*
		 * Waiting for the finalization of a thread
		 */
//		DataSourcesLoader dsLoader = new DataSourcesLoader();
//		Thread thread1 = new Thread(dsLoader,"DataSourceThread");
//		NetworkConnectionsLoader ncLoader = new	NetworkConnectionsLoader();
//		Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");
//		thread1.start();
//		thread2.start();
//		try {
//			thread1.join();
//			thread2.join();
//			/*thread2.join(1000);*/
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.printf("Main: Configuration has been loaded:	%s\n", new Date());
		
		/*
		 * Creating and running a daemon thread
		 */
//		Deque<Event> deque = new ArrayDeque<Event>();
//		WriterTask writer = new WriterTask(deque);
//		for (int i = 0; i < 3; i++) {
//			Thread thread = new Thread(writer);
//			thread.start();
//		}
//		CleanerTask cleaner = new CleanerTask(deque);
//		cleaner.start();
		
		/*
		 * Processing uncontrolled exceptions in a thread
		 */
//		Task task = new Task();
//		Thread thread = new Thread(task);
//		thread.setUncaughtExceptionHandler(new ExceptionHandler());
//		thread.start();
		
		/*
		 * Using local thread variables
		 */
//		/*UnsafeTask task = new UnsafeTask();*/
//		SafeTask task = new SafeTask();
//		for (int i = 0; i < 10; i++) {
//				Thread thread = new Thread(task);
//				thread.start();
//			try {
//				TimeUnit.SECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		/*
		 * Grouping threads into a group
		 */
//		ThreadGroup threadGroup = new ThreadGroup("Searcher");
//		Result result = new Result();
//		SearchTask searchTask = new SearchTask(result);
//		for (int i = 0; i < 10; i++) {
//			Thread thread = new Thread(threadGroup, searchTask);
//			thread.start();
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
//		System.out.printf("Information about the Thread Group\n");
//		threadGroup.list();
//		Thread[] threads = new Thread[threadGroup.activeCount()];
//		threadGroup.enumerate(threads);
//		for (int i = 0; i < threadGroup.activeCount(); i++) {
//			System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
//		}
//		waitFinish(threadGroup);
//		threadGroup.interrupt();
		
		/*
		 * Processing uncontrolled exceptions in a group of threads
		 */
//		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
//		TaskGroup task = new TaskGroup();
//		for (int i = 0; i < 2; i++) {
//			Thread t = new Thread(threadGroup, task);
//			t.start();
//		}
		
		/*
		 * Creating threads through a factory
		 */
//		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
//		TaskFactory task = new TaskFactory();
//		/*// By means of lambda expression (in this case, TaskFactory class is excess)
//		Runnable task = () -> {
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}			
//		};
//		*/
//		Thread thread;
//		System.out.printf("Starting the Threads\n");
//		for (int i = 0; i < 10; i++){
//			thread = factory.newThread(task);
//			thread.start();
//		}
//		System.out.printf("Factory stats:\n");
//		System.out.printf("%s\n", factory.getStats());		
		
	}

//	private static void waitFinish(ThreadGroup threadGroup) {
//		while (threadGroup.activeCount() > 9) {
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

//	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
//		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
//		pw.printf("Main : Priority: %d\n", thread.getPriority());
//		pw.printf("Main : Old State: %s\n", state);
//		pw.printf("Main : New State: %s\n", thread.getState());
//		pw.printf("Main : ************************************\n");		
//	}
}
