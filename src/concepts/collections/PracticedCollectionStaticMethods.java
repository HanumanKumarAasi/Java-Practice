package concepts.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class PracticedCollectionStaticMethods {

	public static void main(String args[]) {
		
		/*
		 * Collection class inherits the Object class and it used to perform operations
		 * on collections or it returns the collections
		 * 
		 * it contains static methods mentioned below.
		 * 
		 */
		
		//addAll
		Set<Integer> hashset = new HashSet<>();
		boolean addAll = Collections.addAll(hashset,1,2,3,null); // it throw error if it is a tree set as it doesnt allow null values
		System.out.println("addAll : "+addAll);
		
		
		//asLifoQueue - it returns the Deque elements in a queue LIFO manner
		Deque<String> dque = new ArrayDeque<String>(5);  
        dque.add("Java");  
        dque.add("C");  
        dque.add("C++");  
        dque.add("Unix");  
        dque.add("Perl");          
        Queue<String> q =Collections.asLifoQueue(dque);
        q.offer("ha");
        q.offer("a");
        System.out.println(q);//[a, ha, Java, C, C++, Unix, Perl]
        
        //binarySearch()
        ArrayList<Integer> arrlist = new ArrayList<Integer>();  
        arrlist.add(10);  
        arrlist.add(-20);  
        arrlist.add(30);  
        arrlist.add(-40);  
        arrlist.add(50);  
        //Print List  
        System.out.println("Provided List are: "+arrlist);  
        //Search the list for key '-20'  
        int index = Collections.binarySearch(arrlist, -20);       
        System.out.println("Index '-20' is available at position: "+index);  //it returns -1 because it is not sorted(the elements should be sorted before the invocation)
        int indexaftersorted = Collections.binarySearch(arrlist, -20,  Collections.reverseOrder());       
        System.out.println("Index '-20' is available at position: "+indexaftersorted);
        
 
	}
	
}


