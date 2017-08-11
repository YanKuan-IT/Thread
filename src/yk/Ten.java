package yk;

public class Ten implements Runnable{
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Ten());
			thread.start();
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
	}
}
