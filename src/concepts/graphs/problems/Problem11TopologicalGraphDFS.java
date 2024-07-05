package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Stack;

public class Problem11TopologicalGraphDFS {

	 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
	    {
	        // add your code here
	        //visitor array
	        int vis[] = new int[V];
	        int ans[] = new int[V];
	        Stack<Integer> stack = new Stack<>();
	        for(int i=0;i<V;i++){
	            if(vis[i]==0){
	                dfs(i,vis,stack,adj);
	            }
	        }
	        
	        for(int i=0;i<V;i++){
	            ans[i] = stack.pop();
	        }
	        
	        return ans;
	        
	        //return bfs(V,adj);
	    }
	    
	    static void dfs(int currNode, int vis[], Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
	        vis[currNode]=1;
	        
	        for(int adjNode:adj.get(currNode)){
	            if(vis[adjNode]==0){
	                //we will be calling dfs only if not is not visited
	                dfs(adjNode,vis,stack,adj);
	            }
	        }
	        //adding the currnode to stack 
	        stack.push(currNode);
	    }
	
}
