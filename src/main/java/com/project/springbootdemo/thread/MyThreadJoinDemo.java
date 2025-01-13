package com.project.springbootdemo.thread;

public class MyThreadJoinDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		MyThreadJoin t = new MyThreadJoin();
		t.start();
		t.join();
		
		for(int i=0;i<5;i++) {
			System.out.println("Rama Thread");
		}
		
	}

}
