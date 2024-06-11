package concepts.slidingwindow_twopointers;

public class BinarySubarraysWithSum {
	
	/*Binary Sub arrays With Sum
	 * 
	 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

		A subarray is a contiguous part of the array.
		
		 
		
		Example 1:
		
		Input: nums = [1,0,1,0,1], goal = 2
		Output: 4
		Explanation: The 4 subarrays are bolded and underlined below:
		[1,0,1,0,1]
		[1,0,1,0,1]
		[1,0,1,0,1]
		[1,0,1,0,1]
		Example 2:
		
		Input: nums = [0,0,0,0,0], goal = 0
		Output: 15
		 
		
		Constraints:
		
		1 <= nums.length <= 3 * 104
		nums[i] is either 0 or 1.
		0 <= goal <= nums.length
	 */

	
	public int numSubarraysWithSum(int[] nums, int goal) {
		//TC: O(2*2N) SC:O(1)
        return numSubarraysWithSumfunc(nums,goal)-numSubarraysWithSumfunc(nums,goal-1);
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
