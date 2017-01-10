package threadsynchronizationutilities;

public class JobGroup implements Runnable {
	
	private PrintQueueGroup printQueue;
	
	public JobGroup(PrintQueueGroup printQueue){
		this.printQueue = printQueue;
	}
	
	@Override
	public void run() {
		System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
	}

}
