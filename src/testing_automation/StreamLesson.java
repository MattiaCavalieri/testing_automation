package testing_automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

import com.google.common.collect.Streams;

public class StreamLesson {

	public static void regular() {
		// Count the number of names starting with alphabet A in a list
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anselmo");
		names.add("Alberto");
		names.add("Francesco");
		names.add("Tommaso");
		names.add("Adam");
		names.add("Davide");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actualName = names.get(i);
			if (actualName.startsWith("A")) {
				count++;
			}

		}
		System.out.println(count);
	}

	// using streams
	public static void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anselmo");
		names.add("Alberto");
		names.add("Francesco");
		names.add("Tom");
		names.add("Adam");
		names.add("Dave");

		// there is no life for intermediate operation if there is no terminal operation
		Long count = names.stream().filter(x -> x.startsWith("A")).count();
		System.out.println(count);

		// create an ArrayList using Stream
		Stream.of("Anselmo", "Alberto", "Francesco", "Tommaso", "Adam", "Davide").filter(x -> x.startsWith("A"));

		// print all the names in the ArrayList whose length are greater than 4
		names.stream().filter(x -> x.length() > 4).forEach(x -> System.out.println(x));

		// print only the first 2 results
		names.stream().filter(x -> x.length() > 4).limit(1).forEach(x -> System.out.println(x));

	}

	public static void streamMap() {
		// print names wihch have the last letter "o" with Uppercase
		Stream.of("Anselmo", "Alberto", "Francesco", "Tommaso", "Adam", "Davide").filter(x -> x.endsWith("o"))
				.map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));

		// print names wich have first letter as a with uppercase and sorted
		List<String> names = Arrays.asList("Anselmo", "Alberto", "Francesco", "Tommaso", "Adam", "Davide");
		names.stream().filter(x -> x.startsWith("A")).sorted().map(x -> x.toUpperCase())
				.forEach(x -> System.out.println(x));

		// merge two arrayList
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Marco");
		names2.add("Mattia");
		names2.add("Venanzio");
		names2.add("Carlo");
		names2.add("Luca");
		names2.add("Federico");

		Stream<String> myStreaam = Streams.concat(names.stream(), names2.stream());
		// myStreaam.forEach(x -> System.out.println(x));

		// verify if "Adam" in the stream or not
		boolean flag = myStreaam.anyMatch(s -> s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	public static void streamCollect() {
		// list --> perform some operation --> collect back to new list
		List<String> myNewList = Stream.of("Anselmo", "Alberto", "Francesco", "Tommaso", "Adam", "Davide")
				.filter(x -> x.endsWith("o")).map(x -> x.toUpperCase()).collect(Collectors.toList());
		myNewList.get(0);
		System.out.println(myNewList.get(0));

		// Assignment: print unique number from this array
		// sort the array
		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 7, 9, 5, 4);
		values.stream().distinct().forEach(x -> System.out.println(x));
		List<Integer> newValues = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newValues.get(2));
	}

	public static void main(String[] args) {
		regular();
		System.out.println();
		streamFilter();
		System.out.println();
		streamMap();
		System.out.println();
		streamCollect();
	}

}
