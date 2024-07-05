package concepts.graphs.problems;

import java.util.ArrayList;

public class ArticulationPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ArticulationPointsSolution
{
    int timer = 0;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        int vis[] = new int[V];
        
        int timeInsertion[] = new int[V];
        
        int low[] = new int[V];
        
        //mark array used for marking the articulated node
        int mark[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,-1, vis, timeInsertion, low, mark, adj);
            }
        }
        
        
        //preparing the articulated nodes as ans
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        
        if(ans.size()==0){
            ans.add(-1);
            return ans;
        }
        return ans;
    }
    
    void dfs(int node, int parent , int[] vis,int[] timeInsertion,int[] low,int[] mark,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        timeInsertion[node]=low[node]=timer;
        timer++;
        int child=0; //this for graph height as 1 and considering the parent/src node containing multiple childs by removing the parent/src node we can have multiple graphs
        for(int adjNode:adj.get(node)){
            if(vis[adjNode]==0){
                dfs(adjNode,node,vis, timeInsertion, low, mark, adj);
                low[node] = Math.min(low[node],low[adjNode]); //as this is the non visited adj node we consider low[node] as min of low[node],low[adjNode] which got returned
                
                //condition low[adjNode] is greater than or equal to the time[node] and node parent is not -1 then ot would be the articulation point.
                if(low[adjNode]>=timeInsertion[node] && parent!=-1){
                    mark[node]=1;
                }
                child++; //we will be incrementing only if it is not visited
            }else{
                //if the node is already visited then in that case we will consider the low[node] as min of low[node], timeIndertion[adjNode]
            }   low[node] = Math.min(low[node],timeInsertion[adjNode]);
        }
        
        if(child>1 && parent==-1){
            mark[node]=1;
        }
        
    }
    
    
}
