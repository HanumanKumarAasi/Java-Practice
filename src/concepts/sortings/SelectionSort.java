package concepts.sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SelectionSort {
	
	private static Object[] output;

	public static void main(String args[]) {
		/*
		 * int arr[] = {1,9,2,5,1,2,8,3,0,4,7,6}; System.out.println("Selection sort");
		 * for(int i:selectionSorting(arr)) { System.out.print(i+" "); }
		 * System.out.println(); int arr1[] = {1,9,2,5,1,2,8,3,0,4,7,6};
		 * System.out.println("Bubble sort"); for(int i:bubbleSorting(arr1)) {
		 * System.out.print(i+" "); } System.out.println(); int arr2[] =
		 * {1,9,2,5,1,2,8,3,0,4,7,6}; System.out.println("insertion sort"); for(int
		 * i:insertionSort(arr2)) { System.out.print(i+" "); }
		 */
		
		
		/*
		 * System.out.println();
		 * 
		 * int arr3[] =
		 * {20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10
		 * ,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15
		 * ,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6
		 * ,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,
		 * 18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,
		 * 5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,
		 * 14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,
		 * 2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,
		 * 16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,
		 * 20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,
		 * 13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,
		 * 3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,
		 * 7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,
		 * 18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,
		 * 5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,
		 * 14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,
		 * 2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,
		 * 16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,
		 * 20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,
		 * 13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,
		 * 3,11,20,1,4,2,0,9,5,8,6,7,10,13,17,16,12,14,19,18,15,3,11,20,1,4,2,0,9,5,8,6,
		 * 7,10,13,17,16,12,14,19,18,15,3,11};
		 */
		  
			int arr7[] = {10,14,28,11,7,16,30,50,25,18};
			  System.out.println("shell sort");
			  
			  for (int i : shellSort(arr7)) { System.out.print(i + " "); }
			 
		 
		
			/*
			 * int arr4[] = {3,1,2,4,1,5,2,6,4}; System.out.println("merge sort");
			 * mergeSort(arr3, 0, arr3.length-1); for(int i:arr3) { System.out.print(i+" ");
			 * }
			 */
		
			
			/*
			 * int arr5[] = { 4, 6, 2, 5, 7, 9, 1, 3 }; System.out.println("quick sort");
			 * quickSort(arr5, 0, arr5.length - 1); for (int i : arr5) { System.out.print(i
			 * + " "); }
			 */
			 
		
			/*
			 * int arr6[] = {4,6,2,5,7,9,1,3}; System.out.println("count sort");
			 * countSort(arr6); for(int i:arr6) { System.out.print(i+" "); }
			 */  
		  
			/*
			 * int arr8[] = {29,83,471,36,91,8}; System.out.println("raidx sort");
			 * radixSort(arr7); for(int i:arr7) { System.out.print(i+" "); }
			 */
		
	}
	
	
	public static int[] selectionSorting(int[] arr) {
		/*
		 * selection sorting algo will send least element to its left, it will always take <n-1 operations 
		 * to sort the elements.
		 * 
		 * In selection sort in each iteration we will be sending smallest element to its correct place
		 *
		 *and at every parent iteration we can start iterating the child iteration through i+1th thorugh last
		 *element
		 *
		 *TC at best/worst/average - O(N^2) SC- O(1)
		 */
		for(int i=0;i<arr.length-1;i++) {
			
			int min=i;
			int swap=0;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					int temp = arr[min];
					arr[min] = arr[j];
					arr[j] = temp;
					swap++;
				}
				
			}
			if(swap==0)  break;
			
		}
		return arr;
	}
	
	
	public static int[] bubbleSorting(int[] arr) {
		/*
		 * Bubble sort is a sorting algorithm that sends the greatest element to the
		 * last by comparing the adjacent elements and swapping them if element is
		 * greater than adjacent element.
		 * 
		 * and at every parent iteration we can iterate the child iteration through <n-1-ith 
		 * element
		 * 
		 * TC - best: O(N) worst/avergae: O(N^2) SC-O(1)
		 */
		
		for(int i=0;i<=arr.length-1;i++) {
			int swap = 0;
			for(int j=0;j<arr.length-i-1;j++) {
				
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap++;
				}
				
			}
			//best TC:O(n)
			//worst/average TC:O(n^2)
			if(swap==0) {
				break;
			}
			
		}
		return arr;
	}
	
	
	public static int[] insertionSort(int[] arr) {
		//Insertion sorting will take up each element and comapare with its left most ele's and puts into its correct position
		//best TC:O(n)
		//worst/average TC:O(n^2)
		// SC: O(1)
		for(int i=1;i<arr.length;i++) {
			
			int swap=0;
			int j=i;
			while(j>0 && arr[j-1]>arr[j]) {
				swap++;
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;			
				j--; // becoz it will comparing the left elements for swapping to its correct position
			}
			
		}
		return arr;
	}
	
	
	public static int[] shellSort(int[] arr) {
		for(int gap = arr.length/2;gap>0;gap/=2) { //arr.length = 8 then gap=4
			for(int i=gap;i<arr.length;i++) { //this loop is used to map the elements according to the gap lets say index mapping{0->4,1->5,2->6} because gap is 4
				for(int j=i;j>=gap && arr[j-gap]>arr[j];j-=gap) {
					int temp = arr[j-gap];
					arr[j-gap] = arr[j];
					arr[j] = temp;
				}
				
			}
			for(int i:arr) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
        return arr;
	}
	
	
	public static void mergeSort(int[] arr, int low, int high) {
		//Merge sort will follow the divide and merge pattern
		//TC: O(NlogN) - Best/worst/average
		//SC: O(N) using list during the merge operation
		if(low>=high) return;
		
		int mid = (low+high)/2;
		
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
		
		
	}
	
	
	public static void merge(int[] arr, int low, int mid, int high) {
		
		//Create an empty data-structure like vector, arraylist, linkedList
		ArrayList<Integer> list = new ArrayList<>();
		int left = low; // start index of first array
		int right = mid+1; // start index of second array
		while(left<=mid && right<=high) {
			if(arr[left]<arr[right]) {
				list.add(arr[left]);
				left++;
			}else {
				list.add(arr[right]);
				right++;
			}
		}
		
		//we need to add remaining elements which are remained after comparison with both the arrays, these can be directly added as they will sorted elements already
		while(left<=mid) {
			list.add(arr[left]);
			left++;
		}
		
		while(right<=high) {
			list.add(arr[right]);
			right++;
		}
		
		//after adding all the elements to the list we need to put these in our original array based on their indexes;
		
		for(int i=low;i<=high;i++) {
			arr[i] = list.get(i-low);
		}
	}
	
	
	public static void quickSort(int[] arr, int low, int high) {
		//pivot and partition index operation 
		////TC: O(NlogN) - Best/average
		// O(N^2) in worst case
		//SC: O(1)
		if(low<high) {
		int partitionIndex = quickSortFunction(arr,low,high);
		quickSort(arr,low,partitionIndex-1);
		quickSort(arr,partitionIndex+1, high);
		}
	}
	
	public static int quickSortFunction(int[] arr, int low, int high) {
		int pivot = low;
		int i=low;
		int j=high;
		//when ever we are crossing the i with the j in that case we are entering into the lowest elements tertiary that means those ele's are lesser than pivot element
		while(i<j) {
			//check for the highest value that is greater than pivot from the left index, if not fount increment i
			while(arr[i]<=arr[pivot] && i<=high-1) {
				i++;
			}
			//check for the lowest value that is lesser than pivot from the right index, if not found decrement j
			while(arr[j]>arr[pivot] && j>=low+1) {
				j--;
			}
				//swap the highest value element with the lowest value element
				if(i<j) {
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
			}
		}
		//swaping the pivot element into its correct position
		int temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;
		
		return j;
	}
	
	
	
	public static void countSort(int[] arr) {
		int max = arr[0];
		//1. finding the largest element TC=O(N)
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		//2. creating the new Count array for storing the count of each element who length is max+1
		int[] countArray = new int[max+1];
		
		//3. traverse all the elements and record the count the each ele and store in its particular index
		//TC - O(M)
		for(int num:arr) {
			countArray[num]++;
		}
		
		//Also we can use HashMap instead of Array as countMap
		Map<Integer, Integer> countMap = new  HashMap<>();
		for(int num:arr) {
			countMap.put(num, countMap.getOrDefault(num,0)+1);
		}
		
		
		//4. replace the original array using countArray TC-O(M)
		/*
		 * int index=0; for(int i=0;i<=max;i++) { while(countArray[i]>0) { arr[index]=i;
		 * index++; countArray[i]--; } }
		 */
		
		//4. replace the original array using countMap TC-O(M)
				int index1=0;
				for(int i=0;i<=max;i++) {
					while(countMap.getOrDefault(i,0)>0) {
						arr[index1]=i;
						index1++;
						countMap.put(i, countMap.getOrDefault(i,0)-1);
					}
				}
		
		//Total TC - O(N+2M) - O(N+M)
		//SC - O(M) for new Array

	}
	
	public static void radixSort(int[] arr) {
		//29 83 471 36 91 8
		//TC: O(NK) worst/average k-number of digits in largest number
		//TC: best case O(N+K) if it is already sorted
		//SC: O(N+K)
		int max = Arrays.stream(arr).max().getAsInt();
		
		
		for (int place = 1; max / place > 0; place *= 10)  
		    countingSort(arr, arr.length, place); 
		
	}
	
	private static void countingSort(int a[], int n, int place) // function to implement counting sort  
	{  
		  int output[] = new int[n];  
		  int count[] = new int[10];    
		  
		  // Calculate count of elements  
		  for (int i = 0; i < n; i++)  
		    count[(a[i] / place) % 10]++;  
		      
		  // Calculate cumulative frequency  
		  for (int i = 1; i < 10; i++)  
		    count[i] += count[i - 1];  
		  
		  // Place the elements in sorted order  
		  for (int i = n - 1; i >= 0; i--) {  
		    output[count[(a[i] / place) % 10] - 1] = a[i];  
		    count[(a[i] / place) % 10]--;  
		  }  
		  
		  for (int i = 0; i < n; i++)  
		    a[i] = output[i];  
		}  
	
	
	
	
	
	

}
