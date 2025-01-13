package com.project.springbootdemo.thread;

public class MySynchronizedExThread extends Thread{

	Display d;
	String name;
	
	public MySynchronizedExThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}
