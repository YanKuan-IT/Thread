package yk;

/**
 * 方式2，此种方式不太灵活
 *
 */
public class One_2 {
	public static void main(String[] args) {
		Runner2 runner2 = new Runner2();
		runner2.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("main Thread:-----"+i);
		}
	}
}

class Runner2 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("Runner1:"+i);
		}
	}
}

