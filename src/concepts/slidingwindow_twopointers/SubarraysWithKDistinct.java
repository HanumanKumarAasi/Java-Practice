package concepts.slidingwindow_twopointers;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinct {

	/*
	 * Subarrays with K Different Integers
		
		Given an integer array nums and an integer k, return the number of good subarrays of nums.

		A good array is an array where the number of different integers in that array is exactly k.
		
		For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
		A subarray is a contiguous part of an array.
		
		 
		
		Example 1:
		
		Input: nums = [1,2,1,2,3], k = 2
		Output: 7
		Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
		Example 2:
		
		Input: nums = [1,2,1,3,4], k = 3
		Output: 3
		Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
		 
		
		Constraints:
		
		1 <= nums.length <= 2 * 104
		1 <= nums[i], k <= nums.length
	 */
	
	public int subarraysWithKDistinct(int[] nums, int k) {
		//TC is same like Binary sub array with sum..
		//SC: O(N) we are using map DS
        return subarraysWithKDistinctFunc(nums,k)-subarraysWithKDistinctFunc(nums,k-1);
    }

    public static int subarraysWithKDistinctFunc(int[] nums, int k) {
        int l=0,r=0,count=0;
        Map<Integer,Integer> mpp = new HashMap<Integer,Integer>();

        while(r<nums.length){
            if(mpp.get(nums[r])!=null){
                mpp.put(nums[r],mpp.get(nums[r])+1);
            }else{
                mpp.put(nums[r],1);
            }

            while(mpp.size()>k && l<nums.length){
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                }
                l++;
                
            }

            count = count+(r-l+1);	
            r++;
        }
        return count;
    }
    
    /*
     * class Solution {
     public int subarraysWithKDistinct(int[] nums, int K) {
        int[] numFreq = new int[nums.length+1];
        int distinct = 0, start = 0, minEnd = 0, total = 0;
        while (distinct == K || minEnd < nums.length) {
            while (distinct < K && minEnd < nums.length) 
			    if (numFreq[nums[minEnd++]]++ == 0) 
                distinct++;
            int maxEnd = minEnd;
            while (maxEnd < nums.length && numFreq[nums[maxEnd]] > 0)
			    maxEnd++;
            while (distinct == K) {
                if (numFreq[nums[start++]]-- == 1)
                distinct--;
                total += (maxEnd - minEnd + 1);
            }
        }
        return total;
    }
 }
     */
	
	
}
