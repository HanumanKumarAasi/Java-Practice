package concepts.graphs.problems;

import java.util.ArrayList;

public class Problem2DFSGraphTraversal {
	
	// Function to return a list containing the DFS traversal of the graph.
	
	//Q: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        //Visitors array
        boolean[] visitors = new boolean[V+1];
        
        //starts from 0 vertex
        visitors[0] = true;
        
        ArrayList<Integer> dfslist = new ArrayList<>();
        
        //started from vertex 0
        dfs(0,adj,visitors,dfslist);
        
        return dfslist;
        
    }
    
    //function to visit neighbor and their neighbors till all of their neighbors get visited
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visitors, ArrayList<Integer> dfslist){
        
        visitors[node]=true;//setting node is visited
        dfslist.add(node);//adding node to list
        
        for(int it:adj.get(node)){
            if(!visitors[it]){
                dfs(it,adj,visitors,dfslist);//recursive for neighbor if not visited
            }
        }
    }

}
