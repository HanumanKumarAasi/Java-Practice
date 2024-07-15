package concepts.heap.datastructure;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

	public static void main(String[] args) {
		
	}
	
	long minCost(long arr[], int n) 
    {
        // your code here
        //SC: O(N)
        PriorityQueue<Long> pq = new PriorityQueue<>();
        //O(NlogN)
        for(long i:arr ){
            pq.add(i);
        }
        long res = 0;
        //O(N)
        while(pq.size()>1){
            long first = pq.poll();//first minimum
            long second = pq.poll();//second minimum
            long sum = first+second;//connecting minimum ropes
            res = res+sum;//appending sum with result
            pq.add(sum);//pushing connected rope length rope to pq
        }
        
        return res;
    }
	
	

}
