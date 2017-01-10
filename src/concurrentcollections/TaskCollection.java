package concurrentcollections;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class TaskCollection implements Runnable {
	
	private int id;
	private DelayQueue<EventCollection> queue;
	
	public TaskCollection(int id, DelayQueue<EventCollection> queue) {
		this.id = id;
		this.queue = queue;
	}

	@Override
	public void run() {
		Date now = new Date();
		Date delay = new Date();
		delay.setTime(now.getTime() + (id * 1000));
		System.out.printf("Thread %s: %s\n", id, delay);
		for (int i = 0; i < 100; i++) {
			EventCollection event = new EventCollection(delay);
			queue.add(event);
		}
	}
		
}
