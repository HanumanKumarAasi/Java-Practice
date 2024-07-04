package concepts.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PracticedQueues {
	
	public static void main(String args[]) {
		
		/*
		 * Below all are the implementation classes of Queue interface It follows first
		 * in first out order. It can be defined as an ordered list that is used to hold
		 * the elements which are about to be processed.
		 * 
		 * Here the insertion of ele occurs at the end and removal of ele coccurs at the
		 * the beginning of the list.
		 * 
		 * this Queue interface is by the concreate class priorityQueue and LinkedList(which
		 * implements the Deque.
		 * 
		 * Implementations done by these classes are not thread safe. If it is required to 
		 * have a thread safe implementation, PriorityBlockingQueue is an available option.
		 *
		 *NullPointerException is raised, if any null operation is done on the BlockingQueues.
		 *
		 *Queues that are present in the util package are known as Unbounded Queues.
		 *
		 *
		 *Queues that are present in the util.concurrent package are known as bounded Queues.
		 *
		 *deques support element insertion and removal at both ends.
		 *
		 */
		System.out.println("<----------------priority queue---------------->");
		/*
		 * The PriorityQueue class implements the Queue interface. It holds the elements
		 * or objects which are to be processed by their priorities. PriorityQueue
		 * doesn't allow null values to be stored in the queue.
		 * 
		 * 
		 * 
		 * 
		 */
		PriorityQueue<String> integerPriorityQueue = new PriorityQueue<String>();
		
		//integerPriorityQueue.add(null); //throws NPE exception
		integerPriorityQueue.add("Hanu");
		integerPriorityQueue.addAll(Arrays.asList("hanuma","hanuman","hanumankumar","abc","abcd","adbc"));
		
		
		
		System.out.println("head of the queue : "+integerPriorityQueue.element());
		System.out.println("head of the queue : "+integerPriorityQueue.peek()); //returns null if no elements exist in queue
		System.out.println("head removed : "+integerPriorityQueue.remove()); 
		System.out.println("head removed with poll : "+ integerPriorityQueue.poll());//return null if no ele exists in queue
		System.out.println("Inserting the element :"+integerPriorityQueue.offer("Hanu"));
		integerPriorityQueue.offer("hanumankumar");
		Iterator itr = integerPriorityQueue.iterator();

		System.out.println("PQ started");
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("PQ end");
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Deque interface extends the Queue interface. In Deque, we can remove and add
		 * the elements from both the side. Deque stands for a double-ended queue which
		 * enables us to perform the operations at both the ends.
		 * 
		 * deque can be used as stack or queue
		
			ArrayDeque class implements the Deque interface. It facilitates
			 us to use the Deque. Unlike queue, we can add or delete the elements 
			 from both the ends.

			ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions.
		 *
		 *It doesnt have capacity restrictions
		 *
		 *ArrayDeque is faster than LinkedList and Stack(
		 *because ArrayDeque uses contiguous memory layout and is more memory efficient)
		 *
		 *ArrayDeque doesnt allow the null
		 *LinkedList requires more additional memory overhead due to the storage of previous and next pointers.
		 */
		System.out.println("----------ArrayDeque-----------");
		ArrayDeque<String> integerArrayDeque = new ArrayDeque<String>();
		integerArrayDeque.addFirst("addFirst");
		integerArrayDeque.addLast("addLast");
		integerArrayDeque.getFirst();
		integerArrayDeque.getLast();
		integerArrayDeque.offer("offer");
		integerArrayDeque.offerFirst("offerFirst");
		integerArrayDeque.offerLast("OfferLast");
		integerArrayDeque.element();
		integerArrayDeque.peek();
		integerArrayDeque.peekFirst();
		integerArrayDeque.peekLast();
		integerArrayDeque.pollFirst();
		integerArrayDeque.pollLast();
		integerArrayDeque.pop();
		integerArrayDeque.push("push");
		System.out.println(integerArrayDeque.descendingIterator());
		Iterator itr1 = integerArrayDeque.iterator();
		itr1.forEachRemaining(System.out::println);
		//all the methods are also implemented in linkedlist
	}

}
   