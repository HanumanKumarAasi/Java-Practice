package concepts.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class PracticedMaps {
	
	public static void main(String args[]) {
		
		/*
		 * A map contains values on the basis of key, i.e. key and value pair. Each key
		 * and value pair is known as an entry. A Map contains unique keys. A Map is
		 * useful if you have to search, update or delete elements on the basis of a
		 * key.
		 * 
		 * 
		 * Maps are 3 types TreeMap(SortedMap) no null keys/values, 
		 * HashMap and LinkedHashMap allows null keys and values
		 */
		
		/*
		 * HashMap does allow one null key and multiple null values but it doesn't maintain order
		 *
		 *It is like the HashTable class, but is not synchronized
		 *
		 *The initial capacity of the HashMap is 16.
		 *
		 */		
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"Amit");  
	    map.put(5,"Rahul");  
	    map.put(2,"Jai");  
	    map.put(6,"Amit");
		map.put(1, "hanuma");// here we have reassign new value to the existing key, so value got updated
	    //Traversing the Map
		/*
		 * Set set = map.entrySet();
		 * 
		 * Iterator itr = set.iterator();
		 * 
		 * while(itr.hasNext()) { Map.Entry entry = (Map.Entry) itr.next();
		 * System.out.println(entry.getKey() + "-" +entry.getValue()); }
		 */
	    
		/* Also this can be used for traversing
		 * for(Map.Entry m:map.entrySet()){
		 * System.out.println(m.getKey()+" "+m.getValue()); }
		 */ 
	    
	    //using foEach for traversing
	    System.out.println("HashMap");// maintained ascending order 1,2,5,6
	    map.forEach((k,v) -> System.out.println(k+"-"+v));
		
	    //compareByKey in ascending order
	    System.out.println("compareByKey in ascending order");
		map.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByKey())
		.forEach(entry -> System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue()));
		
		//compareByKey in descending order
		System.out.println("compareByKey in descending order");
		map.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
		.forEach(entry -> System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue()));
		
		System.out.println("comparingByValue in ascending order");
		map.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue())
		.forEach(entry -> System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue()));
		
		
		System.out.println("comparingByValue in descending order");
		map.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEach(entry -> System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue()));
		
		//HashMap methods
		String compute = map.compute(6, (k,v) ->!v.isEmpty()?v+" is Valid String":"Not valid");
		System.out.println(compute);
		String computeIfPresent = map.computeIfPresent(7, (k,v) ->!v.isEmpty()?v+" is Valid String":"Not valid");
		System.out.println(computeIfPresent);
		String computeIfAbsent = map.computeIfAbsent(10, k -> "ten");
		System.out.println(computeIfAbsent);
		
		
		map.put(7, "seven");
		map.putIfAbsent(7, "7"); //the element will be inserted only if absent
		System.out.println("does key 7 exists? "+map.containsKey(7)); 
		System.out.println("does value seven exists? "+map.containsValue("seven"));
		System.out.println("removed key 6 : "+map.remove(6));
		System.out.println("removed key 7 : "+map.remove(7, "eight")); // eight is not correct value of key 7
		System.out.println("replace "+map.replace(1, "eight"));
		System.out.println("get key 1: "+map.get(1));
		System.out.println(""+map.getOrDefault(9, "default"));
		System.out.println("replaced all : ");
		map.replaceAll((k,v)->v.isEmpty()?"hanuma":v);
		map.merge(11, "eleven" , (k,v) -> v);//merging with new value if the specified key present else created the new entry with the specified key
		map.forEach((k,v) -> System.out.println(k+"-"+v));
		map.keySet();
		map.values();
		map.clear();
		
		
		
		/*
		 * LinkedHashMap inherits the HashMap and maintains the insertion order
		 * LinkedHashMap is non synchronized
		 * initial capacity:16
		 *
		 *
		 */
		
		LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<Integer,String>();
		linkedHashMap.put(1,"Amit");  
		linkedHashMap.put(5,"Rahul");  
		linkedHashMap.put(2,"Jai");  
		linkedHashMap.put(6,"Amit");
		System.out.println("LinkedHashMap");//maintained insertion order
		linkedHashMap.forEach((k,v) -> System.out.println(k+" = "+v));
		//same methods like HashMap
	
		
	
	
	
	
		/*
		 * TreeMap is a sortedMap and maintains an ascending order
		 * 
		 * it allows multiple null value but no null key
		 * 
		 * it is is non synchronized.
		 * 
		 * It implements the NavigableMap interface and extends AbstractMap class.
		 */		
		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer,String>();
		treeMap.put(1,"Amit");
		treeMap.put(4,"Four");
		treeMap.put(5,"Rahul");  
		treeMap.put(2,"Jai");  
		treeMap.put(6,"Amit");
		treeMap.put(3,"Three");
		System.out.println("TreeMap");//maintained insertion order
		treeMap.forEach((k,v) -> System.out.println(k+" = "+v));
		Map.Entry entry= treeMap.ceilingEntry(6);//key>=6
		System.out.println("ceiling entry : "+ entry.getValue());
		treeMap.remove(2);
		System.out.println("descendingMap: "+treeMap.descendingMap());  
		System.out.println("haed map of key 2: "+treeMap.headMap(6,true));//keys<6, if true keys<=6
		System.out.println("ceiling key of 2: "+treeMap.ceilingKey(6));//keys>=6
		System.out.println("floor key of 2:  "+treeMap.floorKey(6));//keys<=6
		System.out.println("tail map of 6: "+treeMap.tailMap(6));//keys>=6
		System.out.println("sub map in b/w 1 and 3"+treeMap.subMap(1, false, 3, false));
		System.out.println("first key : "+treeMap.firstKey());
		System.out.println("higher key is strict return key>specified key : "+treeMap.higherKey(6));
		System.out.println("higher Entry is strict return key>specified key : "+treeMap.higherEntry(6));
		System.out.println("lower key is strict return key<specified key : "+treeMap.lowerKey(6));
		System.out.println("lower Entry is strict return key<specified key : "+treeMap.lowerEntry(6));
		System.out.println("first Enrty : "+treeMap.firstEntry());
		System.out.println("last Key : "+treeMap.lastKey());
		System.out.println("last Enrty : "+treeMap.lastEntry());
		System.out.println("poll first entry : "+treeMap.pollFirstEntry());//return and remove the first entry
		System.out.println("poll last entry : "+treeMap.pollLastEntry());// return and remove the last entry
		System.out.println("navigableKeySet : "+treeMap.navigableKeySet());
	}

}




