package concepts.heap.datastructure;

import java.util.PriorityQueue;

public class KthLargestInAStreamOfRunningIntegers {
	//TC: O(NlogN)
	PriorityQueue<Integer> pq;
    int K;
    public KthLargestInAStreamOfRunningIntegers(int k, int[] nums) {
        this.K = k;
        this.pq = new PriorityQueue<Integer> ();

        for(int i:nums){
            pq.add(i);
        }
    }

    
    //at every addition of element to the min heap we reduce the min heap size to k and will be returning the peek value which is the kth largest value
    public int add(int val) {
        pq.add(val);
        while(!pq.isEmpty()){
            if(pq.size()>K) pq.poll();
              else break;
        }
        return pq.peek();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
