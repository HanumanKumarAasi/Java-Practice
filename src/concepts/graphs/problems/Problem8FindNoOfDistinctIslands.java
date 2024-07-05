package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.HashSet;


//DFS approach
public class Problem8FindNoOfDistinctIslands {
//Q: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
	void dfs(int row, int col, int[][] vis, int[][]grid, ArrayList<String> list, int row0, int col0){
        //row0,col0 are the starting point indexes;
        
        vis[row][col]=1;//marking the starting point as visited
        
        //adding the land indexes to list by subtracting the reference start index;
        list.add(toString(row-row0,col-col0));
        
        
        int n=grid.length;
        int m=grid[0].length;
        
        
        //4 neighbors
        int delRows[] = {-1,0,1,0};
        int delCols[] = {0,-1,0,1};
        
        for(int i=0;i<4;i++){
            int nrow = row+delRows[i];
            int ncol = col+delCols[i];
            //condition for checking adj lands
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1
    						&& vis[nrow][ncol] == 0) {
    				dfs(nrow,ncol,vis,grid,list,row0,col0);	// recursive call	    
            }
        }
    
    }
    
     String toString(int row, int col){
        return Integer.toString(row)+" "+Integer.toString(col);
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        
        int rows =grid.length;
        int cols = grid[0].length;
        
        int vis[][] = new int[rows][cols];
        
        //set to store distinct graphs
        HashSet<ArrayList<String>> distinctSet = new HashSet<>();
        
        //finding out the starting landing in the given graph and will start traversing
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    //list to store all the connected 1 indexes
                ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    
                    distinctSet.add(list);
                    
                }
            }
        }
        
        
        return distinctSet.size();
        
        
        
    }
    
    
}   

