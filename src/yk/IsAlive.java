package yk;

public class IsAlive {
	public static void main(String[] args) {
		
		Runner6 runner6 = new Runner6();
		Thread thread = new Thread(runner6);
		thread.start();
		
		for (int i = 0; i < 50; i++) {
			System.out.println("----------mainThread:"+i);
		}
		
	}
}

class Runner6 implements Runnable{

	@Override
	public void run() {
		//当前的线程 true
		System.out.println(Thread.currentThread().isAlive());
		for (int i = 0; i < 50; i++) {
			System.out.println("subThread:"+i);
		}
	}
}
