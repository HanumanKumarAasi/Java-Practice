package interview.preparation.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorVsComparable {
	
	public static void main(String args[]) {
		ArrayList<Integer> al = new ArrayList<>();
        al.add(74);
        al.add(22);
        al.add(67);
        al.add(86);
        al.add(95);
        al.add(49);
        al.add(31);
        al.add(53);
        al.add(10);
        
        ComparatorVsComparableImpl impl1 = new ComparatorVsComparableImpl();
        impl1.sortIntegerToDescendingOrderBasedOnLastDigit(al);
        
        System.out.println(al);
        
        ArrayList<Student> students = new ArrayList<>();
        
        students.add(new Student("hanuma", 25));
        students.add(new Student("kushith", 8));
        students.add(new Student("geeshu",6));
        students.add(new Student("suneetha",49));
        students.add(new Student("ramu",50));
        
        Collections.sort(students);
        
        //The toString method will be internally invoker
        System.out.println(students);
        
        
		
	}

}

class ComparatorVsComparableImpl{
	
	public void sortIntegerToDescendingOrderBasedOnLastDigit(ArrayList<Integer> al) {
		//using comparator we can pass customizable sorting mechanism
		//here we are sorting To DescendingOrder Based On LastDigit
		
		
		Comparator<Integer> comparator = new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1%10<o2%10) {
					return 1; //In this compare method when we return 1 this swap both the values.
				}
				return -1;
			}
			
		};
		Collections.sort(al, comparator);
	}
	
}

class Student implements Comparable<Student>{
	
	String name;
	
	int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//this is the compareTo method that we are using inorder to
	
	//based on their age
	/*
	 * @Override public int compareTo(Student that) {
	 * 
	 * if(this.age>that.age) { return 1; }
	 * 
	 * return -1; }
	 */
	
	//based on their first char in String
	@Override
	public int compareTo(Student that) {
		// TODO Auto-generated method stub
		
		if(this.name.charAt(0)<that.name.charAt(0)) {
			return 1;
		}
		return -1;
	}

	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	
	
	
	
	
}


