package concepts.greedy.algorithms;

public class CanJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//TC: O(N) SC:O(1)
	public boolean canJump(int[] n) {

		int maxReachableIndex = 0;

		for (int i = 0; i < n.length; i++) {
			if (i > maxReachableIndex) { // if current index is greater than maxReachableIndex then we cant reach to
											// that ith index so return false
				return false;
			}
			maxReachableIndex = Math.max(maxReachableIndex, i + n[i]);// maxReachableIndex is the max
																		// ofmaxReachableIndex and no.of jumps we can
																		// make from the current index
		}

		return true;

	}

}
