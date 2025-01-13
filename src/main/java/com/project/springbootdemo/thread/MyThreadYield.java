package com.project.springbootdemo.thread;

public class MyThreadYield extends Thread{
	
	public void run() {
		
		for(int i=0;i<4;i++) {
			System.out.println("Child Thread");
			Thread.yield();
		}
	}
	
}
