package mainTHREADEXECUTORS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import threadexecutors.ExecutableTask;
import threadexecutors.FactorialCalculator;
import threadexecutors.RejectedTaskController;
import threadexecutors.ReportProcessor;
import threadexecutors.ReportRequest;
import threadexecutors.Result;
import threadexecutors.ResultTask;
import threadexecutors.Server;
import threadexecutors.Task;
import threadexecutors.TaskAllResults;
import threadexecutors.TaskCancel;
import threadexecutors.TaskPeriod;
import threadexecutors.TaskReject;
import threadexecutors.TaskValidator;
import threadexecutors.UserValidator;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Creating a thread executor
		 */
//		Server server = new Server();
//		for (int i = 0; i < 100; i++) {
//			Task task = new Task("Task " + i);
//			server.executeTask(task);
//		}
//		server.endServer();
		
		/*
		 * Executing tasks in an executor that returns a result
		 */
//		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//		List<Future<Integer>> resultList = new ArrayList<>();
//		Random random = new Random();
//		for (int i = 0; i < 10; i++) {
//			Integer number = random.nextInt(10);
//			FactorialCalculator calculator = new FactorialCalculator(number);
//			Future<Integer> result = executor.submit(calculator);
//			resultList.add(result);
//		}
//		do {
//			System.out.printf("Main: Number of Completed Tasks:	%d\n", executor.getCompletedTaskCount());
//			for (int i = 0; i < resultList.size(); i++) {
//				Future<Integer> result = resultList.get(i);
//				System.out.printf("Main: Task %d: %s\n", i, result.isDone());
//			}
//			try {
//				TimeUnit.MILLISECONDS.sleep(50);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		} while (executor.getCompletedTaskCount() < resultList.size());
//		System.out.printf("Main: Results\n");
//		for (int i = 0; i < resultList.size(); i++) {
//			Future<Integer> result = resultList.get(i);
//			Integer number = null;
//			try {
//				number = result.get();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			}
//			System.out.printf("Main: Task %d: %d\n", i, number);
//		}
//		executor.shutdown();
		
		/*
		 * Running multiple tasks and processing the first result
		 */
//		String username = "test";
//		String password = "test";
//		UserValidator ldapValidator = new UserValidator("LDAP");
//		UserValidator dbValidator = new UserValidator("DataBase");
//		TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
//		TaskValidator dbTask = new TaskValidator(dbValidator, username, password);
//		List<TaskValidator> taskList = new ArrayList<>();
//		taskList.add(ldapTask);
//		taskList.add(dbTask);
//		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
//		String result;
//		try {
//			result = executor.invokeAny(taskList);
//			System.out.printf("Main: Result: %s\n", result);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//		executor.shutdown();
//		System.out.printf("Main: End of the Execution\n");
		
		/*
		 * Running multiple tasks and processing all the results
		 */
//		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
//		List<TaskAllResults> taskList = new ArrayList<>();
//		for (int i = 0; i < 3; i++) {
//			TaskAllResults task = new TaskAllResults("" + i);
//			taskList.add(task);
//		}
//		List<Future<Result>> resultList = null;
//		try {
//			resultList = executor.invokeAll(taskList);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			executor.shutdown();
//		}
//		System.out.println("Main: Printing the results");
//		for (int i = 0; i < resultList.size(); i++) {
//			Future<Result> future = resultList.get(i);
//			try {
//				Result result = future.get();
//				System.out.println(result.getName() + ": " + result.getValue());
//			} catch (InterruptedException | ExecutionException e) {
//				e.printStackTrace();
//			}
//		}
		
		/*
		 * Running a task in an executor after a delay
		 */
//		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
//		System.out.printf("Main: Starting at: %s\n", new Date());
//		for (int i = 0; i < 5; i++) {
//			Task task = new Task("Task " + i);
//			executor.schedule(task, i + 1 , TimeUnit.SECONDS);
//		}
//		executor.shutdown();
//		try {
//			executor.awaitTermination(1, TimeUnit.DAYS);
//		} catch (InterruptedException e) {
//				e.printStackTrace();
//		}
//		System.out.printf("Main: Ends at: %s\n", new Date());
		
		/*
		 * Running a task in an executor periodically
		 */
//		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//		System.out.printf("Main: Starting at: %s\n", new Date());
//		TaskPeriod task = new TaskPeriod("Task");
//		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
//		for (int i = 0; i < 10; i++) {
//			System.out.printf("Main: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
//			try {
//				TimeUnit.MILLISECONDS.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		executor.shutdown();
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.printf("Main: Finished at: %s\n", new Date());
		
		/*
		 * Canceling a task in an executor
		 */
//		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//		TaskCancel task = new TaskCancel();
//		System.out.printf("Main: Executing the Task\n");
//		Future<String> result = executor.submit(task);
//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.printf("Main: Canceling the Task\n");
//		result.cancel(true);
//		System.out.printf("Main: Canceled: %s\n", result.isCancelled());
//		System.out.printf("Main: Done: %s\n", result.isDone());
//		executor.shutdown();
//		System.out.printf("Main: The executor has finished\n");
		
		/*
		 * Controlling a task finishing in an executor
		 */
//		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
//		ResultTask resultTasks[] = new ResultTask[5];
//		for (int i = 0; i < 5; i++) {
//			ExecutableTask executableTask = new ExecutableTask("Task " + i);
//			resultTasks[i] = new ResultTask(executableTask);
//			executor.submit(resultTasks[i]);
//		}
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		for (int i = 0; i < resultTasks.length; i++) {
//			resultTasks[i].cancel(true);
//		}
//		for (int i = 0; i < resultTasks.length; i++) {
//			try {
//				if (!resultTasks[i].isCancelled()) {
//					System.out.printf("%s\n", resultTasks[i].get());
//				}
//			} catch (InterruptedException | ExecutionException e) {
//				e.printStackTrace();
//			}
//		}
//		executor.shutdown();
		
		/*
		 * Separating the launching of tasks and the processing of their results in an executor
		 */
//		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
//		CompletionService<String> service = new ExecutorCompletionService<>(executor);
//		ReportRequest faceRequest = new ReportRequest("Face", service);
//		ReportRequest onlineRequest = new ReportRequest("Online", service);
//		Thread faceThread = new Thread(faceRequest);
//		Thread onlineThread = new Thread(onlineRequest);
//		ReportProcessor processor = new ReportProcessor(service);
//		Thread senderThread = new Thread(processor);
//		System.out.printf("Main: Starting the Threads\n");
//		faceThread.start();
//		onlineThread.start();
//		senderThread.start();
//		try {
//			System.out.printf("Main: Waiting for the report	generators.\n");
//			faceThread.join();
//			onlineThread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.printf("Main: Shutting down the executor.\n");
//		executor.shutdown();
//		try {
//			executor.awaitTermination(1, TimeUnit.DAYS);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		processor.setEnd(true);
//		System.out.println("Main: Ends");
		
		/*
		 * Controlling rejected tasks of an executor
		 */
		RejectedTaskController controller = new RejectedTaskController();
//		RejectedExecutionHandler controller = (r, executor) -> {
//			System.out.printf("RejectedTaskController: The task %s has been rejected\n", r.toString());
//			System.out.printf("RejectedTaskController: %s\n", executor.toString());
//			System.out.printf("RejectedTaskController: Terminating:	%s\n", executor.isTerminating());
//			System.out.printf("RejectedTaksController: Terminated: %s\n", executor.isTerminated());
//		};
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor.setRejectedExecutionHandler(controller);
		System.out.printf("Main: Starting.\n");
		for (int i = 0; i < 3; i++) {
			TaskReject task = new TaskReject("Task" + i);
			executor.submit(task);
		}
		System.out.printf("Main: Shutting down the Executor.\n");
		executor.shutdown();
		System.out.printf("Main: Sending another Task.\n");
		TaskReject task = new TaskReject("RejectedTask");
		executor.submit(task);
//		System.out.println("Main: End");
		System.out.printf("Main: End.\n");
		
	}
}
