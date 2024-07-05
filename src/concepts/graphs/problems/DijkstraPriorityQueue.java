package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        //you will be given the adj list which contains list of adjNodes with node,distance pair dont confusue
        // 0->{{node:1,dist:9}}
        //1->{{node:0,dist:9}}
        
        //this is the undirected graph
        //we have implemented the comparator function inside the pq construtor(or we can implement the comparable interface in the Pair class and implement the compareTo function
        PriorityQueue<Pair5> pq = new PriorityQueue<Pair5>((x,y)->x.distance-y.distance);
        
        int distance[] = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        //Assigning src distance as 0
        distance[S] = 0;
        
        //Offering src and its distance first
        pq.offer(new Pair5(S,distance[S]));
        
        
        //normal bfs approach and comparing their distances and inserting the shortest path.
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            
            pq.remove();
            
            for(ArrayList<Integer> nodeDistVals:adj.get(node)){
                int currnode = nodeDistVals.get(0);
                int curredge = nodeDistVals.get(1);
                
                int totalDist = distance[node]+curredge;
                
                //adding the node,distance pair only when we find the shortest path for the curr node
                if(totalDist<distance[currnode]){
                    distance[currnode] = totalDist;
                    pq.add(new Pair5(currnode, distance[currnode]));
                }
            }
        }
        
        return distance;
        
       
        
        
    }
}


class Pair5{
    int node;
    int distance;
    
    Pair5(int n, int d){
        node = n;
        distance = d;
    }
    
}