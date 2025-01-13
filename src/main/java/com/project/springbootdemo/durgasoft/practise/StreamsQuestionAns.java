package com.project.springbootdemo.durgasoft.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.gson.internal.Streams;

public class StreamsQuestionAns {

	public static void main(String[] args) {

//		1.remove duplicates
		List<Integer> list = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 5, 1,2,2,2,2,2,2));

		List<Integer> removeDuplicate = list.stream().distinct().collect(Collectors.toList());
		System.out.println("removeDuplicate : " + removeDuplicate);

		Set<Integer> set = new HashSet<>();
//		2.show duplicated elements
		Set<Integer> set1 = list.stream().filter(n -> (set.add(n) != true)).collect(Collectors.toSet());
		System.out.println("set1 : " + set1);

		Set<Integer> set2 = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet()
				.stream().filter(n -> n.getValue() > 1).map(n -> n.getKey()).collect(Collectors.toSet());
		System.out.println("set2 : " + set2);

//		3.Find the frequency of each character in a string using Java 8 streams
		String s = "character    is currency";
		// replace removes spaces split split string into array
		Map<Object, Long> frequencyofCharacterInString = Stream.of(s.replace(" ", "").split(""))
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println("frequencyofCharacterInString : " + frequencyofCharacterInString);

//		4.Find the frequency of each element in an array or list
		Map<Object, Long> findOcc = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println("findOcc : " + findOcc);

		int[] arr = { 1, 2, 2, 3, 3, 3, 4 };
		Map<Object, Long> findOcc1 = IntStream.of(arr).boxed()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println("findOcc1 : " + findOcc1);

//		5.Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
		List<String> strings = Arrays.asList("1apple", "bananasa", "cherrys");
		String joinListOfStrings = strings.stream().map(n -> "[" + n + "]").collect(Collectors.joining(","));
		System.out.println("joinListOfStrings : " + joinListOfStrings);

//		6.Sort a given list of decimals in reverse order
		List<Double> decimals = Arrays.asList(3.5, 1.2, 4.8, 2.3, 5.1);
		List<Double> reverseDecimals = decimals.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println("reverseDecimals : " + reverseDecimals);
		List<Double> reverseDecimals1 = decimals.stream().sorted((n1, n2) -> n2.compareTo(n1)).toList();
		System.out.println("reverseDecimals1 : " + reverseDecimals1);

//		7.Print the numbers from a given list of integers that are multiples of 5
		List<Integer> multiplesOf5 = list.stream().filter(n -> n % 5 == 0).toList();
		System.out.println("multiplesOf5 : " + multiplesOf5);

//		8.Find the maximum and minimum sum average of a list of integers
		int min = list.stream().min(Comparator.naturalOrder()).get();
		list.stream().mapToInt(Integer::intValue).min();
		// i->i converting integer to int
		list.stream().mapToInt(i -> i).min();
		System.out.println("min : " + min);

		int max = list.stream().max(Comparator.naturalOrder()).get();
		list.stream().mapToInt(Integer::intValue).max();
		// i->i converting integer to int
		list.stream().mapToInt(i -> i).max();
		System.out.println("max : " + max);

		int sum = list.stream().mapToInt(Integer::intValue).sum();
		// i->i converting integer to int
		list.stream().mapToInt(i -> i).sum();
		list.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println("sum : " + sum);

		double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
		// i->i converting integer to int
		list.stream().mapToInt(i -> i).average();
		System.out.println("average : " + average);

//		9.Merge two unsorted arrays into a single sorted array using Java 8 streams

		int[] array1 = { 3, 1, 4, 5, 2 };
		int[] array2 = { 8, 2, 7, 6, 9 };

		int[] sortedArray = IntStream.concat(IntStream.of(array1), IntStream.of(array2)).sorted().toArray();
		System.out.println("sortedArray : " + Arrays.toString(sortedArray));

		List<Integer> list1 = Arrays.asList(3, 1, 4, 5, 1, 2);
		List<Integer> list2 = Arrays.asList(8, 2, 7, 6, 4);
		List<Integer> list3 = new ArrayList<>();

		list3.addAll(list1);
		list3.addAll(list2);
		List<Integer> mergedSortedList1 = list3.stream().sorted().collect(Collectors.toList());
		System.out.println("mergedSortedList1 : " + mergedSortedList1);

		// Merge and sort the lists using Stream API
		List<Integer> mergedSortedList = Stream.concat(list1.stream(), list2.stream()) // Merge lists
				.sorted() // Sort the stream
				.collect(Collectors.toList());
		System.out.println("mergedSortedList : " + mergedSortedList);

//		10.Merge two unsorted arrays into a single sorted array without duplicates
		int[] distinctSortedArray = IntStream.concat(IntStream.of(array1), IntStream.of(array2)).sorted().distinct()
				.toArray();
		System.out.println("distinctSortedArray : " + Arrays.toString(distinctSortedArray));

//		11.Get the three maximum and three minimum numbers from a given list of integers
		List<Integer> minThree = list.stream().sorted().distinct().limit(3).toList();
		System.out.println("minThree : " + minThree);

		List<Integer> maxThree = list.stream().sorted(Comparator.reverseOrder()).distinct().limit(3).toList();
		System.out.println("maxThree : " + maxThree);

//		12.Check if two strings are anagrams or not using Java 8 streams
//		anagram means both string should have same charcters
		String s1 = "heart";
		String s2 = "earth";

		List<Character> listA = s1.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());

		List<Character> listB = s2.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());

		Boolean anagram = listA.equals(listB);
		System.out.println(anagram);

//		13.Find the sum of all digits of a number in Java 8
//		ascii value of 1 is 49 ascii value of 0 is 48 49-48=1 thats y used c->c-'0'
		int a = 123;
		int sumOfAllDigits = String.valueOf(a).chars().map(c -> c - '0').sum();
		System.out.println(sumOfAllDigits);

		List<String> sortStringBasedOnLength = strings.stream().sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		System.out.println("sortStringBasedOnLength : " + sortStringBasedOnLength);

		List<String> sortStringBasedOnLength1 = strings.stream().sorted((str1, str2) -> str1.length() - str2.length())
				.toList();
		System.out.println("sortStringBasedOnLength : " + sortStringBasedOnLength1);

//		14.Find the second largest number in an integer array
		int secondLargest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("secondLargest : " + secondLargest);

//		15.Find the sum and average of all elements in an integer array
		int sumOfArray = IntStream.of(array1).map(n -> n).sum();
		System.out.println("sumOfArray : " + sumOfArray);

		double avgOfArray = IntStream.of(array1).map(n -> n).average().getAsDouble();
		System.out.println("avgOfArray : " + avgOfArray);

//		16.Find the common elements between two arrays
		List<Integer> commonElements = list1.stream().filter(n -> list2.contains(n)).toList();
		System.out.println("commonElements : " + commonElements);

//		17.convert int[] to List <Integer> and String to List<String>
		List<Integer> intArrToList = IntStream.of(array1).boxed().toList();
		System.out.println("intArrToList : " + intArrToList);

		String str22 = "Hello";
		List<String> strToList = Stream.of(str22.split("")).sorted(Comparator.reverseOrder()).toList();
		System.out.println("strToList : " + strToList);

//		18.Reverse each word of a string using Java 8 streams
		List<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "gava", "pomegranate"));
		fruits.add("date");
		fruits.add("strawberry");

		List<String> reverseEachWord = fruits.stream().map(word -> new StringBuilder(word).reverse().toString())
				.toList();
		System.out.println("reverseEachWord : " + reverseEachWord);

		String input = "Java 8 Streams are powerful";
		String reverseEachWordInString = Stream.of(input.split(" "))
				.map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
		System.out.println("reverseEachWordInString : " + reverseEachWordInString);

//		19.Write a Java 8 program to reverse an integer array.
		List<Integer> reverseIntArray = IntStream.of(array1).boxed().collect(Collectors.toCollection(ArrayList::new));
		Collections.reverse(reverseIntArray);
		Collections.reverse(list);
		System.out.println("reverseIntArray : "+list);
		System.out.println("reverseIntArray : "+reverseIntArray);
		
//		20.Write a Java 8 program to print the first 10 even numbers.
		List<Integer> findFirst10Even =	IntStream.range(1, 21).boxed().filter(n->n%2==0).toList();
		System.out.println("findFirst10Even : "+findFirst10Even);
		
//		21.Find the most repeated element in an array
		int mostRepeatedElement = list.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()))
					 .entrySet()
					 .stream()
					 .max(Comparator.comparingLong(n->n.getValue()))
					 .map(n->n.getKey()).get();
		System.out.println("mostRepeatedElement : "+mostRepeatedElement);
		
//		22.Check if a string is a palindrome using Java 8 streams
		String palli = "woow";
		boolean checkPalindrome = palli.equals(new StringBuilder(palli).reverse().toString());
		System.out.println(checkPalindrome);
		
//		23.Find strings in a list that start with a number
		List<String> startsWithNum = strings.stream().filter(n->n.substring(0,1).matches("[0-9]")).toList();
		System.out.println("startsWithNum : "+startsWithNum);
		
//		24.Print duplicate characters in a string
		String dupString = "HelloH";

		LinkedHashMap<Object, Object> duplicateChar =   Stream.of(dupString.split("")).collect(Collectors.groupingBy(n->n, Collectors.counting()))
									  .entrySet()
									  .stream()
									  .filter(entry->entry.getValue()>1)
									  .collect(Collectors.toMap(n->n.getKey(), n->n.getValue(),(asd,b)->asd, LinkedHashMap::new));
		System.out.println("dupString : "+dupString);
		
//		25.Find the first repeated character in a string
		String repeatedString = "HelloH";
		String firstRepeatedChar = Stream.of(repeatedString.split("")).collect(Collectors.groupingBy(n->n,LinkedHashMap::new, Collectors.counting()))
							.entrySet()
							.stream()
							.filter(entry->entry.getValue()>1)
							.findFirst()
							.map(n->n.getKey())
							.orElse("No repeated character");
		System.out.println("firstRepeatedChar : "+firstRepeatedChar);
		
//		26.Find the first non-repeated character in a string
		String nonRepeatedString = "HelloH";
		String firstNonRepeatedChar = Stream.of(nonRepeatedString.split("")).collect(Collectors.groupingBy(n->n,LinkedHashMap::new, Collectors.counting()))
							.entrySet()
							.stream()
							.filter(entry->entry.getValue()==1)
							.findFirst()
							.map(n->n.getKey())
							.orElse("No non repeated character");
		System.out.println("firstNonRepeatedChar : "+firstNonRepeatedChar);

	}

}
