package com.project.springbootdemo.thread;

//MultiThreading by durga sir 12-08-24
public class MyThread extends Thread{
	
	/*
	 * public void run(){
	 * 
	 * for(int i=0; i<4;i++) { System.out.println("Child Thread"); } }
	 */
	
//	case 4 Run Method overloading
	
	/*public void run() {
		System.out.println("no arg method");
	}
	
	public void run(int i) {
		System.out.println("no arg method "+i);
	}*/
	
//	case 5 Overload Start Method
//	public void start() {
//		super.start();
//		System.out.println("start method");
//		
//	}
//	
//	public void run() {
//		System.out.println("run method");
//		
//	}
	/*
	 * public void run() { try { for(int i=0;i<4;i++) {
	 * System.out.println("Child thread"); Thread.sleep(2000); }
	 * }catch(InterruptedException e) { System.out.println("I am interrupted"); } }
	 */
	
	public void run() {
		for(int i=0;i<4;i++) {
			System.out.println("Child thread");
			
		}
		System.out.println("Thread entering into sleeping state");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			System.out.println("I am interrupted");
		}
	}
	

}
