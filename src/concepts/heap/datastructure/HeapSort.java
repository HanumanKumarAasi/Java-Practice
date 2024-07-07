package concepts.heap.datastructure;

public class HeapSort {
	
	
	public static void main(String args[]) {
		int[]  arr= {4,10,3,5,1};
		
		System.out.println("ascending order");
		heapSortAscendingOrder(arr);
		
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
		System.out.println("decending order");
		heapSortDecendingOrder(arr);
		
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
	
	
	static void heapSortAscendingOrder(int arr[]) {
		//1.convert the given array to complete binary tree and perform the heapify for to make max heap
		buildMaxHeapDS(arr);
		
		
		
		//2.after converting to max heap remove the first node and swap with the last node and perform heapifying till that ith node
		
		for(int i=arr.length-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeapify(arr,i,0);
		}
		
		
	}
	
	static void heapSortDecendingOrder(int arr[]) {
		//1.convert the given array to complete binary tree and perform the heapify for to make max heap
		buildMinHeapDS(arr);
		
		
		
		//2.after converting to max heap remove the first node and swap with the last node and perform heapifying till that ith node
		
		for(int i=arr.length-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			minHeapify(arr,i,0);
		}
		
		
	}
	
	static void buildMaxHeapDS(int arr[]) {
		for(int i=(arr.length/2)-1;i>=0;i--) {
			maxHeapify(arr,arr.length,i);
		}
	}
	
	
	static void maxHeapify(int arr[], int size, int i) {
		int parentNodeIndex = i;
		int leftNodeIndex = 2*i+1;
		int rightNodeIndex = 2*i+2;
		
		
		if(leftNodeIndex<size && arr[leftNodeIndex]>arr[parentNodeIndex]) {
			parentNodeIndex = leftNodeIndex;
		}
		
		if(rightNodeIndex<size && arr[rightNodeIndex]>arr[parentNodeIndex]) {
			parentNodeIndex = rightNodeIndex;
		}
		
		if(parentNodeIndex!=i) {
			int temp = arr[parentNodeIndex];
			arr[parentNodeIndex] = arr[i];
			arr[i]=temp;
			maxHeapify(arr,size,parentNodeIndex);
		}
	}
	
	static void buildMinHeapDS(int arr[]) {
		for(int i=(arr.length/2)-1;i>=0;i--) {
			minHeapify(arr,arr.length,i);
		}
	}
	
	
	static void minHeapify(int arr[], int size, int i) {
		int parentNodeIndex = i;
		int leftNodeIndex = 2*i+1;
		int rightNodeIndex = 2*i+2;
		
		
		if(leftNodeIndex<size && arr[leftNodeIndex]<arr[parentNodeIndex]) {
			parentNodeIndex = leftNodeIndex;
		}
		
		if(rightNodeIndex<size && arr[rightNodeIndex]<arr[parentNodeIndex]) {
			parentNodeIndex = rightNodeIndex;
		}
		
		if(parentNodeIndex!=i) {
			int temp = arr[parentNodeIndex];
			arr[parentNodeIndex] = arr[i];
			arr[i]=temp;
			minHeapify(arr,size,parentNodeIndex);
		}
	}

}
