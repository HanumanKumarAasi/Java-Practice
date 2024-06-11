package concepts.slidingwindow_twopointers;

public class LongestOnes {

	/*
	 * Max Consecutive Ones III
	 * 
	 * Given a binary array nums and an integer k, return the maximum number of
	 * consecutive 1's in the array if you can flip at most k 0's.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6 Explanation:
	 * [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1. The longest
	 * subarray is underlined. 
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 Output: 10
	 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] Bolded numbers were
	 * flipped from 0 to 1. The longest subarray is underlined.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 105 nums[i] is either 0 or 1. 0 <= k <= nums.length
	 */

	// Better Approach
	public int longestOnes(int[] a, int k) {
		// THE TC for this approach is O(2N) SC: O(1)
		int l = 0, r = 0, zeros = 0, maxlen = 0;

		while (r < a.length) {

			if (a[r] == 0) {
				zeros++;
			}
			while (zeros > k) {
				if (a[l] == 0) {
					zeros--;
				}
				l++;
			}
			if (zeros <= k) {
				int len = r - l + 1;
				maxlen = Math.max(len, maxlen);
			}
			r++;

		}
		return maxlen;

	}

	// Optimal Approach
	public int longestOness(int[] a, int k) {
		// THE TC for this approach is O(N) SC: O(1)
		int l = 0, r = 0, zeros = 0, maxlen = 0;

		while (r < a.length) {

			if (a[r] == 0) {
				zeros++;
			}
			if (zeros > k) {
				if (a[l] == 0) {
					zeros--;
				}
				l++;
			}
			if (zeros <= k) {
				int len = r - l + 1;
				maxlen = Math.max(len, maxlen);
			}
			r++;

		}
		return maxlen;

	}

}
