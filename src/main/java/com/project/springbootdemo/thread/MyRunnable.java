package com.project.springbootdemo.thread;

public class MyRunnable implements Runnable {
	
	public void run() {
		
		for(int i=0;i<3;i++) {
			System.out.println("Child Thread");
		}
	}


}
