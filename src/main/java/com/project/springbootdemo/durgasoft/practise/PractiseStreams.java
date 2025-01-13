package com.project.springbootdemo.durgasoft.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PractiseStreams {
	
	public static void main(String[] args) {
		
		
		List<Integer> marks = new ArrayList<>(Arrays.asList(15,25,35,45,55,65));
		marks.add(10);
		marks.add(20);
		System.out.println(marks);
		
		List<String> fruits = new ArrayList<>(Arrays.asList("apple","banana","gava","pomegranate"));
		fruits.add("date");
		fruits.add("strawberry");
		
		//count to count the elements in stream
		long noOfFailedStudents = marks.stream().filter(m->m>=35).count();
		System.out.println("No of Failed Students : "+noOfFailedStudents);
		
		//sorted to sort in  natural sorting order
		List<Integer> sort = marks.stream().sorted().collect(Collectors.toList());
		System.out.println("sort : "+sort);
		
		//reverse order
		List<Integer> reverse = marks.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("reverse : "+reverse);
		
		//reverse order
		//comparable interface has compareTo method
		//comparator has compare method
		List<Integer> reverse1 = marks.stream().sorted((n1,n2)->n2.compareTo(n1)).collect(Collectors.toList());
		System.out.println("reverse : "+reverse1);
		
		List<String> sortFruits = fruits.stream().sorted().collect(Collectors.toList());
		System.out.println("sort fruits as per alphabetical order : "+sortFruits);
		
		List<String> sortFruitsByLength = fruits.stream().sorted(
				(s1,s2)->
			s1.length()>s2.length()?1:s1.length()<s2.length()?-1:s1.compareTo(s2)
				).collect(Collectors.toList());
		System.out.println("sort fruits as per length ascending order : "+sortFruitsByLength);
		
		
		// sort based on length
		List<String> sortOnLength = fruits.stream().sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		System.out.println("sortOnLength : " + sortOnLength);

		// sort reverse based on length
		List<String> sortReverseOnLength = fruits.stream().sorted(Comparator.comparingInt(String::length).reversed())
				.collect(Collectors.toList());
		System.out.println("sortReverseOnLength : " + sortReverseOnLength);

		
		//min
		OptionalInt min = marks.stream().mapToInt(Integer::intValue).min();
		
		marks.stream().min((i1,i2)->i1.compareTo(i2)); // it can also represent as below
		marks.stream().min(Integer::compareTo);
		
		System.out.println("min : " + min.getAsInt());
		
		//min
		OptionalInt max = marks.stream().mapToInt(Integer::intValue).min();
		
		marks.stream().max((i1,i2)->i1.compareTo(i2)); // it can also represent as below
		marks.stream().max(Integer::compareTo);
		
		System.out.println("max : " + max.getAsInt());

		//print squares using foreach
		marks.stream().forEach(i->{
			System.out.println("square of "+i+" is : "+i*i);
		});
		
		//toArray
		Integer[] i = marks.stream().toArray(Integer[]::new);
		
		//Integer array to stream
		Stream.of(i).forEach(System.out::println);
		
		//here we are using our own customized sorting order else default it used naturalsorting order as treeset
		//internally uses comapreTo() so 
		Set<Integer> setWithoutComparator = new TreeSet<>();
		setWithoutComparator.addAll(Arrays.asList(8,7,1,2,3,4,5,6));
		System.out.println("Natural Sorting : " +setWithoutComparator);

		//here we are using our own customized sorting order else default it used naturalsorting order as treeset
		//internally uses comapreTo() so 
		Set<Integer> set = new TreeSet<>(new MyComparator());
		set.addAll(Arrays.asList(8,7,1,2,3,4,5,6));
		System.out.println("Custom sorting using TREE SET : " +set);
		
		List<String> fr = fruits.stream().sorted((a1,a2)->Integer.valueOf(a2.length()).compareTo(a2.length())).collect(Collectors.toList());
		System.out.println(fr);
	}

}
