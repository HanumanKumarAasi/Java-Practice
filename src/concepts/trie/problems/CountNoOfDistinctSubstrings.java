package concepts.trie.problems;

public class CountNoOfDistinctSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countDistinctSubstrings("abab"));

	}
	
	//TC: O(N*N)
	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		Node root = new Node();
		int count=0;
		for(int i=0;i<s.length();i++){
			Node node = root;
			for(int j=i;j<s.length();j++){
				if(!node.containsKey(s.charAt(j))){
					count++;
					node.put(s.charAt(j), new Node());
				}
				node = node.get(s.charAt(j));
			}
		}
		return count+1; //adding 1 because empty string can also be considered as one of the substring
	}

}
