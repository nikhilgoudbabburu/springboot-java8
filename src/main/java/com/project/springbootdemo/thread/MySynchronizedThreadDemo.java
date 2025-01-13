package com.project.springbootdemo.thread;

public class MySynchronizedThreadDemo {
	
	public static void main(String[] args) {
	
	Display d = new Display();
	MySynchronizedExThread t1  =new MySynchronizedExThread(d, "Dhoni");
	MySynchronizedExThread t2  =new MySynchronizedExThread(d, "Raina");
	t1.start();
	t2.start();
	
	}
}