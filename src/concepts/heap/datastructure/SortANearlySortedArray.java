package concepts.heap.datastructure;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortANearlySortedArray {

	//Function to return the sorted array.
    static ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        //inserting the first k+1 into the min Heap data structure using prioority queue
        int minHeapSize = Math.min(arr.length,k+1);
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //O(KlogK)
        //adding first k+1 elements into PQ
        for(int i=0;i<minHeapSize;i++){
            pq.add(arr[i]);
        }
        
        //O((N-K)log(N-K))
        for(int i=k+1;i<arr.length;i++){
            list.add(pq.poll());
            pq.add(arr[i]);            
        }
        
        //O(N-K)
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        
        return list;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
 
        // function call
        //TC : O(K) + O(m * log(k))
        for(int i: nearlySorted(arr, n, k)) {
        	System.out.println(i);
        }
    }

}
