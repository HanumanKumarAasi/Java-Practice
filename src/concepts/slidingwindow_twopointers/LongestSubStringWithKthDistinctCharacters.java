package concepts.slidingwindow_twopointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKthDistinctCharacters {
	
	//This problem is same like fruits in basket... added some additional base condition here
	
	/*Longest K unique characters substring

	 * 
	 * Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

		Example 1:
		
		Input:
		S = "aabacbebebe", K = 3
		Output: 
		7
		Explanation: 
		"cbebebe" is the longest substring with 3 distinct characters.
		Example 2:
		
		Input: 
		S = "aaaa", K = 2
		Output: -1
		Explanation: 
		There's no substring with 2 distinct characters.
		Your Task:
		You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.
		
		Expected Time Complexity: O(|S|).
		Expected Auxiliary Space: O(|S|).
		
		Constraints:
		1 ≤ |S| ≤ 105
		1 ≤ K ≤ 26
		All characters are lowercase latin characters.
	 */
	
	
	public int longestkSubstr(String s, int k) {
        // code here
        int l=0,r=0,maxlen=-1;
        Map<Character,Integer> mpp = new HashMap<Character,Integer>();
        
        while(r<s.length()){
            if(mpp.get(s.charAt(r))!=null){
                mpp.put(s.charAt(r),mpp.get(s.charAt(r))+1);
            }else{
                mpp.put(s.charAt(r),1);
            }
            
            if(mpp.size()>k){
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))-1);
                if(mpp.get(s.charAt(l))==0){
                    mpp.remove(s.charAt(l));
                }
                l++;
            }
            
            if(mpp.size()==k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }

}
