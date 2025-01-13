package com.project.springbootdemo.thread;

public class MyThreadJoin extends Thread{

	public void run() {
		
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(2000);
				System.out.println("Seetha Thread");
			}catch(InterruptedException e) {
				System.out.println("Interupted at "+i);
			}
		}
	}
}
