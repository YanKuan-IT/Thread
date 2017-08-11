package yk;

public class One_3 implements Runnable {
	public static void main(String[] args) {
		
		One_3 two = new One_3();
		
		Thread thread1 = new Thread(two);
		Thread thread2 = new Thread(two);
		thread1.start();
		thread2.start();
		
		
	}
	
	@Override
	public void run() {
		for (int i = 0; i <=100; i++) {
			System.out.println(i);
		}
	}
	
}

