
public class ThreadLocalExample implements Runnable{

	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadLocalExample());
		t1.start();
	}

	@Override
	public void run() {
		
		threadLocal.set("new thread local set");
		System.out.println(threadLocal.get());
	}
}
