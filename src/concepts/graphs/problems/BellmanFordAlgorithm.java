package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int dist[] = new int[V];
        
        Arrays.fill(dist,(int)1e8); //filling initially all the distances as 10power8;
        
        dist[S]=0;
        
        for(int i=0;i<V;i++){
            for(ArrayList<Integer> path:edges){
                int u = path.get(0);
                int v = path.get(1);
                int wt = path.get(2);
                //dist[u] should not be infinity
                if(dist[u]!= 1e8 && dist[u]+wt < dist[v]){
                    if(i==V-1){
                        return new int[]{-1};//when we have negative cycle
                    }else{
                        dist[v] = dist[u]+wt;// recording shortest paths
                    }
 
                }
            }
        }
        
        
        
        return dist;
    }

}
