package yk;

public class Test2_3 implements Runnable{
	int b = 100;
	public synchronized void m1() throws Exception{
		for (int i = 0; i <20; i++) {
			Thread.sleep(500);
			System.out.println("111111111111111111111111");
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
 		Test2_3 test2_3 = new Test2_3();
		TT tt = new TT();
		
		Thread thread = new Thread(test2_3);
		
		thread.start();
		tt.m2();
	}
}

class TT {
	public synchronized void m2() throws InterruptedException{
		for (int i = 0; i < 20; i++) {
			Thread.sleep(500);
			System.out.println("22222222222222222222222");
		}
	}
}
