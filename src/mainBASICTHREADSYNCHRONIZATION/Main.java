package mainBASICTHREADSYNCHRONIZATION;

import basicthreadsynchronization.Account;
import basicthreadsynchronization.Bank;
import basicthreadsynchronization.Buffer;
import basicthreadsynchronization.Cinema;
import basicthreadsynchronization.Company;
import basicthreadsynchronization.Consumer;
import basicthreadsynchronization.ConsumerCondition;
import basicthreadsynchronization.EventStorage;
import basicthreadsynchronization.FileMock;
import basicthreadsynchronization.Job;
import basicthreadsynchronization.PricesInfo;
import basicthreadsynchronization.PrintQueue;
import basicthreadsynchronization.Producer;
import basicthreadsynchronization.ProducerCondition;
import basicthreadsynchronization.Reader;
import basicthreadsynchronization.TicketOffice1;
import basicthreadsynchronization.TicketOffice2;
import basicthreadsynchronization.Writer;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Synchronizing a method
		 */
//		Account account = new Account();
//		account.setBalance(1000);
//		Company company = new Company(account);
//		Thread companyThread = new Thread(company);
//		Bank bank = new Bank(account);
//		Thread bankThread = new Thread(bank);
//		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
//		companyThread.start();
//		bankThread.start();
//		try {
//			companyThread.join();
//			bankThread.join();
//			System.out.printf("Account : Final Balance: %f\n", account.getBalance());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		/*
		 * Arranging independent attributes in synchronized classes
		 */
//		Cinema cinema = new Cinema();
//		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
//		Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");
//		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
//		Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");
//		thread1.start();
//		thread2.start();
//		try {
//			thread1.join();
//			thread2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
//		System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
		
		/*
		 * Using conditions in synchronized code
		 */
//		EventStorage storage = new EventStorage();
//		Producer producer = new Producer(storage);
//		Thread thread1 = new Thread(producer);
//		Consumer consumer = new Consumer(storage);
//		Thread thread2 = new Thread(consumer);
//		thread2.start();
//		thread1.start();
		
		/*
		 * Synchronizing a block of code with a Lock
		 */
//		PrintQueue printQueue = new PrintQueue();
//		Thread thread[] = new Thread[10];
//		for (int i = 0; i < 10; i++){
//			thread[i] = new Thread(new Job(printQueue), "Thread " + i);
//		}
//		for (int i = 0; i<10; i++){
//			thread[i].start();
//		}
		
		/*
		 * Synchronizing data access with read/write locks
		 */
//		PricesInfo pricesInfo = new PricesInfo();
//		Reader readers[] = new Reader[5];
//		Thread threadsReader[] = new Thread[5];
//		for (int i = 0; i < 5; i++) {
//			readers[i] = new Reader(pricesInfo);
//			threadsReader[i] = new Thread(readers[i]);
//		}
//		Writer writer = new Writer(pricesInfo);
//		Thread threadWriter = new Thread(writer);
//		for (int i = 0; i < 5; i++) {
//			threadsReader[i].start();
//		}
//		threadWriter.start();
		
		/*
		 * Using multiple conditions in a Lock
		 */
		FileMock mock = new FileMock(100, 10);
		Buffer buffer = new Buffer(20);
		ProducerCondition producer = new ProducerCondition(mock, buffer);
		Thread threadProducer = new Thread(producer, "Producer");
		ConsumerCondition consumers[] = new ConsumerCondition[3];
		Thread threadConsumers[] = new Thread[3];
		for (int i = 0; i < 3; i++) {
			consumers[i] = new ConsumerCondition(buffer);
			threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
		}
		threadProducer.start();
		for (int i = 0; i < 3; i++){
			threadConsumers[i].start();
		}
		
	}
}
