package com.project.springbootdemo.thread;

public class ThreadYieldDemo {

	public static void main(String[] args) {
		
		MyThreadYield t = new MyThreadYield();
		t.start();
		
		for(int i=0;i<4;i++) {
			System.out.println("Main thread");
		}
	}
	
	
	
}
