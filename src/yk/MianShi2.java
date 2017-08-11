package yk;

public class MianShi2 implements Runnable{
	
	int b = 100;
	
	public synchronized void m1() throws InterruptedException{
		b = 500;
		Thread.sleep(5000);
		System.out.println("b="+b);//2000
	}
	
	public void m2() throws InterruptedException{
		Thread.sleep(2500);
		b = 2000;
	}
	
	@Override
	public void run() {
		try {
			m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MianShi2 mianShi1 = new MianShi2();
		
		Thread thread = new Thread(mianShi1);
		thread.start();
		
		mianShi1.m2();
		
	}
}
