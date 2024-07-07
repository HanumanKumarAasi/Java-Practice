package concepts.heap.datastructure;

public class MaxHeap {

	//arr for storing of nodes
	int arr[];
	
	//declaring the MaxHeap with the maxsize
	int maxsize;
	
	//Heap size
	int heapSize;
	
	//MaxHeap constructor
	MaxHeap(int size){
		maxsize = size;
		arr = new int[maxsize];
		heapSize=0;
	}
	
	//inserting the node into the heap
	void insertNode(int val) {
		if(heapSize==maxsize) {
			System.out.println("max heap limit exceeded....");
			return;
		}
		
		//as we are adding the val into heap so incrementing heapsize
		heapSize++;
		
		int i = heapSize-1;//consider the curr val position in the heap DS
		
		//stroing the val in that curr poisition in heap
		
		arr[i] = val;
		
		//suppose if we have multiple values in our heap while inserting the node val into the heap may imbalance the heap, so we are performing below ops to make heap balance
		//if i=0, it is the parent so there are no other elements to verify
		while(i!=0 && arr[parent(i)]<arr[i]) {//here the parent of any node should not be lessthan its child node
			int temp = arr[parent(i)];
			arr[parent(i)] = arr[i];
			arr[i] = temp;
			i=parent(i); // this is because if we have changes the of the nodes parent, the parent of its parent may be less than to it, so we need check them as well till the root node i.e i=0;
		}
	}
	
	//removing the max node
	int removeMax() {
		//if heap is empty
		if(heapSize<=0) {
			return Integer.MIN_VALUE;
		}
		
		//heap with unit size=1
		if(heapSize==1) {
			heapSize--;
			return arr[0];
		}
		
		int root = arr[0]; //remove max means removing the root(arr[0])
		
		//after removing the root, we make last node as the current root node
		
		arr[0] = arr[heapSize-1]; //heapSize-1 node is the last node
		heapSize--;
		//there is chance of distortion of heap property, so to restore we need to heapify the current heap;
		maxHeapify(0);
		
		return root;
	}
	
	//heapify the distorted heap into its original behavior
	void maxHeapify(int i) {
		// TODO Auto-generated method stub
		int leftNodeIndex = leftChild(i); //2i+1;
		int rightNodeIndex = rightChild(i); //2i+2;
		int parentNodeIndex = i;
		
		if(leftNodeIndex<heapSize && arr[leftNodeIndex]>arr[parentNodeIndex]) {
			
			int temp = arr[parentNodeIndex];
			arr[parentNodeIndex] = arr[leftNodeIndex];
			arr[leftNodeIndex] = temp;
			parentNodeIndex = leftNodeIndex;
		}
		
		if(rightNodeIndex<heapSize && arr[rightNodeIndex]>arr[parentNodeIndex]) {
			
			int temp = arr[parentNodeIndex];
			arr[parentNodeIndex] = arr[rightNodeIndex];
			arr[rightNodeIndex] = temp;
			parentNodeIndex = rightNodeIndex;
		}
		if (parentNodeIndex != i) {
			maxHeapify(parentNodeIndex); //now the parentNodeIndex is the updated node index;
		}
	}

	//right node
	private int rightChild(int i) {
		// TODO Auto-generated method stub
		return (2*i+2);
	}

	//left node
	private int leftChild(int i) {
		// TODO Auto-generated method stub
		return (2*i+1);
	}

	//to get the parent of current node
	int parent(int currentIndex) {
		int parentOfCurrent = (currentIndex-1)/2;
		return parentOfCurrent;
	}
	
	//updating the particular node value based on their key
	void updateNodeVal(int nodeKey, int newVal) {
		//we have updated the particular node value.
		arr[nodeKey] = newVal;
		
		//after updation we need to re-arrange;
		while (nodeKey != 0 && arr[parent(nodeKey)] < arr[nodeKey]) { 
            int temp = arr[nodeKey]; 
            arr[nodeKey] = arr[parent(nodeKey)]; 
            arr[parent(nodeKey)] = temp; 
            nodeKey = parent(nodeKey); 
        }
	}
	
	
	//deleting the nodeKey
	void deleteNodeKey(int nodeKey) {
		//updating the nodeKey with Integer max value so that it will become thee root of the node after heapify
		updateNodeVal(nodeKey,Integer.MAX_VALUE);
		
		//after updation with the Int max, we will remove the root;
		removeMax();
	}
	
	//getting max value from the heap
	int getMax() { 
        return arr[0]; 
    } 
  
	//current heap size
    int curSize() { 
        return heapSize; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxHeap h = new MaxHeap(15); 
		  
        // Asking the user to input the keys: 
        System.out.println("Entered 6 keys:- 3, 10, 12, 8, 2, 14 \n"); 
        h.insertNode(3); 
        h.insertNode(10); 
        h.insertNode(12); 
        h.insertNode(8); 
        h.insertNode(2); 
        h.insertNode(14); 
  
        // Printing the current size 
        // of the heap. 
        System.out.println("The current size of the heap is "
                + h.curSize() + "\n"); 
  
        // Printing the root element which is 
        // actually the maximum element. 
        System.out.println("The current maximum element is " + h.getMax() 
                + "\n"); 
  
        // Deleting key at index 2. 
        h.deleteNodeKey(2); 
  
        // Printing the size of the heap 
        // after deletion. 
        System.out.println("The current size of the heap is "
                + h.curSize() + "\n"); 
  
        // Inserting 2 new keys into the heap. 
        h.insertNode(15); 
        h.insertNode(5); 
        System.out.println("The current size of the heap is "
                + h.curSize() + "\n"); 
        System.out.println("The current maximum element is " + h.getMax() 
                + "\n");

	}

}
