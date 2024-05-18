package concepts.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Stack;
import java.util.Vector;

public class PracticedLists {
	
	public static void main(String args[]) {
		
		//Below all are the implementation classes of List interface
		
		/*
		 * ArrayList is a list of objects that uses dynamic array for storing 
		 * the elements and it maintains insertion order and is non-synchronized
		 * 
		 * it extends the abstract class
		 * 
		 * it can contains duplicate elements and allows us random access.
		 * 
		 * but manipulation in arraylist is slower than LinkedList, because lots of
		 * shifting of elements occurs if any any element is removed from the list
		 * 
		 * we can pass on the size while initializing => Arraylist
		 */		
		List<Integer> integerArrayList = new ArrayList<Integer>(100); //100 iis the initial capacity
		System.out.println("<----------ArrayList---------->");
		integerArrayList.add(1); //adding the element to the list add(index,ele) is another way
		integerArrayList.add(1,2);
		integerArrayList.get(1); //getting the element from the list using index=1
		integerArrayList.addAll(integerArrayList); // adding the collection of ele's through addAll
		integerArrayList.addAll(3, integerArrayList); //adding all at specified index
		integerArrayList.isEmpty(); // checks whether the list is empty or not
		integerArrayList.contains(1); // checks whether the given obj is there or not
		integerArrayList.containsAll(integerArrayList); //checks whether all the elements present or not
		integerArrayList.equals(integerArrayList); //checks both the lists are equals or not wrt the values
		integerArrayList.forEach(a -> {
			System.out.println(a);
		});
		integerArrayList.indexOf(1); //returns the index of the first occurence
		integerArrayList.lastIndexOf(1); //returns the index of the last occurence
		System.out.println("using iterator in ArrayList");
		Iterator itr=integerArrayList.iterator();//getting the Iterator  
		  while(itr.hasNext()){//check if iterator has the elements  
		   System.out.println(itr.next());//printing the element and move to next  
		  }  
		System.out.println("using List iterator in ArrayList");
		ListIterator listItr  = integerArrayList.listIterator(1);
		while(listItr.hasPrevious()) {
			System.out.println(listItr.previous());
		}
		integerArrayList.remove(0);
		integerArrayList.remove(1);
		int[] a = {1,2,3};
		integerArrayList.removeAll(Arrays.asList(a));
		integerArrayList.removeIf(b->b>1); //using lambda expression for conditioning
		integerArrayList.replaceAll(c -> c+2); // it will all the ele's with ele+2
		integerArrayList.retainAll(Arrays.asList(a)); // it will remove all the elements except the list that we have pass into it

		integerArrayList.add(0, 10); // updates the existing value with new
		
		integerArrayList.set(0, 100); // updates the existing value with new
		integerArrayList.size(); // return the size of the list
		Collections.sort(integerArrayList); // sort the list into the ascending order
		Spliterator splitr = integerArrayList.spliterator(); //splitting and iteration
		System.out.println("using split iterator in ArrayList");
		splitr.forEachRemaining(System.out::println);
		
		integerArrayList.subList(0, 0);//start index, end index
		integerArrayList.toArray(); //returns an array
		integerArrayList.toString();
		integerArrayList.clear(); // it will clear all the ele's from the list
		
		/*
		 * LinkedList is a list of objects that uses doubly linked list for storing 
		 * the elements and it maintains insertion order and is non-synchronized
		 * In LinkedList, the manipulation is fast because no shifting is required.
		 */	
		
		LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
		System.out.println("<----------LinkedList---------->");
		
		//below are the some additional methods it is going to offer.
		integerLinkedList.add(1);
		integerLinkedList.addFirst(2);
		integerLinkedList.addLast(3);
		integerLinkedList.getFirst();
		integerLinkedList.getLast();
		integerLinkedList.clone(); //clones the linked list
		Iterator reverseitr = integerLinkedList.descendingIterator(); //reverseorder iterator
		reverseitr.forEachRemaining(System.out::println);
		System.out.println(integerLinkedList.pop()); //return and remove first ele if exists else NoSuchElement Exception
		System.out.println(integerLinkedList.peek()); //return head else null if empty list
		System.out.println(integerLinkedList.peekFirst()); //return first ele if exists else null
		System.out.println(integerLinkedList.peekLast()); //return last ele if exists else null
		System.out.println(integerLinkedList.pollLast()); //return and remove last ele if exists else null
		System.out.println(integerLinkedList.pollFirst()); //return and remove first ele if exists else null
		System.out.println(integerLinkedList.poll()); //return and remove first ele if exists else null
		integerLinkedList.offer(1);
		integerLinkedList.offerFirst(3);
		integerLinkedList.offerLast(2);
		System.out.println(integerLinkedList.element()); //return first ele if exists else NoSuchElement exception
		integerLinkedList.remove(); //remove head
		integerLinkedList.removeFirst();// remove first ele
		integerLinkedList.removeFirstOccurrence(1);// remove first occurence of ele
		integerLinkedList.removeLast();// remove last ele
		integerLinkedList.removeLastOccurrence(1);// remove last occurence of ele
		Collections.unmodifiableList(integerLinkedList);
		/*
		 * Vector uses a dynamic array to store the data elements. It is similar to
		 * ArrayList. However, It is synchronized and contains many methods that are not
		 * the part of Collection framework.
		 */
		
		List<Integer> integerVector = new Vector<Integer>();
		
		/*
		 * The stack is the subclass of Vector. It implements the last-in-first-out data
		 * structure, i.e., Stack. The stack contains all of the methods of Vector class
		 * and also provides its methods like boolean push(), boolean peek(), boolean
		 * push(object o), which defines its properties.
		 */
		
		List<Integer> integerStack = new Stack<Integer>(); 
		
		
		 
	}
	
	
}
