package concepts.greedy.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//TC: O(N) SC:O(N)
	public int[][] merge(int[][] arr) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for(int i=0;i<arr.length;i++){
            //if ans list is empty we will be adding the first interval into it
            //another condition is like if we have intervals in the list and the last
            //intervals endtime is less than curr interval start time then it is not
            //a overlapp interval so we can add thenm in to the list
            if(ans.isEmpty() || arr[i][0]>ans.get(ans.size()-1)[1]){
                ans.add(new int[]{arr[i][0],arr[i][1]});
            }else{
                //if we have intervals in the list and the last
                //intervals endtime is greater than curr interval start time then it is
                //a overlapp interval so we need to take min from start and max for end and put in to the list
                ans.set(ans.size() - 1,new int[]{
                    Math.min(arr[i][0],ans.get(ans.size()-1)[0]),
                    Math.max(arr[i][1],ans.get(ans.size()-1)[1]),
                });
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

}


