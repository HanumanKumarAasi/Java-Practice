package concepts.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author haasi
 *
 */
class Student implements Comparable<Student> {
	public int age;
	public String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int compareTo(Student person) {
		return person.name.compareTo(name);

	}
	
	
	

}

public class PracticedComparableAndComparator {

	/*
	 * The comparable is used for single sorting sequence that can be defined in the
	 * Comparable object class like shown above
	 */

	/*
	 * The comparator is used to define as many comparator with respect to the
	 * different fields by implementing the comparator interface and using its
	 * compare method like shown below.
	 */

	public static void main(String args[]) {
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(18, "Viru"));
		al.add(new Student(21, "Saurav"));
		al.add(new Student(24, "Mukesh"));
		al.add(new Student(17, "Tahir"));

		// Name Descending order
		System.out.println("sorting wrt the comparable object interface");
		Collections.sort(al);
		for (Student s : al) {
			System.out.println(s.name);
		}

		System.out.println("sorting wrt the comparator reverse order method");
		Collections.sort(al, Comparator.reverseOrder());
		for (Student s : al) {
			System.out.println(s.name);
		}

		// Age Ascending order
		System.out.println("sorting wrt the Age comparator of comparator interface");
		Collections.sort(al, new AgeComparator());
		for (Student s : al) {
			System.out.println(s.name + " with age " + s.age);
		}

		// Name Ascending order
		System.out.println("sorting wrt the Name comparator of comparator interface");
		Collections.sort(al, new NameComparator());
		for (Student s : al) {
			System.out.println(s.name + " with age " + s.age);
		}
		
		//Comparator comparing method but default it support ascending order
		
		
		Comparator<Student> ageComparator=Comparator.comparing(Student::getAge);  
		Comparator<Student> nameComparator=Comparator.comparing(Student::getName);  
		System.out.println("sorting wrt the Age comparator of comparator interface");
		Collections.sort(al, ageComparator);
		for (Student s : al) {
			System.out.println(s.name + " with age " + s.age);
		}
		System.out.println("sorting wrt the Name comparator of comparator interface");
		Collections.sort(al, nameComparator);
		for (Student s : al) {
			System.out.println(s.name + " with age " + s.age);
		}
		
		Comparator<Student> nullsLast=Comparator.comparing(Student::getName,Comparator.nullsLast(String::compareTo));
		Comparator<Student> nullsFirst=Comparator.comparing(Student::getName,Comparator.nullsFirst(String::compareTo));  

		Comparator<Student> comparingInt=Comparator.comparingInt(Student::getAge);
		Comparator<Student> comparingDouble=Comparator.comparingDouble(Student::getAge);
		Comparator<Student> comparingLong=Comparator.comparingLong(Student::getAge);
		Collections.sort(al, comparingInt);
		for (Student s : al) {
			System.out.println(" with comparingInt age " + s.age);
		}
		
		Collections.sort(al, comparingDouble);
		for (Student s : al) {
			System.out.println(" with comparingDouble age " + s.age);
		}
		
		Collections.sort(al, comparingLong);
		for (Student s : al) {
			System.out.println(" with comparingLong age " + s.age);
		}
		
		Collections.sort(al, Comparator.naturalOrder());
		for (Student s : al) {
			System.out.println(" with naturalOrder " + s.age);
		}
		
		System.getProperties();
	}

}

//Non generic old-style (generic - Comparator<Student>)
class AgeComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		if (s1.age > s2.age) {
			return 1;
		} else if (s1.age < s2.age) {
			return -1;
		}

		return 0;
	}

}

//Generic style
class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}

}
