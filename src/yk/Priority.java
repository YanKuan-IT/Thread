package yk;
/**
 * 
 * 优先级1--10 默认5
 *
 */
public class Priority {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		//设置优先级
		t1.setPriority(Thread.NORM_PRIORITY+3);
		t1.start();
		t2.start();
	}
}

class T1 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("t1:"+i);
		}
	}
}

class T2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("----------------t2:"+i);
		}
	}
}