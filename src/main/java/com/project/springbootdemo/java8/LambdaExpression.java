package com.project.springbootdemo.java8;

public class LambdaExpression {

	public static void main(String[] args) {

		MyInterface functionalInterface = () ->System.out.println("I am in Functional Interface show");

		functionalInterface.show();
	
		//without lambda expression
		FunctionalParameterInterface functionalParameterInterface = new FunctionalParameterInterface() {
			
			@Override
			public int sum(int i, int j) {
				// TODO Auto-generated method stub
				return i+j;
			}
		};
		
		functionalParameterInterface.sum(1, 2);
		
		FunctionalParameterInterface funparamInterf = (i,j)-> i+j;
		System.out.println(funparamInterf.sum(1, 4));
		
	}
	
	

}
