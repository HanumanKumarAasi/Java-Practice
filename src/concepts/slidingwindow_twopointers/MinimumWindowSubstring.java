package concepts.slidingwindow_twopointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	
	/*
	 * Minimum Window Substring

		Given two strings s and t of lengths m and n respectively, return the minimum window 
		substring
		 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
		
		The testcases will be generated such that the answer is unique.
		
		 
		
		Example 1:
		
		Input: s = "ADOBECODEBANC", t = "ABC"
		Output: "BANC"
		Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
		Example 2:
		
		Input: s = "a", t = "a"
		Output: "a"
		Explanation: The entire string s is the minimum window.
		Example 3:
		
		Input: s = "a", t = "aa"
		Output: ""
		Explanation: Both 'a's from t must be included in the window.
		Since the largest window of s only has one 'a', return empty string.
		 
		
		Constraints:
		
		m == s.length
		n == t.length
		1 <= m, n <= 105
		s and t consist of uppercase and lowercase English letters.
		 
		
		Follow up: Could you find an algorithm that runs in O(m + n) time?
	 */
	
	public static String minWindow(String s, String t) {
		int l=0,r=0, minlen=s.length()+1, startIndex=-1,count=0;
        Map<Character,Integer> mpp = new HashMap<Character,Integer>();

        for(char ch:t.toCharArray()) {
        	if(mpp.get(ch)!=null){
                mpp.put(ch,mpp.get(s.charAt(r))+1);
            }else{
                mpp.put(ch,1);
            }
        }
        
        
        
        while(r<s.length()){
        	
        	
        	
        	
            if(mpp.get(s.charAt(r))!=null){
                if(mpp.get(s.charAt(r))>0){
                    count+=1;
                }
                mpp.put(s.charAt(r),mpp.get(s.charAt(r))-1);
            }else{
                mpp.put(s.charAt(r),-1);
            }

            while(count==t.length()){
            	
            	if(r-l+1<minlen) {
	                minlen = r-l+1;
	                startIndex = l;
            	}
            	
            	if(minlen==t.length())
            	{
            		return startIndex>-1?s.substring(startIndex,r+1):""; 
            	}
            	
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))+1);
                if(mpp.get(s.charAt(l))>0){
                    count-=1;
                }
                l++;
            }
            r++;
        }

        return startIndex>-1?s.substring(startIndex,r):"";

    }
	
	public static void main(String args[]) {
		String str = minWindow("ADOBECODEBANC","ABC");

		System.out.println(str);
	}
}
