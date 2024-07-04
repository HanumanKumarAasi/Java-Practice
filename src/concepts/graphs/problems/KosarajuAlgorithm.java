package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class KosarajuAlgorithmSolution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        
        //sorting the edges according to the first finished one
        int vis[] = new int[V];
        
        //to store all the node according to their finished time
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
        }
        
        ArrayList<ArrayList<Integer>> revadj = new ArrayList<>();
        
        
        for(int i=0;i<V;i++){
            revadj.add(new ArrayList<Integer>());
        }
        
        //reversing the edges like this (0->{2,3} => 2->0 , 3->0)
        for(int i=0;i<V;i++){
            vis[i]=0; //resusing vis to 0 to reuse for step-3 dfs
            for(int adjNode:adj.get(i)){
                revadj.get(adjNode).add(i);
            }
        }
        
        //req for no of scc
        int scc=0;
        
        
        //req for printing of scclist
        ArrayList<ArrayList<Integer>> scclist = new ArrayList<>();
        while(!st.isEmpty()){
            int node = st.pop();
            ArrayList<Integer> sccs = new ArrayList<>();
            if(vis[node]==0){
                scc++;
                dfsForScc(node,revadj,vis,sccs);
                
                //adding sccs to scclist
                scclist.add(sccs);
            }
        }
        
        return scc;
        
    }
    
    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st){
        vis[node]=1;
        
        for(int adjNode:adj.get(node)){
            if(vis[adjNode]==0){
                dfs(adjNode,adj,vis,st);
            }
        }
        
        //pushing the finished node into the stack
        st.push(node);
    }
    
    
    //step:3 finding out the sccs
    void dfsForScc(int node, ArrayList<ArrayList<Integer>> revadj, int[] vis, ArrayList<Integer> sccs){
        vis[node]=1;
        
        for(int adjNode:revadj.get(node)){
            if(vis[adjNode]==0){
                dfsForScc(adjNode,revadj,vis,sccs);
            }
        }
        
        //adding scc node to list
        sccs.add(node);
    }
}
