package yk;
/**
 * ËÀËø
 * synchronized1 -> synchronized2
 * synchronized2 -> synchronized1
 */
public class Synchronization2 implements Runnable{
	
	public int flag = 1;
	static Object o1 = new Object(), o2 = new Object();
	
	@Override
	public void run() {
		System.out.println("flag="+flag);
		if (flag==1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("1");
				}
			}
		} 
		
		if(flag==0){
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("0");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Synchronization2 syn = new Synchronization2();
		Synchronization2 syn2 = new Synchronization2();
		syn.flag = 1;
		syn2.flag = 0;
		Thread thread = new Thread(syn);
		Thread thread2 = new Thread(syn2);
		thread.start();
		thread2.start();
	}
	
}
