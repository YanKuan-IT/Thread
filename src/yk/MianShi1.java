package yk;
/**
 * 
 * ��m1()ִ�еĹ����У�m2()����ִ���� ����
 *
 */
public class MianShi1 implements Runnable{
	
	int b = 100;
	
	public synchronized void m1() throws InterruptedException{
		b = 500;
		Thread.sleep(5000);
		System.out.println("b="+b);
	}
	
	public void m2(){
		System.out.println(b);//500
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
		MianShi1 mianShi1 = new MianShi1();
		
		Thread thread = new Thread(mianShi1);
		thread.start();
		
		Thread.sleep(1000);
		mianShi1.m2();
		
	}
}
