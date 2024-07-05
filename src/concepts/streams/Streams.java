package concepts.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	private static List<Integer> square() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> temps = nums.stream().map(x -> x * x).collect(Collectors.toList());

		return temps;
	}

	private static Stream<Integer> map() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

		return nums.stream().map(x -> x * x);
	}

	private static Stream<Integer> filter() {
		return square().stream().filter(x -> x % 2 == 0);
	}

	private static Stream<Integer> sorted() {
		return square().stream().sorted(Comparator.reverseOrder());
	}

	public static void main(String args[]) {
		
		System.out.println("map");
		map().forEach(x -> System.out.println(x + " "));
		System.out.println("sort");
		sorted().forEach(x -> System.out.println(x + " "));
		System.out.println("filter");
		filter().forEach(x -> System.out.println(x + " "));
		
		
		
		Person person1 = new Person("Jim",20,"Male");
		Person person2 = new Person("Bob",15,"Male");
		Person person3 = new Person("Tim",21,"Male");
		Person person4 = new Person("Julie",16,"Male");
		
		List<Person> persons = Arrays.asList(person1,person2,person3,person4);
		persons.stream().filter(person->person.getAge()<18).map(person->person.getName()).collect(Collectors.toList()).forEach(name -> System.out.println("Minor person Name is : "+name));;
		persons.stream().filter(person->person.getAge()>=18).map(person->person.getName()).forEach(name -> System.out.println("Major person Name is : "+name));;
		
		
		String name="Hanuman";
		List<Character> ch = name.chars()
				.mapToObj(c->(char)c)
				.collect(Collectors.toMap(Function.identity(), v->1,Integer::sum,LinkedHashMap<Character, Integer>::new))
				.entrySet()
				.stream()
				.filter(entry->entry.getValue()>1)
				.map(Map.Entry::getKey).collect(Collectors.toList());
		
		System.out.println(ch.size());
		
		LinkedHashMap<Character, Integer> map = name.chars()
				.mapToObj(c->(char)c)
				.collect(Collectors.toMap(Function.identity(), v->1,Integer::sum,LinkedHashMap<Character, Integer>::new));
		
		System.out.println("map");
		for(Character ch1:map.keySet()) {
			System.out.println(ch1+"->"+map.get(ch1));
		}
		
		
		List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
		int sum = integers.stream().reduce(0,(out,i)->out+i);
		System.out.println(sum/10);
		
		//FlatMap
		
		List<Integer> even = Arrays.asList(2,4,6,8);
		List<Integer> odd = Arrays.asList(1,3,5,7,9);
		List<Integer> primes = Arrays.asList(2,3,5,7,11);
		
		List<Integer> numbers = Stream.of(even,odd,primes).flatMap(list->list.stream()).collect(Collectors.toList());
		
		System.out.println("sorted : "+numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));	
			
		
		//peek()
		
		List<Integer> nums = Arrays.asList(1,2,3,4,2,4,2,1,5,6);
		nums.stream().map(n->n*n).peek(value -> System.out.println("value : "+value)).filter(n->n%2==0).collect(Collectors.toList());
		
		System.out.println("skip : "+nums.stream().skip(10).count());;
		int arr[] = {1,2,3,4,2,4,2,1,5,6};
		System.out.println("distinct : "+Stream.of(1,2,3,4,2,4,2,1,5,6).distinct().count());;
		
		Stream.of(1,2,3,4,2,4,2,1,5,6).parallel().forEach(System.out::println);
		System.out.println("------------------------");
		nums.parallelStream().forEach(System.out::println);
		
		
		
	}
}

class Person{
	String name;
	int age;
	String gender;	
	
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}