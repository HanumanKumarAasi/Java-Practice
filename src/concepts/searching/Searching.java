package concepts.searching;

import java.util.Arrays;

public class Searching {
	
	public static int linearSearch(int[] arr, int target) {
		if(target == arr[0]) return 0;
		else if(target == arr[arr.length-1]) return arr.length-1;
		
		int index = -1;
		
		for(int i=1;i<arr.length-1;i++) {
			if(target==arr[i]) {
				index = i;
			}
		}
		
		
		return index;
		
		
	}
	public static String sentinelLinearSearch(int[] arr, int target) {
		
		if(target == arr[0]) return "target found!";
		else if(target == arr[arr.length-1]) return "target found!";
		
		int last = arr[arr.length-1];
		arr[arr.length-1] = target;

		int i =0;
		while(arr[i]!=target) {
			i++;
		}
		arr[arr.length-1] =last;
		if(i<arr.length-1 || arr[arr.length-1]==target) return "target found!";
		else return "target not found!";
		
		
	}
	public static int binarySearch(int[] arr, int target) {
		if(target == arr[0]) return 0;
		else if(target == arr[arr.length-1]) return arr.length-1;
		
		int l=0;
		int r=arr.length-1;
		int count=0;
		
		while(l<=r) {
			count++;
			int mid = (l+r)>>>1; //mid = l+ (r-l)/2
		System.out.println(count);	
		if(arr[mid]==target) return mid;
			
			if(arr[mid]<target) l=mid+1;//checking in right array
			else r = mid-1; //checking in left array
		}
		
		return -1;
	}
	public static int binaryRecursiveSearch(int[] arr, int l, int r, int target) {
		if(l<=r) {
			
			int mid = l+(r-l)/2;
			if(arr[mid]==target) return mid;
			
			if(arr[mid]>target) {
				return binaryRecursiveSearch(arr, l, mid-1, target);
			}
			
			return binaryRecursiveSearch(arr, mid+1, r, target);
		}
		
		return -1;
	}
	public static int ternarySearch(int[] arr, int target) {
		int l=0;
		int r=arr.length-1;
		while(r>=l) {
			int mid1 = l+(r-l)/3;
			
			int mid2 = r-(r-l)/3;
			
			if(arr[mid1]==target) return mid1;
			if(arr[mid2]==target) return mid2;
			
			if(arr[mid1]<target && arr[mid2]>target) {
				l = mid1+1;
				r = mid2-1;
			}else if(arr[mid1]>target) {
				r=mid1-1;
			}else if(arr[mid2]<target) {
				l = mid2+1;
			}
			
		}
		
		
		
		return -1;
		
	}
	
	public static int ternaryRecursiveSearch(int[] arr, int l, int r, int target) {
		if(l<=r) {
			int mid1 = l+(r-l)/3;
			
			int mid2 = r-(r-l)/3;
			
			if(arr[mid1]==target) return mid1;
			if(arr[mid2]==target) return mid2;
			
			if(arr[mid1]<target && arr[mid2]>target) {
				return ternaryRecursiveSearch(arr, mid1+1, mid2-1, target);
			}else if(arr[mid1]>target) {
				return ternaryRecursiveSearch(arr, l, mid1-1, target);
			}else if(arr[mid2]<target) {
				return ternaryRecursiveSearch(arr, mid2+1, r, target);
			}
			
		}
	
		return -1;
		
	}
	
	public static int jumpSearch(int[] arr, int target){
		
		//calculate the block size - so these many blocks needs to be divided and find the block index that is greater than target
		int size = arr.length; //array length
		
		if(arr[0]==target) return 0;
		if(arr[size-1] == target) return size-1;
		
		if(size>2) {
			int block = (int) Math.floor(Math.sqrt(size)); // block size for diving array into that many block
			int maxRange = 0; // max range limit that target may exists
			int minRange = 0; // min range limit that target may exists
			int temp=0;// temp value if target doesnt get compared in the loop because we may need findout the target from lastblockindex+1 to lastIndex
			for(int i=0;i<size;i+=block) {
				if(arr[i]>=target) {
					maxRange = i;//assingning maxRange
					if(i>block) {
						minRange = i-block;//assinging minRange				
					}
					break;
				}
				temp=i;// assigning temp for future reference when target doesnt found in the comparison within the max blockindex
			}
			if(maxRange<=0) {
				maxRange=size-1;//need to search till end
				minRange = maxRange-temp;// if not found till maxblock index, in that case we need find from that index to last index;
			}
			
			//linear search for finding the target...
			while(minRange<=maxRange){
				
				if(arr[minRange]==target) return minRange;
				
				minRange++;		
			}
		}
		//returning -1 if no target found
		return -1;		
	}

	
	public static int interpolationSearch(int[] arr, int low, int high, int target) {
		
		while(low<=high && arr[low]<=target && arr[high]>=target) {
			
			//calculating the pos
			int pos = low+ ((high-low)*(target-arr[low]))/(arr[high]-arr[low]);
			
			
			if(arr[pos]==target) return pos;
			
			if(arr[pos]>target) return interpolationSearch(arr, low, pos-1, target);
			
			if(arr[pos]<target) return interpolationSearch(arr, pos+1, high, target);
		}
		
		
		
		return -1;
	}
	
	public static int exponentialBinarySearch(int[] arr, int target) {
		int size =  arr.length;
		if(arr[0]==target) return 0;
		
		if(arr[size-1]==target) return size-1;
		
		int i =1;
		while(i<size && arr[i]<=target) {
			i*=2;//expoentially increasing till target index is lesser than to it
		
		}
		
		int low = i/2;
		int high = i;
		
		//recursive binary search
		//return Arrays.binarySearch(arr, i/2, i, target);
		
		//iterative approach
		while(low<=high) {
			int mid =  low+(high-low)/2;
			
			if(arr[mid]==target) return mid;
			
			if(arr[mid]<target) low=mid+1;
			
			if(arr[mid]>target) high=mid-1;
		}
		
		
		
		return -1;
	}
	
	
	public static int fabinociSearch(int[] arr, int target) {
		
		int n=arr.length;
		
		if(arr[0]==target) return 0;
		
		if(arr[n-1]==target) return n-1;
		
		int count=0;
		int f1 = 0;
		int f2 = 1;
		int f=f1+f2; //{ 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100,235};
		while(f<n && arr[f] <= target ) { //80
			f1=f2;// 1 1 2 3
			f2=f;// 1 2 3 5
			f=f1+f2;// 2 3 5 8
			count++;
		}
		
		//calculate the mid for f and f2
		int l = f2;
		int h = f;
		
		while(l<=h) {
			count++;
			int mid = l+(h-l)/2;
			System.out.println(count);
			if(arr[mid]==target) return mid;
			
			if(arr[mid]<target) l=mid+1;
			
			if(arr[mid]>target) h=mid-1;
		}
		
		
		return -1;
	}
	
	
	public static void main(String args[]) {
		
		int arr[] = {10, 50, 30, 70, 80, 20, 90, 40};
		int target = 100;
		
		int linearindex = linearSearch(arr, target);
		
		if(linearindex>=0) {
			System.out.println("target found!"+ linearindex);
		}else {
			System.out.println("target not found!");
		}
		
		System.out.println(sentinelLinearSearch(arr, target));
		int arr1[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
		
		int binaryindex = binarySearch(arr1, 2);
		
		if(binaryindex>=0) {
			System.out.println("target found!"+ binaryindex);
		}else {
			System.out.println("target not found!");
		}
		
		int binaryrecursiveindex = binaryRecursiveSearch(arr1, 0, arr.length-1, target);
		
		if(binaryrecursiveindex>=0) {
			System.out.println("target found!"+ binaryrecursiveindex);
		}else {
			System.out.println("target not found!");
		}
		
		int ternaryIndex = ternarySearch(arr1, target);
		
		if(ternaryIndex>=0) {
			System.out.println("target found!" + ternaryIndex);
		}else {
			System.out.println("target not found!");
		}
		
		int ternaryRecursiveIndex = ternaryRecursiveSearch(arr1, 0, arr.length-1, target);
		
		if(ternaryRecursiveIndex>=0) {
			System.out.println("target found!" + ternaryRecursiveIndex);
		}else {
			System.out.println("target not found!");
		}
		
		int jumpSearchArray[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};;
		int jumpSearchIndex = jumpSearch(jumpSearchArray,144);
		
		if(jumpSearchIndex>=0) {
			System.out.println("target found!" + jumpSearchIndex);
		}else {
			System.out.println("target not found!");
		}
		
		
		int interpolationSearchArray[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
		int interpolationSearchIndex = interpolationSearch(interpolationSearchArray,0,interpolationSearchArray.length-1,144);
		
		if(interpolationSearchIndex>=0) {
			System.out.println("target found!" + interpolationSearchIndex);
		}else {
			System.out.println("target not found!");
		}
		System.out.println();
		
		int exponentialSearchArray[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
		int exponentialSearchIndex = exponentialBinarySearch(exponentialSearchArray,2);
		
		if(exponentialSearchIndex>=0) {
			System.out.println("target found!" + exponentialSearchIndex);
		}else {
			System.out.println("target not found!");
		}
		System.out.println();
		
		
		int fabinocciSearchArray[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
		int fabinocciSearchIndex = fabinociSearch(fabinocciSearchArray,2);
		
		if(fabinocciSearchIndex>=0) {
			System.out.println("target found!" + fabinocciSearchIndex);
		}else {
			System.out.println("target not found!");
		}
		System.out.println();
	}

}
