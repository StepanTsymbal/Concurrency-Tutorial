package mainTHREADSYNCHRONIZATIONUTILITIES;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;

import threadsynchronizationutilities.Consumer;
import threadsynchronizationutilities.Grouper;
import threadsynchronizationutilities.Job;
import threadsynchronizationutilities.JobGroup;
import threadsynchronizationutilities.MatrixMock;
import threadsynchronizationutilities.MyPhaser;
import threadsynchronizationutilities.Participant;
import threadsynchronizationutilities.PrintQueue;
import threadsynchronizationutilities.PrintQueueGroup;
import threadsynchronizationutilities.Producer;
import threadsynchronizationutilities.Results;
import threadsynchronizationutilities.Searcher;
import threadsynchronizationutilities.Student;
import threadsynchronizationutilities.Videoconference;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Controlling concurrent access to a resource
		 */
//		PrintQueue printQueue = new PrintQueue();
//		Thread thread[] = new Thread[10];
//		for (int i = 0; i < 10; i++) {
//			thread[i] = new Thread(new Job(printQueue), "Thread" + i);
//		}
//		for (int i = 0; i < 10; i++) {
//			thread[i].start();
//		}
		
		/*
		 * Controlling concurrent access to multiple copies of a resource
		 */
//		PrintQueueGroup printQueue = new PrintQueueGroup();
//		Thread thread[] = new Thread[10];
//		for (int i = 0; i < 10; i++) {
//			thread[i] = new Thread(new JobGroup(printQueue), "Thread" + i);
//		}
//		for (int i = 0; i < 10; i++) {
//			thread[i].start();
//		}
		
		/*
		 * Waiting for multiple concurrent events
		 */
//		Videoconference conference = new Videoconference(10);	
//		Thread threadConference = new Thread(conference);
//		threadConference.start();
//		for (int i = 0; i < 10; i++) {
//			Participant p = new Participant(conference, "Participant " + i);
//			Thread t = new Thread(p);
//			t.start();
//		}
		
		/*
		 * Synchronizing tasks in a common point
		 */
//		final int ROWS = 10000;
//		final int NUMBERS = 1000;
//		final int SEARCH = 5;
//		final int PARTICIPANTS = 5;
//		final int LINES_PARTICIPANT = 2000;
//		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
//		Results results = new Results(ROWS);
//		Grouper grouper = new Grouper(results);
//		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
//		Searcher searchers[] = new Searcher[PARTICIPANTS];
//		for (int i = 0; i < PARTICIPANTS; i++){
//		searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT,
//					mock, results, 5, barrier);
//		Thread thread = new Thread(searchers[i]);
//		thread.start();
//		}
//		System.out.printf("Main: The main thread has finished.\n");
		
		/*
		 * Controlling phase change in concurrent phased tasks
		 */
//		MyPhaser phaser = new MyPhaser();
//		Student students[] = new Student[5];
//		for (int i = 0; i < students.length; i++) {
//			students[i] = new Student(phaser);
//			phaser.register();
//		}
//		Thread threads[] = new Thread[students.length];
//		for (int i = 0; i < students.length; i++) {
//			threads[i] = new Thread(students[i], "Student " + i);
//			threads[i].start();
//		}
//		for (int i = 0; i < threads.length; i++) {
//			try {
//				threads[i].join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.printf("Main: The phaser has finished: %s.\n", phaser.isTerminated());

		/*
		 * Changing data between concurrent tasks
		 */
		List<String> buffer1 = new ArrayList<>();
		List<String> buffer2 = new ArrayList<>();
		Exchanger<List<String>> exchanger = new Exchanger<>();
		Producer producer = new Producer(buffer1, exchanger);
		Consumer consumer = new Consumer(buffer2, exchanger);
		Thread threadProducer = new Thread(producer);
		Thread threadConsumer = new Thread(consumer);
		threadProducer.start();
		threadConsumer.start();
		
	}

}
