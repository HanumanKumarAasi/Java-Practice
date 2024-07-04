package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem12KahnsAlgorithm {
	
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
