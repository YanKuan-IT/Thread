package yk;

public class Test2_1 implements Runnable{
	
	int b = 100;
	public synchronized void m1() throws Exception{
		for (int i = 0; i <20; i++) {
			Thread.sleep(500);
			System.out.println("111111111111111111111111");
		}
	}
	
	public void m2() throws InterruptedException{
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
		Test2_1 test2_1 = new Test2_1();
		Thread thread = new Thread(test2_1);
		
		thread.start();
		test2_1.m2();
	}
}
