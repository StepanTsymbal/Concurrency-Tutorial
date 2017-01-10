package threadexecutors;

import java.util.Date;

public class TaskPeriod implements Runnable {
	
	private String name;

	public TaskPeriod(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s: Starting at : %s\n", name, new Date());
	}
	
	

}
