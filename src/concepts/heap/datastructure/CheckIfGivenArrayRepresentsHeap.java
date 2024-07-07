package concepts.heap.datastructure;

public class CheckIfGivenArrayRepresentsHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = {90, 15, 10, 7, 12, 2};
		countSub(arr,arr.length);		
	}
	
	public static boolean countSub(long arr[], long n)
    {
        // Your code goes here
        
        //as we know that left and right should always be less than the root node value
        //left : 2i+1
        //right: 2i+2
        
        for(int i=0;i<n;i++){
            int left = 2*i+1;
            int right = 2*i+2;
            
            if((left<n && arr[left]>arr[i]) || (right<n && arr[right]>arr[i])){
            
                return false;
            }
            
        }
        
        return true;
    }

}

