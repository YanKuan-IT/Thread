package yk;

public class Synchronization1 implements Runnable{
	
	Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		
		Synchronization1 syn = new Synchronization1();
		
		Thread thread1 = new Thread(syn);
		Thread thread2 = new Thread(syn);
		thread1.setName("t1");
		thread2.setName("t2");
		thread1.start();
		thread2.start();
		
		Thread.sleep(1000);
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
	}

	@Override
	public void run() {
		try {
			timer.add(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Timer{
	
	private static int num = 0;
	//��ִ����������Ĺ��̵���������ǰ����
	public synchronized void add(String name) throws InterruptedException{
		//��ʽ1��
//	public synchronized void add(String name){
		
		//��ʽ2��
		//��
//		synchronized (this) {  
			Thread.sleep(500);
			num++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("���ǵ�"+num+"��ʹ��timer���߳�");
//		}
	}
	
}
