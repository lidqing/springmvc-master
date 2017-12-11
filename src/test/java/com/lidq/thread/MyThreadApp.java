package com.lidq.thread;

public class MyThreadApp implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 10; i > 0; i--) {
				System.out.println("Thread: "
						+ Thread.currentThread().getName() + ", " + i);
				// 让线程睡眠一会
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " interrupted.");
		}

	}
	

	public static void main(String[] args) {

		Thread t = new Thread(new MyThreadApp(), "threa-0");
		t.start();
		
		Thread t2 = new Thread(new MyThreadApp(), "threa-1");
		t2.start();
	}

}
