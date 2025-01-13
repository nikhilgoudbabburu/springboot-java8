package com.project.springbootdemo.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeApi {

	public static void main(String[] args) {
		LocalDateTime dt = LocalDateTime.now();
		int dd = dt.getDayOfMonth();
		String month = dt.getMonth().toString();
		int mm = dt.getMonthValue();
		int year = dt.getYear();
		
		int h = dt.getHour();
		int m = dt.getMinute();
		int s = dt.getSecond();
		int n = dt.getNano();
		
		System.out.printf("\nDate : %d - %s - %d - %d\n",dd,month,mm,year);
		System.out.println(dt);
		System.out.printf("Date : %d - %s - %d - %d",dd,month,mm,year);
		System.out.printf("\nTime : %d - %d - %d - %d",h,m,s,n);
		
		LocalDateTime dob = LocalDateTime.of(2000, 4, 21, 6,21,8);
		System.out.println("\nDOB : "+dob);
		System.out.println("Before 4 months : "+dob.minusMonths(4));
		System.out.println("After 4 Months : "+dob.plusMonths(4));
		
		LocalDate dateOfBirth = LocalDate.of(2000, 4, 21);
		LocalDate today = LocalDate.now();
		Period p = Period.between(dateOfBirth, today);
		System.out.printf("\nyour age is %d years %d months %d days",p.getYears(), p.getMonths(), p.getDays());
	
		LocalDate buyCarDate = LocalDate.of(2030,04, 21);
		Period timePeriod = Period.between(today, buyCarDate);
		int daysLeftForCar = timePeriod.getYears()*365 + timePeriod.getMonths()*30 + timePeriod.getDays();
		System.out.printf("\nDays left to buy new car %d\n",daysLeftForCar);
	
		//find leap year or not
		Year yr = Year.of(2024);
		System.out.println(yr.isLeap()?"Leap Year ":"Not a leap year ");
		System.out.println(yr);
		
//		DateTimeFormatter formatter = DateTimeFormatter.
		LocalDateTime beforeFormat = LocalDateTime.now();
		System.out.println("Before formatting "+beforeFormat);
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
		
		String afterFormat = beforeFormat.format(dateFormat);
		System.out.println("After formatting "+afterFormat);

		
	}
}
