package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BridgeConnectionsSolution {

    int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();


        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(List<Integer> lt:connections){
            int u = lt.get(0);
            int v = lt.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int vis[] = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        int timeInsertion[] = new int[n];
        int low[] = new int[n];

        int node = 0; // intially considering 0 as source.

        int parent = -1; //initially the parent of src will always be -1

        dfs(node,parent,vis,adj,timeInsertion,low,bridges);

        return bridges;

    }

    void dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj, int timeInsertion[], int low[],
    List<List<Integer>> bridges){
        vis[node]=1;
        timeInsertion[node]= low[node] = timer; //incrementing the timesInsertiona and low by 1 for eaach node
        timer++;
        for(int adjNode:adj.get(node)){

            if(adjNode==parent) continue; //as it is undirected graph, if the adjNode is parent we can ignore the, bcoz from parent only we have started the dfs.

            if(vis[adjNode]==0){
                dfs(adjNode,node,vis,adj,timeInsertion,low,bridges);
                low[node] = Math.min(low[node],low[adjNode]); //considering the low[node] as min of low of node, adjnode

                if(low[adjNode]>timeInsertion[node]){ //if low of adjnode is greater than the timeInsertion of node then we have found the bridge add into bridges
                    bridges.add(Arrays.asList(node,adjNode));
                }
            }else{
                //if we have already visited the adjNode then we will bother only for low of node and adjnode and will take up the minimum one.
                low[node] = Math.min(low[node],low[adjNode]);
            }

        }
    }
}
