package concepts.collections;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Stack;
import java.util.Vector;

public class PracticedVectorAndStack {
	
	public static void main(String args[]) {
		
		Vector<String> vector = new Vector<>();
		vector.add("first");
		vector.add(0, "first1");
		vector.addAll(Arrays.asList("second","third"));
		vector.addAll(4, Arrays.asList("four","five"));
		vector.addElement("six");
		vector.capacity();
		
		vector.clone();
		
		vector.contains("first");
		
		vector.containsAll(Arrays.asList("second","third"));
		String strs[] = new String[vector.size()];
		vector.copyInto(strs); // copy vector elements to array
		System.out.println(strs[1]);
		System.out.println("element at 0 : "+vector.elementAt(0));//returns the element at index
		Enumeration<String> enums =  vector.elements();
		while(enums.hasMoreElements()) {
			System.out.println(enums.nextElement());
		}
		System.out.println("first element  : "+vector.firstElement());
		System.out.println("lastElement  : "+vector.lastElement());

		System.out.println("subList"+vector.subList(0, vector.size()));
		
		ListIterator listitr = vector.listIterator(2);
		listitr.add("nine");;
		listitr.forEachRemaining(System.out::println);
		
		
		vector.insertElementAt("three", 4);
		//vector.setElementAt("seven", 7);
		System.out.println(vector.get(7));
		ListIterator listitr1 = vector.listIterator(2);
		listitr1.forEachRemaining(System.out::println);
		vector.setSize(100);
		
		
		
		vector.clear();
		//rest all are common methods of arraylist
		
		Stack<String> stack = new Stack<>();
		stack.empty(); // true
		stack.push("first");
		stack.push("second");
		stack.push("third");
		stack.push("fourth");
		stack.push("fifth");
		Spliterator splitItr =  stack.spliterator();
		splitItr.tryAdvance(str -> System.out.println(str));
		splitItr.forEachRemaining(System.out::println);
		System.out.println("splitItr.characteristics() : "+splitItr.characteristics());
		System.out.println("splitItr.estimateSize() : "+splitItr.estimateSize());
		System.out.println( "splitItr.getExactSizeIfKnown() : "+ splitItr.getExactSizeIfKnown());
		Spliterator splitItr1 =  stack.spliterator();
		Spliterator splitItr2 = splitItr1.trySplit();
		System.out.println("first half: ");
		splitItr1.forEachRemaining(System.out::println);
		System.out.println("second half: ");		
		splitItr2.forEachRemaining(System.out::println);
		
		
		System.out.println();
		System.out.println(stack);
		System.out.println(stack.pop()); // fifth because it is on the top of the stack
		System.out.println(stack.search("first")); //distance from the top of the stack 4 place goes to first
		System.out.println(stack.peek()); // returns the top element of the stack
	}

}
