package concepts.slidingwindow_twopointers;

public class CountNumberofNiceSubarrays {
	/*
	 * Count Number of Nice Sub arrays
	 * 
	 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

		Return the number of nice sub-arrays.
		
		 
		
		Example 1:
		
		Input: nums = [1,1,2,1,1], k = 3
		Output: 2
		Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
		Example 2:
		
		Input: nums = [2,4,6], k = 1
		Output: 0
		Explanation: There is no odd numbers in the array.
		Example 3:
		
		Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
		Output: 16
		 
		
		Constraints:
		
		1 <= nums.length <= 50000
		1 <= nums[i] <= 10^5
		1 <= k <= nums.length
	 */
	public int numberOfSubarrays(int[] nums, int k) {
		//This problem is same like Binary sub array with sum by considering 1 as odd and 0 as even numbers in this problem.
		//TC: O(2*2N) SC:O(1)
        return numSubarraysWithSumfunc(nums,k)-numSubarraysWithSumfunc(nums,k-1);
    }

    public int numSubarraysWithSumfunc(int[] nums, int goal) {
        int l=0,r=0,count=0,sum=0;
        if(goal<0){
            return 0; //edge case scenario
        }
         //TC:O(N+N) = O(2N) SC:O(1) because we are using any extra spaces
        
        while(r<nums.length){ //O(N) at once 
            sum=sum+nums[r];

            while(sum>goal && l<nums.length){
                sum=sum-nums[l]; //this loop will run for O(N) times and only at once..
                l++;
            }

            count=count+(r-l+1); //(r-l+1) all the possible sub arrays with sum<=goal;
            r++;
        }
        return count;
    }
}
