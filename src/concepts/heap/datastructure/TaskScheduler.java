package concepts.heap.datastructure;

public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char tasks[] = { 'A', 'A', 'A', 'B', 'B', 'C', 'C' };
		int ans = leastInterval(tasks.length, 3, tasks);

		System.out.println(ans);
	}

	// Back-end complete function Template for Java
	// TC: O(N) SC:O(1)
	static int leastInterval(int n, int K, char tasks[]) {
		// creating an array to store the frequencies of tasks
		int[] counter = new int[26];
		// variable to store the maximum frequency
		int max = 0;
		// variable to store the number of tasks with maximum frequency
		int maxCount = 0;

		// O(N)
		// iterating over the tasks array
		for (char task : tasks) {
			// incrementing the frequency of the current task
			counter[task - 'A']++;
			// checking if the current task has the maximum frequency so far
			// and updating max and maxCount accordingly
			if (max == counter[task - 'A']) {
				maxCount++;
			} else if (max < counter[task - 'A']) {
				max = counter[task - 'A'];
				maxCount = 1;
			}
		}
		// max = 3(A's frequency) maxcount=1 bcoz A's frequency would be the highest
		// frequency and it is the only one highest freq
		// calculating the number of parts and their lengths
		int partCount = max - 1; // A(_ _ _)A(_ _ _)A => 2(_ _ _)partitions with length 3(1 2 3)
		int partLength = K - (maxCount - 1);

		// calculating the number of empty slots, available tasks, and idles
		int emptySlots = partCount * partLength; // partitions*partitionslength would be the empty slots = 6
		int availableTasks = tasks.length - max * maxCount; // (AAABBCC)- (AAA*1)= 7 - 3 = 4
		int idles = Math.max(0, emptySlots - availableTasks);// max(0,6-4) = 2

		// returning the total number of tasks and idles
		return tasks.length + idles;// 7
	}

}
