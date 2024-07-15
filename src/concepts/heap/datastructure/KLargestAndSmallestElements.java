package concepts.heap.datastructure;

import java.util.PriorityQueue;

public class KLargestAndSmallestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = { 12, 5, 787, 1, 23 };
        int n = arr.length;
        int k = 2;

        System.out.println("K largest elements:"+kLargest(arr, n, k));
        
        System.out.println("K smallest elements:"+ kSmallest(arr, k));
        
	}
	
	public static int[] kLargest(int[] arr, int n, int k) {
        // Implementation using
        // a Priority Queue
        int ans[] = new int[k];
        
        PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>((a,b)->b-a);

        for (int i = 0; i < n; ++i) {

            // Insert elements into
            // the priority queue
            pq.add(arr[i]);

            
        }

        // Print the k largest element
        int index=0;
        while (!pq.isEmpty() && index<k) {
            ans[index++]=pq.poll();
        }
		
		return ans;
	}
	
	public static int kSmallest(int[] arr, int k) 
	    { 
	        //Your code here
	        // Implementation using
	        // a Priority Queue
	        int n = arr.length;
	        PriorityQueue<Integer> pq
	            = new PriorityQueue<Integer>((a,b)->a-b);

	        for (int i = 0; i < n; ++i) {

	            // Insert elements into
	            // the priority queue
	            pq.add(arr[i]);

	            
	        }

	        // Print the k smallest element
	        int index=1;
	        while (!pq.isEmpty()) {
	            if(index==k){
	                return pq.poll();
	            }else{
	                pq.poll();
	                index++;
	                
	            }
	        }
			
			return -1;
	    } 

	public static int findKthLargest(int[] arr, int n, int k) {
		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

// Find the minimum and maximum elements in the
// array
		for (int i : arr) {
			low = Math.min(low, i);
			high = Math.max(high, i);
		}

// Perform binary search on the range of elements
// between low and high
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;

// Count the number of elements greater than mid
// in the array
			for (int i : arr) {
				if (i > mid) {
					count++;
				}
			}

// If there are at least K elements greater than
// mid, search the right half
			if (count >= k) {
				low = mid + 1;
			}
// Otherwise, search the left half
			else {
				high = mid - 1;
			}
		}

// Return the Kth largest element
		return low;
	}

	public static void printKLargest(int[] arr, int n, int k) {
// Find the Kth largest element
		int kthLargest = findKthLargest(arr, n, k);

// Print the K largest elements in decreasing order
		for (int i : arr) {
			if (i >= kthLargest) {
				System.out.print(" " + i);
			}
		}
	}

}
