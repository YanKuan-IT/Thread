package yk;
/**
 * �����߳�ִ����֮����ִ����������
 *
 */
public class Test implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		
		Test test = new Test();
		Thread thread = new Thread(test);
		Thread thread2 = new Thread(test);
		thread.start();
		thread2.start();
		
		thread.join();
		thread2.join();
		
		//���߳�ִ����֮����ִ��for
		for (int i = 0; i < 20; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.print(i+"~");
		}
		System.out.println();
	}
}
