package yk;
/**
 * sleep使得当前线程休眠
 */
import java.util.Date;
public class Sleep {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		try {
			Thread.sleep(10000);//休息10s
		} catch (InterruptedException e) {}
		//myThread.stop();
		//myThread.interrupt();//使线程打断
		//myThread.flag = false;//结束线程
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
				System.out.println("结束了。。。。。。。。。。。。。。");
				return;
			}
		}
	}
	public void shutDown(){
		flag = false;
	}
}