package concepts.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PracticedSets {
	
	public static void main(String args[]) {
		
		/*
		 * Set Interface in Java is present in java.util package. It extends the
		 * Collection interface. It represents the unordered set of elements which
		 * doesn't allow us to store the duplicate items. We can store at most one null
		 * value in Set. Set is implemented by HashSet, LinkedHashSet, and TreeSet.
		 */
		
		/*
		 * HashSet uses Hash table for storing the elements(hashing mechanism) and extends the AbstractSet
		 * and implements the set interface
		 * It contains unique elements
		 * It allows null value
		 * It is non synchronized
		 * It doesn't maintain insertion order. here elements are stored on their hashcode basis
		 * It is best for search operation
		 * initial capacity:16
		 * It internally uses the HashMap for storing of elements
		 */
		HashSet<String> integerHashSet = new HashSet<String>(100); //100 is the capacity
		integerHashSet.add("abc");
		integerHashSet.add("ab");
		integerHashSet.add("a");
		String[] strs = {"bc","cd","de","ef","fg"};
		integerHashSet.addAll(integerHashSet); //adds all the hashset values againf not present
		integerHashSet.addAll(Arrays.asList(strs));// adds all the list of strings into it.
		System.out.println("set of elements");
		for(String s:integerHashSet) {
			System.out.println(s);
		}
		System.out.println("conatins ab : "+integerHashSet.contains("ab"));
		System.out.println("conatins all the elements of strs array"+integerHashSet.containsAll(Arrays.asList(strs)));
		System.out.println("equals : "+integerHashSet.equals(integerHashSet));
		System.out.println("is empty ? "+integerHashSet.isEmpty());
		System.out.println("iterator");
		Iterator itr = integerHashSet.iterator();
		itr.forEachRemaining(System.out::println);
		System.out.println("remove ab from set: "+integerHashSet.remove("ab"));
		System.out.println("remove all the ele of strs : "+integerHashSet.removeAll(Arrays.asList(strs)));
		System.out.println("remove if ele=a?"+integerHashSet.removeIf(ele->ele.equals("a")));
		integerHashSet.add("abcd");
		System.out.println("retain all: "+integerHashSet.retainAll(Arrays.asList("abc")));
		System.out.println("to array: "+integerHashSet.toArray()[0]);
		integerHashSet.forEach(a->System.out.println(a));
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * LinkedHashSet extends the HashSet class and implements set interface It
		 * maintains insertion order for storing the elements
		 * 
		 * It extends the HashSet class
		 * It is same like Hashset and but it maintains insertion order
		 */
		
		System.out.println("--------LinkedHashSet----------");
		LinkedHashSet<String> integerLinkedHashSet = new LinkedHashSet<String>();
		integerLinkedHashSet.add("abc");
		integerLinkedHashSet.add("ab");
		integerLinkedHashSet.add("a");
		integerLinkedHashSet.addAll(integerLinkedHashSet); //adds all the hashset values againf not present
		integerLinkedHashSet.addAll(Arrays.asList(strs));// adds all the list of strings into it.
		System.out.println("set of elements");
		for(String s:integerLinkedHashSet) {
			System.out.println(s);
		}
		System.out.println("conatins ab : "+integerLinkedHashSet.contains("ab"));
		System.out.println("conatins all the elements of strs array"+integerLinkedHashSet.containsAll(Arrays.asList(strs)));
		System.out.println("equals : "+integerLinkedHashSet.equals(integerLinkedHashSet));
		System.out.println("is empty ? "+integerLinkedHashSet.isEmpty());
		System.out.println("iterator");
		Iterator itr1 = integerLinkedHashSet.iterator();
		itr1.forEachRemaining(System.out::println);
		System.out.println("remove ab from set: "+integerLinkedHashSet.remove("ab"));
		System.out.println("remove all the ele of strs : "+integerLinkedHashSet.removeAll(Arrays.asList(strs)));
		System.out.println("remove if ele=a?"+integerLinkedHashSet.removeIf(ele->ele.equals("a")));
		integerLinkedHashSet.add("abcd");
		System.out.println("retain all: "+integerLinkedHashSet.retainAll(Arrays.asList("abc")));
		System.out.println("to array: "+integerLinkedHashSet.toArray()[0]);
		integerLinkedHashSet.forEach(a->System.out.println(a));

		
		/*
		 * SortedSet Interface extends the Set Interface and allows us to store the
		 * elements in an ascending order and allows additional methods Tree set
		 * implements the SortedSet, the access and retrieval time of TreeSet is quite
		 * fast.
		 * 
		 * It access and retrieve the elements fast
		 * 
		 * It doesn't allow null
		 * 
		 * It uses naviagable Map for operations
		 * 
		 * It is implemented using binary search tree
		 * operation like remove, search and add will take O(logN)
		 * 
		 */
		
		TreeSet<String> s = new TreeSet<String>(new StringComparator());
		System.out.println("-----TreeSet-----");
	    s.add("hanu");
	    s.add("hanuma");
	    s.add("hanuman");
	    s.add("hanumanKumar");
	    
	    s.add("hello");
	    s.addAll(Arrays.asList(strs));
	    s.forEach(a->System.out.println(a));
	    System.out.println("size : "+s.size());
	    System.out.println("f is ceiling of : "+s.ceiling("f")); //ef(ef<=f)
	    System.out.println("first ele in the set is: "+s.first()); // returns the first ele in the set
	    System.out.println("f is floor of : "+s.floor("f")); //fg(fg>=f)
	    System.out.println("f is higher than : "+s.higher("f"));//(ef<f) strict ceiling
	    System.out.println("last ele in the set is: "+s.last());//returns the last ele of the set
	    System.out.println("f is lower than "+s.lower("f"));//fg(fg>f) strict floor
	    System.out.println("pollFirst : "+s.pollFirst());// retrieves and removes the first element
	    System.out.println("pollLast : "+s.pollLast());// retrieves and remove the last element
	    System.out.println("returns the comaparator that we are using :"+s.comparator());
	    System.out.println("descenting set : "+s.descendingSet());
	    System.out.println("descenting iterator :"); 
	    Iterator descendingItr = s.descendingIterator();
	    descendingItr.forEachRemaining(System.out::println);
	    System.out.println("head set sorted : "+s.headSet("fg")); //strict set of elememts > fg
	    System.out.println("head set naviagable : "+s.headSet("fg", true)); // loose >= f and it support to include the element if present
	    System.out.println("subset of z-a sorted : "+s.subSet("z", "a"));// strict - it wont allow below operation
	    System.out.println("subset of z-a naviagable : "+s.subSet("z", true, "a", false));// include ele based on flag if ele present
	    System.out.println("tail set sorted: "+s.tailSet("fg")); //strict set of elements <= fg
	    System.out.println("tail set navigable : "+ s.tailSet("fg", true)); // set of elements < fg if false else <= fg 
	}

}

class StringComparator implements Comparator<String>{
	
	 @Override
     public int compare(String s1, String s2) {
         return s2.trim().compareTo(s1.trim());
     }
}
