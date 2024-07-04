package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1BFSGraphTraversal {
	
	//Question: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
	
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //Queue DS
        Queue<Integer> q =new LinkedList<>();
        
        //visitor array
        boolean[] visitor = new boolean[V];
        
        //BSF-List
        ArrayList<Integer> bfs = new ArrayList<>();
        
        //Question is to traverse from 0 node and node starts from 0
        //V is n0.of nodes including 0
        
        q.add(0);
        visitor[0]=true;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            bfs.add(curr); //addding polled curr node to bfs
            
            
            for(Integer it:adj.get(curr)){//getting all the connections
                if(visitor[it]==false){//checking whether the connections already visited or not
                    q.add(it);
                    visitor[it]=true;
                }
            }
            
        }
        
        return bfs;
        
        
    }

}
