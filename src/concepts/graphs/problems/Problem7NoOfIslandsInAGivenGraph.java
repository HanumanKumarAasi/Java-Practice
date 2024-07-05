package concepts.graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem7NoOfIslandsInAGivenGraph {

	// Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int visitor[][] = new int[n][m];
        
        int islands = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //finding out starting point which is not already visited and it is a 1
                if(grid[i][j]=='1' && visitor[i][j]==0){
                    bfs(grid,visitor,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void bfs(char[][] grid, int visitor[][], int row, int col){
        visitor[row][col]=1;//marking the starting point as visited
        Queue<Pair2> q = new LinkedList<Pair2>();
        
        q.add(new Pair2(row,col));
        
        int n=grid.length;
        int m=grid[0].length;
        
        while(!q.isEmpty()){
            //starting bfs from here and finding neighbor lands that are connected to each other until queue gets emepty
            int ro = q.peek().first;
            int co = q.peek().second;
            
            q.remove();
            
            //Finding all of its eight corners
            for(int delRow=-1;delRow<=1;delRow++){
                for(int delCol=-1;delCol<=1;delCol++){
                    int currRow = ro+delRow;
                    int currCol = co+delCol;
                    
                    //conditions that those 8 cornors under our limits(0->n(rows) and 0->m(cols))
                    if(currRow>=0 && currRow<n && currCol>=0 && currCol<m 
                    && grid[currRow][currCol]=='1' && visitor[currRow][currCol]==0){
                        visitor[currRow][currCol]=1;
                        q.add(new Pair2(currRow,currCol));
                    }
                }
            }
        }
    }

}

class Pair2{
    int first;
    int second;
    
    Pair2(int first, int second){
        this.first = first;
        this.second = second;
    }
}
