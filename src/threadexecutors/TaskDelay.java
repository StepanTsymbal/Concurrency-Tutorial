package threadexecutors;

import java.util.Date;
import java.util.concurrent.Callable;

public class TaskDelay implements Callable<String> {
	
	private String name;

	public TaskDelay(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.printf("%s: Starting at : %s\n", name, new Date());
		return "Hello, world";
	}

}
