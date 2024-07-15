package concepts.heap.datastructure;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReplaceWithRankforTheGivenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int[] replaceWithRank(int arr[], int N) {
	     // code here
	     // recording the value and rank in this map
	    HashMap<Integer,Integer> map = new HashMap<>();
	    PriorityQueue<int[]> minheap = new PriorityQueue<>(
	        (a,b) -> Integer.compare(a[1],b[1])
	    );
	    
	    //adding index and value array in to pq
	    for(int i=0;i<N;i++){
	        minheap.offer(new int[]{i,arr[i]});
	    }
	    //res array
	    int[] res = new int[N];
	    
	    //counter for rank
	    int cnt = 1;
	    
	    while(!minheap.isEmpty()){
	        int[] temp = minheap.poll();
	        int idx = temp[0];//index
	        int val = temp[1];//value
	        if(!map.containsKey(val)){ //does rank for this val exists in the map if not assign the rank and put it in map
	            map.put(val,cnt);
	            res[idx] = map.get(val);
	            cnt++;
	        }
	        else{//else get the existing rank from the map and assign it to it.
	            res[idx] = map.get(val);
	        }
	    }
	    return res;
	  }

}
