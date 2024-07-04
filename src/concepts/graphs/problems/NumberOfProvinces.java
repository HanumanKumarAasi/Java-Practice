package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfProvinces {
	
	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<V;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i =0;i<adj.size();i++){
            for(int j =0;j<adj.get(i).size();j++){
                if(adj.get(i).get(j)==1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        
        int vis[] = new int[V];
        int count[] = new int[1];
        int n=0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i, adjList,vis);
                n++;
            }
        }
        
        return n;
    }
    
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[]){
        vis[node] = 1;
        
        for(int adjNode:adj.get(node)){
            if(vis[adjNode]==0){
                dfs(adjNode,adj,vis);
            }
        }
    }
    
    
    public static void main(String args[]) {
    	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    	
    	adj.add(new ArrayList<Integer>(Arrays.asList(1,0)));
    	adj.add(new ArrayList<Integer>(Arrays.asList(0,1)));
    	
    	System.out.println(numProvinces(adj,2));
    }

}
