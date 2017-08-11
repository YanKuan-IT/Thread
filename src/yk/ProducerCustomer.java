package yk;

public class ProducerCustomer {
	public static void main(String[] args) {
		Stack stack = new Stack();
		Producer producer = new Producer(stack);
		Customer customer = new Customer(stack);
		new Thread(producer).start();
		new Thread(customer).start();
	}
}

class Apple {
	private int id;
	public Apple(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Apple:"+id;
	}
}

class Stack {
	int index = 0;
	Apple[] apples = new Apple[10];
	
	public synchronized void push(Apple apple){
		while(index == apples.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		apples[index] = apple;
		index++;
	}
	
	public synchronized void pop(){
		while(index == 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
	}
}

class Producer implements Runnable{
	
	Stack stack = null;
	public Producer(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Apple apple = new Apple(i);
			stack.push(apple);
			System.out.println("生产了："+(i+1));
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Customer implements Runnable {
	Stack stack = null;
	public Customer(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <20; i++) {
			stack.pop();
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("*********消费了："+(i+1));
		}
	}
}

