package yk;
/**
 * �ϲ�ĳ���߳�
 *
 */
public class Join {
	
	public static void main(String[] args) {
		
		MyThread2 t1 = new MyThread2("t1");
		t1.start();
		//***************�ϲ�    �൱�ڷ�������*********************
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//************************************
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main main");
		}
		
	}
	
	
}

class MyThread2 extends Thread {
	public MyThread2(String s) {
		super(s);
	}
	@Override
	public void run() {
		
		for (int i = 0; i <= 10; i++) {
			System.out.println(getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}
	
}
