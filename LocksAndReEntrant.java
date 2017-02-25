import java.util.concurrent.locks.Lock;


public class LocksAndReEntrant implements Runnable{

	private static Lock lock;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("inside run");
		method1();
		/*
		 *calling to method 3 will throw an exception because default behaviour of lock doesn't provide
		 *the feature of lock re-entrant because isLocked is set to true no thread can acquire the monitor lock
		 *even if it is on the same object.
		 */
		method3();
		
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new LocksAndReEntrant());
		t1.start();
		
		
	}
	
	/*
	 * Below is an example of lock re-entrant i.e.  if a Java thread enters a synchronized block of code,
	 *  and thereby take the lock on the monitor object the block is synchronized on, the thread can enter 
	 *  other Java code blocks synchronized on the same monitor object. Below we can see that thread has acquired monitor on method1 
	 *  and since method2 is being called from method1 itself so here thread can enter method2 as well but same is not the case
	 *  when we use lock;
	 */
	public static void method1(){
		synchronized (LocksAndReEntrant.class) {
		System.out.println("inside method1");
		method2();
		}
	}
	
	public static void method2(){
		synchronized (LocksAndReEntrant.class) {
			System.out.println("inside method2");
		}
		
	}
	
	public static void method3(){
		lock.lock();
		System.out.println("inside method3");
		method4();
		lock.unlock();
	}
	
	public static void method4(){
		lock.lock();
		System.out.println("inside method4");
		lock.unlock();
	}

	
}

/**
 * simple Lock implementation
**/
class Lock1{

	private boolean isLocked = false;
	
	private synchronized void lock() throws InterruptedException{
		//spin lock
		while(isLocked){
			wait();
		}
		isLocked = true;
	}
	
	private synchronized void unlock(){
		isLocked = false;
		notify();
	}
}