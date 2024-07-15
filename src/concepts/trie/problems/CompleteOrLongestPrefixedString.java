package concepts.trie.problems;

public class CompleteOrLongestPrefixedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str[] = {"n","ninja","ni","nin","ninj","ninga"};
		
		System.out.println(completeString(6, str));

	}
	
	public static String completeString(int n, String[] a) {
	    // Write your code here.
		//TC: O(N*Max length from string array))
	    Trie trie = new Trie();

	    for(int i=0;i<n;i++){
	      trie.insert(a[i]);
	    }

	    String longest = "";
	   
	    for(int i=0;i<n;i++){
	       if(trie.checkIfPrefixExists(a[i])){//if the string is prefixed then only consider this as longest string based on the curr and new lengths
	           if(longest.length()<a[i].length()){
	               longest = a[i];
	           }else if(longest.length()==a[i].length() && a[i].compareTo(longest)<0){
	               longest = a[i];//for same lenth longest string prefer least lexicographical string
	           }
	       }
	    }

	    if(longest.length()>=1){
	      return longest;
	    }
	    return "None";

	  }

}