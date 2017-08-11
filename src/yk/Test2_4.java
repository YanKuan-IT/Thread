package yk;

public class Test2_4 {
	
	public static void main(String[] args) throws Exception {
		TT2 tt2 = new TT2();
		
		Thread thread = new Thread(tt2);
		thread.start();
		tt2.m2();
	}
}

class TT2 implements Runnable{
	public synchronized void m1() throws Exception{
		for (int i = 0; i <10; i++) {
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
	
	public synchronized void m2() throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			Thread.sleep(500);
			System.out.println("22222222222222222222222");
		}
	}
}