package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithimSumOfMinimumSpanningTree {
	
	//Q: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

	static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        //requirements
        //PriorityQueue, MST array, sum, visitor;
        
        
        //adj list
        
        ArrayList<ArrayList<Pair6>> adjList= new ArrayList<>();
        
        
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<Pair6>());
        }
        
        //Preparing the adjList which contains the dest node(v) from the (u)(i) with the weight
        for(int i=0;i<V;i++){
            
            for(int[] arr:adj.get(i)){
                int v = arr[0];
                int wt = arr[1];
                adjList.get(i).add(new Pair6(v,wt));
            }
            
        }
        
        //visitor pattern
        int vis[] = new int[V];
        
        //sum variable
        int sum = 0;
        
        //pq data stucture
        PriorityQueue<Pair6> pq = new PriorityQueue<Pair6>((x,y)->x.weight-y.weight);
        
        pq.add(new Pair6(0,0));
        
        
        //TC: ElogV
        while(!pq.isEmpty()){
            int currNode = pq.peek().node;
            int currWeight = pq.peek().weight;
            pq.remove();
            //if the currNode is already visited no need of visit again
            if(vis[currNode]==1) continue;
            
            vis[currNode]=1; //making the currnode visited
            sum+=currWeight; //summing up with currNode weight
            
            //getting the adjedges of the currnode and adding it to the PQ.
            for(Pair6 pair:adjList.get(currNode)){
                if(vis[pair.node]==0){
                    pq.add(new Pair6(pair.node,pair.weight));
                }
            }
            
            
        }
        
        
        //returning the sum
        return sum;   
    }
}

class Pair6{
    int node;
    int weight;
    
    Pair6(int n, int w){
        node=n;
        weight=w;
    }
}