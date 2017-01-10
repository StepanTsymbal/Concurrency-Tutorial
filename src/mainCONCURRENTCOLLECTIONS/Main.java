package mainCONCURRENTCOLLECTIONS;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import concurrentcollections.AddTask;
import concurrentcollections.Client;
import concurrentcollections.Contact;
import concurrentcollections.Event;
import concurrentcollections.EventCollection;
import concurrentcollections.PollTask;
import concurrentcollections.Task;
import concurrentcollections.TaskCollection;
import concurrentcollections.TaskMap;

public class Main {

	public static void main(String[] args) throws Exception {
		
		/*
		 * Using non-blocking thread-safe lists
		 */
//		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
//		Thread threads[] = new Thread[100];
//		for (int i = 0; i < threads.length ; i++) {
//			AddTask task = new AddTask(list);
//			threads[i] = new Thread(task);
//			threads[i].start();
//		}
//		System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);
//		for (int i = 0; i < threads.length; i++) {
//			try {
//				threads[i].join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.printf("Main: Size of the List: %d\n", list.size());
//		for (int i = 0; i < threads.length; i++) {
//			PollTask task = new PollTask(list);
//			threads[i] = new Thread(task);
//			threads[i].start();
//		}
//		System.out.printf("Main: %d PollTask threads have been launched\n", threads.length);
//		for (int i = 0; i < threads.length; i++) {
//			try {
//				threads[i].join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.printf("Main: Size of the List: %d\n", list.size());
		
		/*
		 * Using blocking thread-safe lists
		 */
//		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
//		Client client = new Client(list);
//		Thread thread = new Thread(client);
//		thread.start();
//		for (int i = 0; i < 5 ; i++) {
//			try {
//				for (int j = 0; j < 3; j++) {
//					String request = list.take();
//					System.out.printf("Main: Request: %s at %s. Size: %d\n", request, new Date(), list.size());
//				}
//				TimeUnit.MILLISECONDS.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.printf("Main: End of the program.\n");
		
		/*
		 * Using blocking thread-safe lists ordered by priority
		 */
//		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
//		Thread taskThreads[] = new Thread[5];
//		for (int i = 0; i < taskThreads.length; i++){
//			Task task = new Task(i, queue);
//			taskThreads[i] = new Thread(task);
//		}
//		for (int i = 0; i < taskThreads.length ; i++) {
//			taskThreads[i].start();
//		}
//		for (int i = 0; i < taskThreads.length ; i++) {
//			try {
//				taskThreads[i].join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.printf("Main: Queue Size: %d\n", queue.size());
//		for (int i = 0; i < taskThreads.length * 1000; i++) {
//			Event event = queue.poll();
//			System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
//		}
//		System.out.printf("Main: Queue Size: %d\n", queue.size());
//		System.out.printf("Main: End of the program\n");
		
		/*
		 * Using thread-safe lists with delayed elements
		 */
//		DelayQueue<EventCollection> queue = new DelayQueue<>();
//		Thread threads[] = new Thread[5];
//		for (int i = 0; i < threads.length; i++) {
//			TaskCollection task = new TaskCollection(i + 1, queue);
//			threads[i] = new Thread(task);
//		}
//		for (int i = 0; i < threads.length; i++) {
//			threads[i].start();
//		}
//		for (int i = 0; i < threads.length; i++) {
//			threads[i].join();
//		}
//		do {
//			int counter = 0;
//			EventCollection event;
//			do {
//				event = queue.poll();
//				if (event != null) {
//					counter++;
//				}
//			} while (event != null);
//			System.out.printf("At %s you have read %d events\n", new Date(), counter);
//			TimeUnit.MILLISECONDS.sleep(500);
//		} while (queue.size() > 0);
		
		/*
		 * Using thread-safe navigable maps
		 */
		ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();
		Thread threads[] = new Thread[25];
		int counter = 0;
		for (char i = 'A'; i < 'Z'; i++) {
			TaskMap task = new TaskMap(map, String.valueOf(i));
			threads[counter] = new Thread(task);
			threads[counter].start();
			counter++;
		}
		for (int i = 0; i < 25; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Size of the map: %d\n", map.size());
		Map.Entry<String, Contact> element;
		Contact contact;
		element = map.firstEntry();
		contact = element.getValue();
		System.out.printf("Main: First Entry: %s: %s\n", contact.getName(), contact.getPhone());
		System.out.printf("Main: Submap from A1996 to B1002: \n");
		ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
		do {
			element = submap.pollFirstEntry();
			if (element != null) {
				contact = element.getValue();
				System.out.printf("%s: %s\n",contact.getName(), contact.getPhone());
			}
		} while (element != null);
		
	}
}
