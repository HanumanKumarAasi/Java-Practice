package concepts.heap.datastructure;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,1,2,2,3};
		
		int res[] = topKFrequent(arr, 2);
		
		for(int i:res) {
			System.out.println(i);
		}

	}
	
	public static int[] topKFrequent(int[] nums, int K) {
		
		if (K == nums.length) {
            return nums;
        }
        int res[] = new int[K];
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.freq-a.freq));

        //1. O(N)
        for(int i=0;i<nums.length;i++){
            
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
           
        }
        
        // 2. Keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for(int key:map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }

        // 3. Build an output array
        // O(k log k) time
        for(int i=0;i<K;i++){
            res[i]=pq.poll().ele;
        }

        return res;
    }
}

class Pair{
    int ele;
    int freq;
    Pair(int e, int f){
        this.ele = e;
        this.freq = f;
    }
}
