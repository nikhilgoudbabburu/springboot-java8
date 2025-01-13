package com.project.springbootdemo.thread;


public class ThreadDemo {

	public static void main(String[] args) {

//		MyThread t = new MyThread(); //thread initiation till now only one thread
//	1	t.start();// another thread started
		
		/*
		 * for(int i=0;i<4;i++) { System.out.println("Parent/ Main Thread"); }
		 */
		
//	2	System.out.println("Parent/ Main Thread");
		
//		using runnable interface
//		MyRunnable r = new MyRunnable();// runnable interface doesnot have start method
//		Thread thread = new Thread(r);//so we need to create thread class object and pass object of the class which implements runnable interface
//		
//		thread.start();
//		
//		for(int i=0;i<3;i++) {
//			System.out.println("main thread");
//		}
		
//	3	Durga's Approach to define a thread	(not recommended to use)
//		MyThread t = new MyThread();
//		Thread t1 = new Thread(t);
//		
//		t.start();
//		System.out.println("Parent/ Main Thread");
		
//		Getting & Setting name of Thread 
		
//		System.out.println(Thread.currentThread().getName());
//		MyThread t = new MyThread();
//		System.out.println(t.getName()); //default thread name is thread-0 here 0,1,2 anything based on thread number of main thread
//		System.out.println(Thread.currentThread().getName());  // will get current executing thread name
//		t.setName("Nikhil");
//		System.out.println(t.getName());
		
//	4	Thread Priorities
//		System.out.println(Thread.currentThread().getPriority());//5
////		Thread.currentThread().setPriority(17); //Exception in thread "main" java.lang.IllegalArgumentException
//		Thread.currentThread().setPriority(7);//7
//		System.out.println(Thread.currentThread().getPriority());
//		MyThread t = new MyThread();
//		System.out.println(t.getPriority());//7
		
		MyThread t = new MyThread();
		t.start();
		t.interrupt();
		System.out.println("Main Thread");
		
		
	}

}
