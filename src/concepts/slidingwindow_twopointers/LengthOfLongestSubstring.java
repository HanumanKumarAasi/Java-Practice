package concepts.slidingwindow_twopointers;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	
	/*Longest Substring Without Repeating Characters
	
	Given a string s, find the length of the longest 
	substring
	 without repeating characters.

	 

	Example 1:

	Input: s = "abcabcbb"
	Output: 3
	Explanation: The answer is "abc", with the length of 3.
	Example 2:

	Input: s = "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.
	Example 3:

	Input: s = "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3.
	Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 

	Constraints:

	0 <= s.length <= 5 * 104
	s consists of English letters, digits, symbols and spaces.*/
	
	public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,maxlen=0;
        int n = s.length();
        Map<Character,Integer> hash = new HashMap<Character,Integer>();
        
        while(r<n){
            if(hash.containsKey(s.charAt(r))){
                if(hash.get(s.charAt(r))>=l){
                    l=hash.get(s.charAt(r))+1;
                }
            }
            int len=r-l+1;
            maxlen = Math.max(maxlen,len);
            hash.put(s.charAt(r),r);
            r++;
        }
        return maxlen;
    }

}
