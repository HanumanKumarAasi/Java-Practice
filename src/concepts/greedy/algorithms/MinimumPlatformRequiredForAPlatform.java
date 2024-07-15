package concepts.greedy.algorithms;

import java.util.Arrays;

public class MinimumPlatformRequiredForAPlatform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    //TC: O(N log N) SC:O(1)
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int count=0; // counting no of platforms
        
        int maxcount=0;// recording max platforms
        
        int i=0,j=0; //i for arrival pointer and j for departure pointer
        
        while(i<arr.length){
            if(arr[i]<=dep[j]){ // if arrival time <= departure time then will enter into the new platform
                i++;
                count++; //incrementing the count as we are entering the platform
                maxcount = Math.max(count,maxcount); // recording the ma xcount
            }else{
                j++; //else we are departing from the platform
                count--;//decrementing the platfrom count as train left
                
            }
        }
        
        return maxcount;//returning the maxcount which is the min no of platforms
        
    }
    
    //Also we can do by using the extra arraylist  which may take o(n) try this on ur own.

}
