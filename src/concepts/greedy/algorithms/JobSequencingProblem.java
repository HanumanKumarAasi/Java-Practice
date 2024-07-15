package concepts.greedy.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 //O(N*maxDeadline)
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        //comparator for sorting the arr based on job profit
        Comparator<Job> comparator = (a,b)->{
            
            return b.profit - a.profit;
        };
        
        //sorting the 
        Arrays.sort(arr,comparator);
        
        
        //for maxDeadLine from the given array
        int maxDeadLine = 0;
        for(Job job:arr){
            maxDeadLine = Math.max(maxDeadLine,job.deadline);
        }
        
        //hash array for inserting the visited deadline 
        int hash[] = new int[maxDeadLine+1];
        
        Arrays.fill(hash,-1);// initalize will -1 for all
        int count = 0; // for no of jobs done
        int totalProfit = 0;// for max profit made
        for(int i=0;i<n;i++){ // iterating through the loop O(N)
            //O(maxDeadline)
            for(int j=arr[i].deadline;j>0;j--){ //if the deadline is already occupied we will check before days of the deadline and will put that in the no visited deadline
                if(hash[j]==-1){ //checking if we reached that deadline or not, if not we add the profit and markit with th job id
                    hash[j]=arr[i].id; // adding id for making hash of that index is visited
                     count++; //counter for jobs
                     totalProfit+=arr[i].profit;// total profit
                     break;// breaking bcoz we have done the job
                }
            }
 
            
        }
        
        return new int[]{count,totalProfit};//returning the result
    }

}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
