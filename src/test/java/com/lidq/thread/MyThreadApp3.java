package com.lidq.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 有返回值的线程
 * @author LDQ
 *
 */
public class MyThreadApp3 implements Callable<Object> {

	private static int index = 0;
	
	@Override
	public Object call() throws Exception {
		index++;
		System.out.println("run thread "+ (index));
		Thread.sleep(3000);
		return Thread.currentThread().getId();
	}

	public static void main(String[] args) {

		int taskSize = 5;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		
		//创建多个有返回值的线程
		List<Future<Object>> list = new ArrayList<Future<Object>>();
		for(int i=0;i<20;i++){
			MyThreadApp3 c = new MyThreadApp3();
			Future<Object> f = pool.submit(c);
			list.add(f);
		}
		pool.shutdown();
		
		//获取所有并发任务的运行结果
		for(Future<Object> fs : list){
			try {
				System.out.println(""+fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}

}
