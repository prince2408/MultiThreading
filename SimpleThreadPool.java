package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Thread Pools are useful when you need to limit the number of threads running in your application at the same time.
 *  There is a performance overhead associated with starting a new thread, and each thread is also allocated some memory 
 *  for its stack etc.

 *Instead of starting a new thread for every task to execute concurrently, the task can be passed to a thread pool.
 * As soon as the pool has any idle threads the task is assigned to one of them and executed. Internally the tasks are inserted
 * into a Blocking Queue which the threads in the pool are dequeuing from. When a new task is inserted into the queue one of the
 *  idle threads will dequeue it successfully and execute it. 
 *  The rest of the idle threads in the pool will be blocked waiting to dequeue tasks.

 *Thread pools are often used in multi threaded servers. Each connection arriving at the server via the network is wrapped as a 
 *task and passed on to a thread pool. The threads in the thread pool will process the requests on the connections concurrently.
 *Java 5 comes with built in thread pools in the java.util.concurrent package, so you don't have to implement your own thread pool.
 * @author abhkumar
 *
 */
public class SimpleThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 5; i++) {
			WorkerThread thread = new WorkerThread(" "+1);
			executor.execute(thread);
		}
		executor.shutdown();
		System.out.println("Finished all threads");
	}
}

class WorkerThread implements Runnable {

	String command;

	public WorkerThread(String command) {
		// TODO Auto-generated constructor stub
		this.command = command;
	}

	public String getCommand() {
		return this.command;
	}

	@Override
	public void run() {

		System.out.println("Starting thread : "
				+ Thread.currentThread().getName() + " loop value"
				+ getCommand());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + "  end the thread");

	}

}
