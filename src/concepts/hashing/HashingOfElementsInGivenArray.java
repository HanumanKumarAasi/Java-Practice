package concepts.hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class HashingOfElementsInGivenArray {
	
	public static void main(String args[]) {
		String s = "abcdefghijklmnopqrstuvwxyzavvvsdesssawxcnxmnnchjdilldkgsbvchylopkkmjuinbhgyyytfvvvredcccdewsdxswqazzaq";
		HashMap<Character,Integer> charHash = new LinkedHashMap<Character,Integer>();
		for(Character ch:s.toCharArray()) {
			charHash.put(ch, charHash.getOrDefault(ch,0)+1);
		}
		Iterator<Entry<Character, Integer>> entryList = charHash.entrySet().iterator();
		while(entryList.hasNext()) {
			Entry entry = entryList.next();
			System.out.println("key : "+entry.getKey()+" having count as : "+entry.getValue());
		}
	}
	
	
}
