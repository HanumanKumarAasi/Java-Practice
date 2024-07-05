package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        ArrayList<Edge> edges = new ArrayList<>();
        
        //Preparing the edges which contains the dest node(v) from the (u)(i) with the weight
        for(int i=0;i<V;i++){
            //here i is the source of the edge
            for(int[] arr:adj.get(i)){
                int v = arr[0]; //v is the dest of the edge
                int wt = arr[1]; //wt of the edge
                
                //edges format
                
                Edge edge = new Edge(i,v,wt);
                edges.add(edge);
            }
            
        } 
        
        //sorting the edges into the ascending order based on their weights
        Collections.sort(edges);
        
        
        concepts.graphs.problems.DisJointSetBySize.DisjointSet ds = new concepts.graphs.problems.DisJointSetBySize.DisjointSet(V);
        
        int mstWt = 0;
        // M x 4 x alpha x 2
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            
            //we will checking if u and v are in the connected component if yes we ignore else we connect by union
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;
                
                //connecting u and v by unionbySize 
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
        
        
    }
}


class Edge implements Comparable<Edge>{
    int src,dest,weight;
    
    Edge(int s, int d, int w){
        this.src=s;
        this.dest=d;
        this.weight=w;
    }
    
    public int compareTo(Edge that){
        
        return this.weight-that.weight;
    }
}

