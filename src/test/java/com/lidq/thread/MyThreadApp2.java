package com.lidq.thread;

public class MyThreadApp2 extends Thread{

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
		MyThreadApp2 t = new MyThreadApp2();
		t.start();
		
		MyThreadApp2 t2 = new MyThreadApp2();
		t2.start();
	}
	

}
