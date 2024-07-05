package concepts.graphs.problems;

public class FloydWarshallAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void shortest_distance(int[][] cost)
    {
        // Code here 
        //as per our thought process we are assigning infinity if there is no edge b/w 2 vertecies
        
        for(int i=0;i<cost.length;i++){
            for(int j=0;j<cost.length;j++){
                //this is a nxn matrix ntg but cost matrix they have given
                
                if(cost[i][j]==-1){
                    cost[i][j]=(int)1e9;
                }
            }
        }
        
        for(int via=0;via<cost.length;via++){
            for(int i=0;i<cost.length;i++){
                for(int j=0;j<cost.length;j++){
                    //if cost[i][j] is minimum than cost[i][via]+cost[via][j] dont consider
                    cost[i][j] = Math.min(cost[i][j],cost[i][via]+cost[via][j]);
                    
                }
            }
        }
        
        for(int i=0;i<cost.length;i++){
            if(cost[i][i]<0){
                //sysout("negative cycle detected");
            }
        }
        
        
        for(int i=0;i<cost.length;i++){
            for(int j=0;j<cost.length;j++){
                //this is a nxn matrix ntg but cost matrix they have given
                
                if(cost[i][j]==(int)1e9){
                    cost[i][j]=-1;
                }
            }
        }
    }

}
