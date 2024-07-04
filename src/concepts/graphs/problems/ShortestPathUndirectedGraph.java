package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraph {
	//Q: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph-having-unit-distance
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        //converting edges to the adj list
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            //undirected graph consider both the edges like below
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        //distance matrix for recordding shortest path distance
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        //making src path as 0
        dist[src] = 0;
        
        //BFS approach considering queue DS pair
        Queue<Pair3> q = new LinkedList<>();
        
        //Inserting the src with distance 0 to the queue
        q.offer(new Pair3(src,0));
        
        //BFS loop
        while(!q.isEmpty()){
            int nod = q.peek().node;
            int dis = dist[nod];
            q.remove();
            for(int adjNode:adj.get(nod)){
                int tempDist = dis+1;
                //adding into the queue only when we consider current tempdist as shortest dist
                if(tempDist<dist[adjNode]){
                    dist[adjNode] = tempDist;
                    q.add(new Pair3(adjNode,tempDist));
                }
            }
        }
        
        //finally returning -1 for the vertices when we didnt find shortest path with them from the given vertices
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        
        return dist;
    }
}


class Pair3{
    int node;
    int distance;
    
    Pair3(int n, int d){
        node = n;
        distance = d;
    }
}