package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathDirectedAcyclicGraph {
//Q: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		
		
		//adj list - they have givenus the edges which contains u edges[i][0] -> v edges[i][1] with a weight edges[i][1]; 
		ArrayList<ArrayList<Pair4>> adj = new ArrayList<>();
		
		for(int i=0;i<N;i++){
		    adj.add(new ArrayList<Pair4>());
		}
		
		for(int i=0;i<edges.length;i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    
		    adj.get(u).add(new Pair4(v,wt));
		}
		
		int vis[] = new int[N];
		Stack<Integer> stack = new Stack<>();
		//topo sort
		for(int i=0;i<N;i++){
		    if(vis[i]==0){
		        topoSort(i,adj,vis,stack);
		    }
		}
		
		
		//distance array
		
		int[] dist = new int[N];
		
		
		for(int i=0;i<N;i++){
		    dist[i] = Integer.MAX_VALUE;
		}
		//assign 0 to the src node;
		dist[0] = 0;
		
		int source = 0;
		
		//the source should always be the top/peek of the stack;
		while(stack.peek() != source){
		    stack.pop();
		}
		
		//validating the minimum distance from source to the each node
		while(!stack.isEmpty()){
		    int currNode = stack.pop();
		    
		    for(Pair4 pair:adj.get(currNode)){
		        int adjcntNode = pair.adjNode;
		        int wgt = pair.weight;
		        
		        if((dist[currNode]+wgt)<dist[adjcntNode]){
		            dist[adjcntNode] = dist[currNode]+wgt;
		        }
		    }
  
		}
		
		//we need to make -1 if not minimum path found because the component is not connected to the graph
		for (int i = 0; i < N; i++) {
                    if (dist[i] == Integer.MAX_VALUE) {
                        dist[i] = -1;
                    }
                }
		
		return dist;
		
	}
	
	//topo sort algo
	private void topoSort(int node, ArrayList<ArrayList<Pair4>> adj, int[] vis, Stack<Integer> stack){
	    vis[node] = 1;
	    
	    for(Pair4 adjPair4:adj.get(node)){
	        
	        if(vis[adjPair4.adjNode]==0){
	            topoSort(adjPair4.adjNode,adj,vis,stack);
	        }
	    }
	    
	    stack.push(node);
	}
	
	
	
}

class Pair4{
    int adjNode;
    int weight;
    
    Pair4(int adj, int wt){
        adjNode = adj;
        weight = wt;
    }
}