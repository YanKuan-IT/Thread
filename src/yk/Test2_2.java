package yk;

public class Test2_2 implements Runnable{
	
	public synchronized void m1() throws Exception{
		for (int i = 0; i <20; i++) {
			Thread.sleep(500);
			System.out.println("111111111111111111111111");
		}
	}
	
	public synchronized void m2() throws InterruptedException{
		for (int i = 0; i < 20; i++) {
			Thread.sleep(500);
			System.out.println("22222222222222222222222");
		}
	}
	
	@Override
	public void run() {
		try {
			m1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		Test2_2 test2_2 = new Test2_2();
		Thread thread = new Thread(test2_2);
		
		thread.start();
		test2_2.m2();
		
	}
}
