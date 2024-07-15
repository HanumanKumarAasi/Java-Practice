package concepts.greedy.algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalsProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertIntervalsProblemSolution insert = new InsertIntervalsProblemSolution();
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int res[][]=insert.insert(intervals, new int[]{4,8});
		
		System.out.println(res);
	}

}

class InsertIntervalsProblemSolution {
    public int[][] insert(int[][] intervals, int[] target) {
    	List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        boolean inserted = false; // track if target has been inserted
        for (int i = 0; i < n; i++) {
            int first = intervals[i][0];
            int second = intervals[i][1];
            if (target[0] > second) { // no overlap, target goes after current interval
                ans.add(intervals[i]);
            } else if (target[1] < first) { // no overlap, target goes before current interval
                if (!inserted) {
                    ans.add(target);
                    inserted = true;
                }
                ans.add(new int[]{first, second});
            } else { // overlap, update target to cover both intervals
                target[0] = Math.min(first, target[0]);
                target[1] = Math.max(second, target[1]);
            }
        }
        if (!inserted) // insert target at the end if not already inserted
            ans.add(target);
        return ans.toArray(new int[ans.size()][]);
    }
}
