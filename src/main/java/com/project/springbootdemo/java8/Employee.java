package com.project.springbootdemo.java8;

public class Employee {

	private String name;
    private String city;

    // Constructor
    public Employee(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', city='" + city + "'}";
    }
}
