package yk;
/**
 * sleepʹ�õ�ǰ�߳�����
 */
import java.util.Date;
public class Sleep {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		try {
			Thread.sleep(10000);//��Ϣ10s
		} catch (InterruptedException e) {}
		//myThread.stop();
		//myThread.interrupt();//ʹ�̴߳��
		//myThread.flag = false;//�����߳�
		myThread.shutDown();
	}
}

class MyThread extends Thread{
	boolean flag = true;
	@Override
	public void run() {
		while (flag) {
			System.out.println(new Date());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("�����ˡ���������������������������");
				return;
			}
		}
	}
	public void shutDown(){
		flag = false;
	}
}