package com.project.springbootdemo.java8;

public class FunctionalInterface {

	public static void main(String[] args) {
		
		MyInterface functionalInterface = new MyInterface() {
			
			@Override
			public void show() {
				System.out.println("I am in Functional Interface show");
			}
		};
		
		functionalInterface.show();
	}
}
