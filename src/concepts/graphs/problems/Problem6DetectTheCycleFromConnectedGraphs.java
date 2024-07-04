package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem6DetectTheCycleFromConnectedGraphs {
	
	
	
	// Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[] = new int[V];
        
        for(int i=0;i<V;i++){
            vis[i]=0;
        }
        
        //this loop is for when we have multiple connected graphs, in that case we need to verify each graph
        for(int i=0;i<V;i++){
            //checking if it is visited already or not;
            
            //BFS logic
            // if(vis[i]==0){
            //     if(detectUsingBFS(i,adj,vis)){
            //         return true;
            //     }
            // }
            
            //DFS logic
            
            if(vis[i]==0){
                if(detectUsingDFS(i,-1,adj,vis)){
                    return true;
                }
            }
            
        }
        
        return false;
        
        
    }
    
    
    private boolean detectUsingBFS(int src, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[src]=1;
        
        Queue<Pair1> q= new LinkedList<>();
        
        //passing the new start node pair (1,-1) -1 means there is no parent for 1
        q.add(new Pair1(src,-1));
        
        while(!q.isEmpty()){
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();
            for(int childNode:adj.get(node)){
                if(vis[childNode]==0){
                    vis[childNode]=1;
                    q.add(new Pair1(childNode,node));
                }else if(childNode!=parent){ //checking if the visited node is not parent if it not parent then the cycle exists
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean detectUsingDFS(int child, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis){
        
        vis[child]=1;
        
        for(int adjChildNode:adj.get(child)){
            
            if(vis[adjChildNode]==0){
                if(detectUsingDFS(adjChildNode,child,adj,vis)){ // if any of the recursive call returns true then we directly returns true
                    return true;
                }
            }else if(adjChildNode!=parent){
                return true;
            }
        }
        
        return false;
        
    }
}

class Pair1{
    int node;
    int parent;
    
    Pair1(int n, int p){
        node = n;
        parent = p;
    }
}