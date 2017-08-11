package yk;
/**
 * 方式1，推荐使用这种方式     接口
 *
 */
public class One_1 {
	public static void main(String[] args) throws InterruptedException {
		Runner1 r = new Runner1();
		
		Thread t = new Thread(r);
		t.start();
		Thread.sleep(1000);
		for (int i = 0; i < 100; i++) {
			System.out.println("main Thread:-----"+i);
		}
	}
}

class Runner1 implements Runnable{
	@Override
	public void run() {
		try {
			show();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void show() throws InterruptedException{
		System.out.println("=====================");
		Thread.sleep(3000);
		for(int i=0;i<100;i++){
			System.out.println("Runner1:"+i);
		}
		
	}
}
