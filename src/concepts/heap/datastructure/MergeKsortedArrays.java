package concepts.heap.datastructure;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKsortedArrays {
	// Function to merge k sorted arrays.
	//Time Complexity: O(N*K*logK)
	//Auxiliary Space: O(N)
	public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
		// Write your code here.
		// result list
		ArrayList<Integer> result = new ArrayList<>();

		// priority queue
		PriorityQueue<HeapNode> pq = new PriorityQueue<>();

		// adding only 0th index elements to pq initially
		//O(K log K)
		for (int in = 0; in < arr.length; in++) {
			pq.add(new HeapNode(in, 0, arr[in][0]));
		}
		
		//N*K log K
		while (!pq.isEmpty()) {
			HeapNode curr = pq.poll(); // removing the pq minimum value first and adding the next element to that value
										// into PQ from the same array

			result.add(curr.value);

			if (curr.j < arr[curr.i].length - 1) {
				pq.add(new HeapNode(curr.i, (curr.j) + 1, arr[curr.i][(curr.j) + 1]));
			}
		}

		return result;

	}
}

class HeapNode implements Comparable<HeapNode> {

	int i;
	int j;
	int value;

	HeapNode(int i, int j, int val) {
		this.i = i;
		this.j = j;
		this.value = val;
	}

	@Override
	public int compareTo(HeapNode that) {
		if (this.value >= that.value) {
			return 1;
		}
		return -1;
	}
}