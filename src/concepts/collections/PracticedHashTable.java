package concepts.collections;

import java.util.Enumeration;
import java.util.Hashtable;

public class PracticedHashTable {
	
	public static void main(String args[]) {
		Hashtable<Integer, String> table = new Hashtable<>();
	
		//table.put(1, null);//it doesnt allow null vales/keys
		//table.put(null, "hanuma");
		table.put(1, "bob");
		table.put(2, "john");
		table.put(3, "rocky");
		table.put(4, "jim");
		table.put(5, "honey");
		Enumeration<String> enums = table.elements();
		System.out.println("printing enums of elements");
		while(enums.hasMoreElements()) { //print the ele in reverse order
			System.out.println(enums.nextElement());
		}
		table.forEach((k,v) -> System.out.println(k+"="+v));
		//all the other functions are same like HashMaps
		
	}

}
