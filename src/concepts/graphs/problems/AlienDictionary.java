package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AlienDictionary {
	//Q: https://www.geeksforgeeks.org/problems/alien-dictionary/1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        //intial we need to construct the directed graph from the given dict by the adj word characters comparison
        
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        //comparison of characters from curr with next words
        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int len = Math.min(s1.length(),s2.length());
            
            for(int j=0; j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break; //we will break if we find put the difference in char
                }
            }
        }
        
        //we need to return the order of characters in Alien language
        int[] ints = topoSort(K,adj);
        
        //we need to convert this topo ints to chars
        String order = "";
        for(int i:ints){
            order = order+(char)(i+(int)('a'));
        }
        
        return order;
        
    }
    
    //topological sorting algorithm that works for different connected graphs
    private int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        //visitor array
        int vis[] = new int[V];
        int ans[] = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,stack,adj);
            }
        }
        
        for(int i=0;i<V;i++){
            ans[i] = stack.pop();
        }
        
        return ans;
        
        //return bfs(V,adj);
    }
    
    static void dfs(int currNode, int vis[], Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        vis[currNode]=1;
        
        for(int adjNode:adj.get(currNode)){
            if(vis[adjNode]==0){
                //we will be calling dfs only if not is not visited
                dfs(adjNode,vis,stack,adj);
            }
        }
        //adding the currnode to stack 
        stack.push(currNode);
    }
    
    
    //khans algorithm
    static int[] bfs(int V, ArrayList<ArrayList<Integer>> adj){
        
        int[] incomingedgesdegree= new int[V];
        
        //recording indegree edges
        for(int i=0;i<V;i++){
            for(int adjNode:adj.get(i)){
                incomingedgesdegree[adjNode]++;
            }
        }
        
        Queue<Integer> q =new LinkedList<>();
        
        for(int i=0;i<V;i++){
            //adding the nodes which has indegree 0
            if(incomingedgesdegree[i]==0){
                q.add(i);
            }
        }
        
        int[] ans = new int[V];
        int k=0;
        while(!q.isEmpty()){
            
            int curr = q.peek();
            q.remove();
            //adding the curr to ans list which is the topo
            ans[k++]=curr;
            for(int adjNode:adj.get(curr)){
                //decrasing the indegree of adjNode
                incomingedgesdegree[adjNode]--;
                
                if(incomingedgesdegree[adjNode]==0){
                    //adding the adjnode if its indegree is 0
                    q.add(adjNode);
                }
                
            }
            
        }
        
        return ans;
        
    }

}
