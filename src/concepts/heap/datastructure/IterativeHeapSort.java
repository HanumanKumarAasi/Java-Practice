package concepts.heap.datastructure;

public class IterativeHeapSort {
	
	//Time Complexity: O(n log n), Here, both function buildMaxHeap and heapSort runs in O(nlogn) time.
	//Auxiliary Space: O(1)
	public static void main(String args[]) 
	  { 
	    int arr[] = {10, 20, 15, 17, 9, 21}; 
	    int n = arr.length; 
	  
	    System.out.println("ascending order");
	    heapSortAscendingOrder(arr, n); 
	    
	    for(int a:arr) {
	    	System.out.print(a+" ");
	    }
	    System.out.println();
	    System.out.println("decending order");
	    heapSortDecendingOrder(arr, n); 
	    
	    for(int a:arr) {
	    	System.out.print(a+" ");
	    }
	  
	    
	  } 
	
	//for increasing order
	static void buildMaxHeap(int[] arr, int size) {
		
		
		for(int i=1;i<size;i++) {
			if(arr[i]>arr[(i-1)/2]) {
				//we need to swap the parent with its child
				
				int j=i;//taking j and assigning i bcoz we need further more compare with its parents parent node as well to make it maxHeap
			
				while(j>=0 && arr[j]>arr[(j-1)/2]) {
					//swapping the parent with child
					int temp = arr[j];
					arr[j] = arr[(j-1)/2];
					arr[(j-1)/2] = temp;
					j=(j-1)/2;
				}
			}
		}
	}
	
	//for decreasing order
		static void buildMinHeap(int[] arr, int size) {
			
			
			for(int i=1;i<size;i++) {
				if(arr[i]<arr[(i-1)/2]) {
					//we need to swap the parent with its child
					
					int j=i;//taking j and assigning i bcoz we need further more compare with its parents parent node as well to make it maxHeap
				
					while(j>=0 && arr[j]<arr[(j-1)/2]) {
						//swapping the parent with child
						int temp = arr[j];
						arr[j] = arr[(j-1)/2];
						arr[(j-1)/2] = temp;
						j=(j-1)/2;
					}
				}
			}
		}
	
	
	static void heapSortAscendingOrder(int arr[], int n) 
	  { 
	    buildMaxHeap(arr, n); 
	  
	    for (int i = n - 1; i > 0; i--) 
	    { 
	      // swap value of first indexed 
	      // with last indexed 
	      swap(arr, 0, i); 
	  
	      // maintaining heap property 
	      // after each swapping 
	      int j = 0, index; 
	  
	      do
	      { 
	        index = (2 * j + 1); 
	  
	        // if left child is smaller than 
	        // right child point index variable 
	        // to right child 
	        
	        //here index should be less than i-1 bcoz index should not be the ith index that we have swapped bcoz we should not compare with the ith node bcoz it is apart of sorted ans which will always be greater
	        if (index < (i - 1) && arr[index] < arr[index + 1]) //index+1 ==> 2*i+1+1 which is a right node
	          index++; 
	  
	        // if parent is smaller than child 
	        // then swapping parent with child 
	        // having higher value 
	        if (index < i && arr[j] < arr[index]) //index should always be less than i
	          swap(arr, j, index); 
	  
	        j = index; 
	  
	      } while (index < i); 
	    } 
	  }
	
	static void heapSortDecendingOrder(int arr[], int n) 
	  { 
	    buildMinHeap(arr, n); 
	  
	    for (int i = n - 1; i > 0; i--) 
	    { 
	      // swap value of first indexed 
	      // with last indexed 
	      swap(arr, 0, i); 
	  
	      // maintaining heap property 
	      // after each swapping 
	      int j = 0, index; 
	  
	      do
	      { 
	        index = (2 * j + 1); 
	  
	        // if left child is smaller than 
	        // right child point index variable 
	        // to right child 
	        
	        //here index should be less than i-1 bcoz index should not be the ith index that we have swapped bcoz we should not compare with the ith node bcoz it is apart of sorted ans which will always be greater
	        if (index < (i - 1) && arr[index] > arr[index + 1]) //index+1 ==> 2*i+1+1 which is a right node
	          index++; 
	  
	        // if parent is smaller than child 
	        // then swapping parent with child 
	        // having higher value 
	        if (index < i && arr[j] > arr[index]) //index should always be less than i
	          swap(arr, j, index); 
	  
	        j = index; 
	  
	      } while (index < i); 
	    } 
	  }
	
	public static void swap(int[] a, int i, int j) { 
	    int temp = a[i]; 
	    a[i]=a[j]; 
	    a[j] = temp; 
	  }

}
