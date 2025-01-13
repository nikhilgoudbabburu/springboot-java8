package com.project.springbootdemo.thread;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		
		MyThread t = new MyThread();
//		t.setPriority(10);
		t.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("parent thread");
		}
	}

}
