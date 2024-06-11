package concepts.slidingwindow_twopointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringByCharacterReplacementByKtimes {
	//Longest Repeating Character Replacement
	/*
	 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

		Return the length of the longest substring containing the same letter you can get after performing the above operations.
		
		 
		
		Example 1:
		
		Input: s = "ABAB", k = 2
		Output: 4
		Explanation: Replace the two 'A's with two 'B's or vice versa.
		Example 2:
		
		Input: s = "AABABBA", k = 1
		Output: 4
		Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
		The substring "BBBB" has the longest repeating letters, which is 4.
		There may exists other ways to achieve this answer too.
		 
		
		Constraints:
		
		1 <= s.length <= 105
		s consists of only uppercase English letters.
		0 <= k <= s.length

	 */
	public static int characterReplacement35ms(String s, int k) {
        int l=0,r=0,maxlen=0,maxfreq=0;
        Map<Character,Integer> mpp = new HashMap<Character,Integer>();
        
        while(r<s.length()){
            if(mpp.get(s.charAt(r))!=null){
                mpp.put(s.charAt(r),mpp.get(s.charAt(r))+1);
            }else{
                mpp.put(s.charAt(r),1);
            }

            maxfreq = Math.max(maxfreq,mpp.get(s.charAt(r)));

            int len = r-l+1;

            if(len-maxfreq<=k){
                maxlen=Math.max(maxlen,len);
            }else{
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))-1);
                maxfreq = Math.max(maxfreq,mpp.get(s.charAt(l)));
                l++;
            }
            r++;
        }
        return maxlen;
    }
	
	public int characterReplacement10ms(String s, int k) {
        int[] arr = new int[26];
        int res = 0;
        int max = 0;

        // The left pointer for the sliding window is l AND r is the 
        // right pointer
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // Counting the number of each character in the string s
            arr[s.charAt(r) - 'A']++;

            // Checking the character with max number of occurrence
            max = Math.max(max, arr[s.charAt(r) - 'A']);

            // Now we check if our current window is valid or not
            if (r - l + 1 - max > k) { 
            // this means the no. of replacements is more than
            // allowed (k)
                // Decrementing the count of the character which was 
                // at l because it is no longer in the window
                arr[s.charAt(l) - 'A']--;
                l++;
            }

            // The max our window can be
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
	
	public static void main(String args[]) {
		System.out.println(characterReplacement35ms("AABABBA",1));
	}

}
