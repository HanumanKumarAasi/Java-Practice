package concepts.greedy.algorithms;

import java.util.Arrays;

public class ShortestJobFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//TC: O(N) SC:O(1)
	static int solve(int bt[]) {
		// code here

		int respectiveJobExecutionWaittime = 0;// initially the wait time will be 0 for the first shortest job.
		Arrays.sort(bt);
		int totalTime = 0;
		for (int i = 0; i < bt.length; i++) {
			totalTime = respectiveJobExecutionWaittime + totalTime;
			respectiveJobExecutionWaittime = respectiveJobExecutionWaittime + bt[i];// this will the wait time for the
																					// next job to trigger

		}

		return totalTime / bt.length; // returning average time of the totaltime taken to execute all the jobs

	}
	// Note: the first job doesnt wait for any sort of time so total time for
	// executing that job would be 0

}
