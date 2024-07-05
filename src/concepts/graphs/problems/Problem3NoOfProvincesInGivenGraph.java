package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem3NoOfProvincesInGivenGraph {
	//DFS approach
	public int findCircleNum(int[][] isConnected) {

        //converting the adj array to adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        //till here adj arr to adj list conversion

        //visitor array
        int vis[] = new int[isConnected.length];

        int province=0;

        //using DFS for finding out no of province...
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==0){
                
                dfs(i,adj,vis);
                province++;//counting number of province we have completed through DFS
            }
        }

        return province;
    }

    private void dfs(int node,ArrayList<ArrayList<Integer>> adj, int[] visitors){
        
        visitors[node]=1;//setting node is visited
        
        for(int it:adj.get(node)){
            if(visitors[it]==0){
                dfs(it,adj,visitors);//recursive for neighbor if not visited
            }
        }
    }
    
    
    //BFS approach
    public int findCircleNumBFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                bfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int city) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city);
        visited[city] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                if (isConnected[current][neighbor] == 1 && !visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

}
