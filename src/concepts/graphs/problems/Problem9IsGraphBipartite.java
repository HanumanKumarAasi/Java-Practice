package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem9IsGraphBipartite {
	
	
	public static void main(String args[]) {
		
		int arr[][] = {{1,2},{0,2},{0,1}};
		
		System.out.println(isBipartite(arr));
	}
	
	
	
	public static boolean isBipartite(int[][] graph) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[graph.length];

        Queue<Integer> q = new LinkedList<>();
    for(int i=0;i<graph.length;i++){
        if(color[i]==0){
            q.add(i);
            color[i]=1;
            while(!q.isEmpty()){

                int currNode = q.peek();
                q.remove();

                //we need to go through with the each adjacent node of the curr node

                for(int adjNode:adj.get(currNode)){

                    //if adjNode color is not colored the we will be putting opp color of the curr node
                    if(color[adjNode]==0){
                        color[adjNode]=3-color[currNode];
                        q.add(adjNode);
                    }else if(color[adjNode]==color[currNode]){ 
                        // if adjNode is color then it should not be the sam color like the color node, if it is same we will return false
                        return false;
                    }
                }

            }
        }
        

    }
    return true; 
    
    //DFS approach is in below.
    
//    int color[] = new int[graph.length];
//
//    for(int i=0;i<graph.length;i++){
//        if(color[i]==0){
//           if(!dfs(color,graph,1,i)){
//            return false;
//           }
//        }
//    }
//
//
//
//    return true;
    
}
	
	   
    



private boolean dfs(int[] color, int[][] graph, int col, int currNode){
    color[currNode]=col;

    for(int adjNode: graph[currNode]){
        if(color[adjNode]==0){
            if(!dfs(color, graph,3-col,adjNode)){
                return false;
            };
        }else if(color[adjNode]==color[currNode]){
            return false;
        }
    }
    return true;
}

}
