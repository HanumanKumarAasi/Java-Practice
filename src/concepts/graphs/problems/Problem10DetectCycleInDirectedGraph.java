package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem10DetectCycleInDirectedGraph {
	
	// Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        //visitor array
        int vis[] = new int[V];
        //path array
        int path[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                //if cycle exists directly return no need to check for other components
                if(dfs(i,adj,vis,path)){
                    return true;
                }
            }
        }
        //if no cycle founds at any component return false
        return false;
    }
    
    boolean dfs(int currNode, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path){
        vis[currNode]=1; // setting visior
        path[currNode]=1;// setting path
        
        //vis[currNode]=2; if only one array for both vis and path
        
        //traverse for adjNodes
        for(int adjNode:adj.get(currNode)){
            
            if(vis[adjNode]==0){
                //if we detect cycle at any time return true
                if(dfs(adjNode,adj,vis,path)){
                    return true;
                }
            }else if(vis[adjNode]==1 && path[adjNode]==1){//vis[currNode]=2; if only one array for both vis and path
                //condition when there is a cycle that started moving  and visited again on the same path then we return true
                    return true;
            }
        }
        path[currNode]=0; // as we didnt find any cycle we make that nodes path 0 while returning //vis[currNode]=vis[currNode]-1; if only one array for both vis and path
        return false;
    }
    
    //Kahns algorithm
    boolean bfs(int V, ArrayList<ArrayList<Integer>> adj){
        
        int[] incomingedgesdegree= new int[V];
        
        //recording indegree edges
        for(int i=0;i<V;i++){
            for(int adjNode:adj.get(i)){
                incomingedgesdegree[adjNode]++;
            }
        }
        
        Queue<Integer> q =new LinkedList<>();
        
        for(int i=0;i<V;i++){
            //adding the nodes which has indegree 0
            if(incomingedgesdegree[i]==0){
                q.add(i);
            }
        }
        
        
        int k=0;
        while(!q.isEmpty()){
            
            int curr = q.peek();
            q.remove();
            //adding the curr to ans list which is the topo
            k++;
            for(int adjNode:adj.get(curr)){
                //decrasing the indegree of adjNode
                incomingedgesdegree[adjNode]--;
                
                if(incomingedgesdegree[adjNode]==0){
                    //adding the adjnode if its indegree is 0
                    q.add(adjNode);
                }
                
            }
            
        }
        
        if(k==V) return false;
        
        return true;
        
    }

}
