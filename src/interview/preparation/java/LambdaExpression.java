package interview.preparation.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class LambdaExpression {

	String hanuma = "hanuma";
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1. Lambda Expression with Parameters
		 */ LambdaExpressionImpl implObj = new LambdaExpressionImpl();
		System.out.println(implObj.helloFunc("hanuma"));

		// passing lambda expression as a reference for Functional interface
		String res = implObj.helloFunc((hanuma) -> {
			hanuma = "hanuman kumar";// I'm setting the instance variable inside the lambda
			return "hello " + hanuma;
		});

		System.out.println("result of lambda expression refernce of FI : " + res);

		/* 2. Lambda Expression with Collections */
		// using lists
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
		
		al.forEach(null);

		System.out.println("Before : " + al);
		Collections.sort(al, (o1, o2) -> (o1 < o2) ? 1 : -1);
		System.out.println("After : " + al);

		// using Maps -> it will sort based on the keys
		TreeMap<Integer, String> m = new TreeMap<Integer, String>((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
		m.put(1, "Apple");
		m.put(4, "Mango");
		m.put(5, "Orange");
		m.put(2, "Banana");
		m.put(3, "Grapes");
		System.out.println("Elements of the TreeMap " + "after sorting are : " + m);

		// Pass a reverse comparator to TreeSet() via a lambda expression
		TreeSet<String> ts = new TreeSet<String>((aStr, bStr) -> bStr.compareTo(aStr));

		// Add elements to the Treeset
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("E");
		ts.add("F");
		ts.add("G");

		System.out.println(ts);

		/*
		 * 3. Lambda Expression Variable Capturing
		 */

		// we can't use local variables in the lambda expression
		// the instance and static variables are allowed

		String strr = "from hyderabad";
		String LambdaExpressionVariableCapturing = implObj.helloFunc((hanuma) -> {
			hanuma = "hanuman kumar";// I'm setting the instance variable inside the lambda
			return "hello " + hanuma + " " + strr;
		});

		System.out.println(LambdaExpressionVariableCapturing);

		// hanuma = "hanuma"; I can modify this instance variable outside the lambda but
		// local variable can't be modified inside/outside the lambda

		/*
		 * 4. How to Create Thread using Lambda Expressions in Java?
		 */

		// Creating Lambda expression for run() method in
		// functional interface "Runnable"
		Runnable myThread = () -> {

			// Used to set custom name to the current thread
			System.out.println(Thread.currentThread().getName() + " is running");
		};

		// Instantiating Thread class by passing Runnable
		// reference to Thread constructor
		Thread run = new Thread(myThread);
		run.setName("myThread");
		// Starting the thread
		run.start();
		
		
		/* 5. converting list to HashMap */
		
		List<ListItems> list = new ArrayList<ListItems>();
		 
        // add the member of list
        list.add(new ListItems(1, "I"));
        list.add(new ListItems(2, "Love"));
        list.add(new ListItems(3, "Geeks"));
        list.add(new ListItems(4, "For"));
        list.add(new ListItems(5, "Geeks"));
 
        // Map which will store the list items
        Map<Integer, String> map = new HashMap<>();
 
        // for (ListItems n : list) { map.put(n.getkey(),
        // n.getvalue()); }
        // the below lambda  performs the same task as the
        // above given for loop will do
        // put the list items in the Map
        list.forEach(
            (n) -> { 
            	map.put(n.getkey(), n.getvalue()); 
            	});
 
        // Printing the given map
        System.out.println("Map : " + map);
        
        
        
		
		

	}
	
	/* 6. To check does String contains only Alphabets */
    // To check String for only Alphabets
	
	public static boolean isStringOnlyAlphabet(String str){
        return (
            (str != null) && (!str.equals(""))
            && (str.chars().allMatch(Character::isLetter)));
    }

}

class LambdaExpressionImpl {

	public String helloFunc(String str) {
		// Implementing functional interface method through lambda expression as shown
		// below.
		HelloFunctionalInterface helloFL = (name) -> {
			return "hello " + name;
		};

		// calling the interface method that returns string
		return helloFL.hello(str);
	}

	// Also we can pass lambda expression as a reference for functional interface in
	// the methods

	public String helloFunc(HelloFunctionalInterface helloFL) {
		return helloFL.hello("hanuma");
	}

}

@FunctionalInterface
interface HelloFunctionalInterface {

	String hello(String name);
}

class ListItems {
	 
    // key will act as an id of the value
    private Integer key;
 
    // value will be the value of the above key
    private String value;
 
    // create constructor for reference
    public ListItems(Integer id, String name)
    {
 
        // assigning the value of key and value
        this.key = id;
        this.value = name;
    }
 
    // return private variable key
    public Integer getkey() { return key; }
 
    // return private variable name
    public String getvalue() { return value; }
}
