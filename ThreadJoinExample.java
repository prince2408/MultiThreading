
public class ThreadJoinExample implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread started::  "+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadJoinExample(),"thread1");
		Thread t2 = new Thread(new ThreadJoinExample(),"thread2");
		Thread t3 = new Thread(new ThreadJoinExample(),"thread3");
		
		t1.start();
		
		try {
			// Start second thread after waiting for 2 sec or when the t1 is
			// dead.
			t1.join(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		
		try {
			//Start the 3rd thread when t1 is dead, since there is no 
			//parameter passed in the join() so no need to wait for certain 
			// timeline.
			  
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All threads are dead, exiting main thread !!");
	}
}
