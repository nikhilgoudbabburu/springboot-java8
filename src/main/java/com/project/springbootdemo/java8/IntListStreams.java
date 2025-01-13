package com.project.springbootdemo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class IntListStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> num = Arrays.asList(4, 5, 2, 1, 3);
		List<Integer> dupNum = Arrays.asList(4, 5, 2, 1, 3,1,2,3);
		
		num.forEach(System.out::print);
		for(int n : num) {
			System.out.print("\t"+n);
		}
		System.out.println();
		List<Integer> sortedNums = num.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedNums : " + sortedNums);

		List<Integer> reverseSortedNums = num.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("reverseSortedNums : " + reverseSortedNums);

		List<Integer> sortedNumbers = num.stream().sorted((a, b) -> a - b).collect(Collectors.toList());
		System.out.println("sortedNums : " + sortedNumbers);

		List<Integer> revSortedNumbers = num.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
		System.out.println("revSortedNumbers : " + revSortedNumbers);

		List<Integer> sortedNumbersColl = new ArrayList<>(num); // Create a mutable copy
		Collections.sort(sortedNumbersColl);
		System.out.println("sortedNumbersColl : " + sortedNumbersColl);
		
		List<Integer> revNumbersColl = new ArrayList<>(num); // Create a mutable copy
		Collections.reverse(revNumbersColl);
		System.out.println("revsortedNumbersColl : " + revNumbersColl);
		
//		Multiply
		int product = num.stream().reduce(1, (a, b) -> a * b);
		System.out.println(product); // Output: 120

//		sum
		int sum = num.stream().reduce(0,(a,b)->a+b);
		System.out.println("sum : " + sum);
		
		int sum1 = num.stream().reduce(0,Integer::sum);
		System.out.println("sum : " + sum1);

		int sum2 = num.stream().mapToInt(Integer::intValue).sum();
		System.out.println("sum : " + sum2);
		
//		min
		Optional<Integer> min = num.stream().min(Integer::compareTo);
		System.out.println("min : " + min.get());
		
		OptionalInt min1 = num.stream().mapToInt(Integer::intValue).min();
		System.out.println("min : " + min1.getAsInt());
		
//		max
		Optional<Integer> max = num.stream().max(Integer::compareTo);
		System.out.println("max : " + max.get());
		
		List<Integer> squares = num.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
		System.out.println("Squares : "+squares);
	
		List<Integer> skipped = num.stream()
                .skip(2)
                .collect(Collectors.toList());
		System.out.println("skipped : "+skipped);


		List<Integer> limited = num.stream()
                .limit(3)
                .collect(Collectors.toList());
		System.out.println("limited : "+limited);
		
//		check all no are positve or not
		Boolean positive = num.stream().allMatch(n->n>0);
		System.out.println("positive : "+positive);
		
		boolean noneZero = num.stream()
                .noneMatch(n -> n == 0);
		System.out.println("noneZero : "+noneZero);
		
		Optional<Integer> first = num.stream().findFirst();
		System.out.println("first : "+first.get());

		String joinComma = num.stream().map(n->n.toString()).collect(Collectors.joining(", "));
		System.out.println("joinComma : "+joinComma);


		OptionalDouble average = num.stream()
                .mapToInt(Integer::intValue)
                .average();
		System.out.println("average : "+average);
		
		Optional<Integer> secondHigh = num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("secondHigh "+secondHigh);
		
		List<Employee> employees = Arrays.asList(
	            new Employee("Alice", "New York"),
	            new Employee("Bob", "San Francisco"),
	            new Employee("Charlie", "New York"),
	            new Employee("David", "San Francisco"),
	            new Employee("Eve", "Los Angeles"));

		 // Group employees by city
        Map<String, List<Employee>> employeesByCity = employees.stream()
            .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Employees by city : "+employeesByCity);
        
        
        Map<Integer, Long> noOfOccurences = num.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
		System.out.println("No of occurences "+noOfOccurences);
		
		System.out.println("----------------------------PRACTISE 1-----------------");
		
		//practise : 
		List<Integer> sort1 = num.stream().sorted().collect(Collectors.toList());
		System.out.println("Sort "+sort1);
		
		List<Integer> sortRev1 = num.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sort "+sortRev1);
		
		List<Integer> sort2 = num.stream().sorted((a,b)->a-b).collect(Collectors.toList());
		System.out.println("Sort "+sort2);
		
		List<Integer> sortRev2 = num.stream().sorted((a,b)->b-a).collect(Collectors.toList());
		System.out.println("Sort "+sortRev2);
		
		Optional<Integer> sum21 = num.stream().reduce(Integer::sum);
		System.out.println("Sum "+sum21);
		

		int sum22 = num.stream().reduce(0,(a,b)->a+b);
		System.out.println("Sum "+sum22);
		
		OptionalInt sum23 = num.stream().mapToInt(Integer::intValue).max();
		System.out.println("max21 "+sum23);
		
		OptionalInt max21 = num.stream().mapToInt(Integer::intValue).max();
		System.out.println("max21 "+max21);
		
		OptionalInt min21 = num.stream().mapToInt(Integer::intValue).min();
		System.out.println("min21 "+min21);
		
		Optional<Integer> secondLar21 = num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("secondLar21 "+secondLar21);
		
		Map<Integer, Long> findOcc = num.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
		System.out.println("findOcc "+findOcc);

		Map<String, List<Employee>> groupByCity = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("groupByCity "+groupByCity);
		
		
		//practise 2: 
		//1.sort
		//2.reverse
		//3.sum
		//4.min
		//5.max
		//6.square
		
		System.out.println("----------------------------PRACTISE 2-----------------");
		
		List<Integer> sort22 = num.stream().sorted().collect(Collectors.toList());
		System.out.println("sort 22 "+sort22);

		List<Integer> reverSort22 = num.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("reverSort22 "+reverSort22);
		
		List<Integer> sort221 = num.stream().sorted((a,b)->a-b).collect(Collectors.toList());
		System.out.println("sort 22 "+sort221);
		
		List<Integer> reverSort221 = num.stream().sorted((a,b)->b-a).collect(Collectors.toList());
		System.out.println("sort 22 "+reverSort221);
		
		Optional<Integer> summ22 = num.stream().reduce(Integer::sum);
		System.out.println("summ 22 "+summ22);

		Integer summ221 = num.stream().reduce(0,(a,b)->a+b);
		System.out.println("summ 22 "+summ221);

		Optional<Integer> minn22 = num.stream().reduce(Integer::min);
		System.out.println("minn22 "+minn22);
		
		Optional<Integer> maxx22 = num.stream().reduce(Integer::max);
		System.out.println("maxx22 "+maxx22);

		List<Integer> sqr22 = num.stream().map(n->n*n).collect(Collectors.toList());
		System.out.println("sqr22 "+sqr22);
		
		List<Integer> skip22 = num.stream().skip(2).collect(Collectors.toList());;
		System.out.println("skip22 "+skip22);
		
		List<Integer> limit22 = num.stream().limit(2).collect(Collectors.toList());;
		System.out.println("limit22 "+limit22);
		
		Boolean positiveNum = num.stream().allMatch(n->n>0);
		System.out.println("positiveNum "+positiveNum);
		
		Boolean nonZero = num.stream().noneMatch(n->n==0);
		System.out.println("nonZero "+nonZero);

		Optional<Integer> findFirst1 = num.stream().findFirst();
		System.out.println("findFirst1 "+findFirst1);
		
		String joinComma2 = num.stream().map(n->n.toString()).collect(Collectors.joining(","));
		System.out.println("joinComma2 "+joinComma2);
		
		OptionalDouble average2 = num.stream().mapToInt(Integer::intValue).average();
		System.out.println("average2 "+average2);
		
		Optional<Integer> secondHigh2 = num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("secondHigh2 "+secondHigh2);
		
		// Group employees by city
        Map<String, List<Employee>> employeesByCity2 = employees.stream()
        		.collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("employeesByCity2 "+employeesByCity2);
		
		Map<Integer, Long> findOcc2 = num.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
		System.out.println("findOcc2 "+findOcc2);
		
		Set<Integer> seen = new HashSet<>();
		Set<Integer> duplicates = dupNum.stream().filter(n->!seen.add(n)).collect(Collectors.toSet());
		System.out.println("duplicates "+duplicates);

		
	}

}
