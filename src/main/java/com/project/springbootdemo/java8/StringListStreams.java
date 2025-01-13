package com.project.springbootdemo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringListStreams {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("apple");
		list.add("bananas");
		list.add("gra");
		list.add("nang");
		list.add("mang");
		list.add("mbng");
		list.add("orange");

		System.out.println("list of fruits : ");
		for (String fruits : list) {
			System.out.println(fruits);
		}

		List<String> courses = Arrays.asList("oops", "exception", "collections", "db");
		System.out.println("List of courses : " + courses);

		// sort in natural alphabetical order
		List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedList : " + sortedList);

		// sort using case insensitive as sorted is case sensitive it order first
		// uppercase
		List<String> sortedListCaseInsesitive = list.stream().sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());
		System.out.println("sortedListCaseInsesitive : " + sortedListCaseInsesitive);

		// sort in reverse order
		List<String> sortReverseList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("sortReverseList : " + sortReverseList);

		// sort in case insensitive reverse order
		List<String> sortedReverseListCaseInsesitive = list.stream().sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.collect(Collectors.toList());
		System.out.println("sortedReverseListCaseInsesitive : " + sortedReverseListCaseInsesitive);

		// sort based on length
		List<String> sortOnLength = list.stream().sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		System.out.println("sortOnLength : " + sortOnLength);

		// sort reverse based on length
		List<String> sortReverseOnLength = list.stream().sorted(Comparator.comparingInt(String::length).reversed())
				.collect(Collectors.toList());
		System.out.println("sortReverseOnLength : " + sortReverseOnLength);

//		Given a list of strings, filter out all strings that are longer than 3 characters.
		List<String> getGreaterthan3Char = list.stream().filter(s -> s.length() > 3).collect(Collectors.toList());
		System.out.println("sortGreaterthan3Char : " + getGreaterthan3Char);

		List<String> upper = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("upper : " + upper);

		// 3. Count Strings Starting with a Specific Letter
		long startsWithA = list.stream().filter(s -> s.startsWith("a")).count();
		System.out.println("startsWithA : " + startsWithA);

		// group by length
		Map<Integer, List<String>> groupedByLength = list.stream().collect(Collectors.groupingBy(String::length));
		System.out.println("groupedByLength : " + groupedByLength);

//		7. Concatenate Strings with a Comma
		StringJoiner sj = new StringJoiner(",");
		list.stream().forEach(s -> {
			sj.add(s);
		});
		System.out.println("concat with comma : " + sj.toString());

//		7. Concatenate Strings with a Comma
		String concatComma = list.stream().collect(Collectors.joining(","));
		System.out.println("concat with comma : " + concatComma);

		// contains
		List<String> containsAn = list.stream().filter(s -> s.contains("an")).collect(Collectors.toList());
		System.out.println("containsAn : " + containsAn);

		List<String> duplicateRemove = list.stream().distinct().collect(Collectors.toList());
		System.out.println("duplicateRemove : " + duplicateRemove);

		List<String> duplicateRemove2 = new ArrayList<String>(list.stream().collect(Collectors.toSet()));
		System.out.println("duplicateRemove2 : " + duplicateRemove2);

		boolean allUppercase = list.stream().allMatch(s -> s.equals(s.toUpperCase()));
		System.out.println("allUppercase : " + allUppercase);

		boolean containsDigit = list.stream().anyMatch(s -> s.matches(".*\\d.*"));
		System.out.println("containsDigit : " + containsDigit);

//		min
		Optional<String> shortest = list.stream().min(Comparator.comparingInt(String::length));
		System.out.println("shortest : " + shortest.get());

		int totalLength = list.stream().mapToInt(String::length).sum();
		System.out.println("totalLength : " + totalLength);

		List<String> skipFirst2 = list.stream().skip(2).collect(Collectors.toList());
		System.out.println("skipFirst2 : " + skipFirst2);

		List<String> limit2 = list.stream().limit(2).collect(Collectors.toList());
		System.out.println("limit2 : " + limit2);

		Optional<String> lastAlphabetically = list.stream().sorted(Comparator.reverseOrder()).findFirst();
		System.out.println("last " + lastAlphabetically);
		
		List<String> num = Arrays.asList("1","2","3");
		int sum = num.stream().mapToInt(Integer::parseInt).sum();
		System.out.println("sum " + sum);
		
		List<String> capitalFirstletter = list.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.toList());
		System.out.println("capitalFirstletter : "+capitalFirstletter);
	
	}

}
