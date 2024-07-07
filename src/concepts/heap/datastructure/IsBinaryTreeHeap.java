package concepts.heap.datastructure;

public class IsBinaryTreeHeap {
	
	public static void main(String args[]) {
		//this example is not a complete binary tree.
		Node root = new Node(8);
		root.left = new Node(7);
		root.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		
		Solution s = new Solution();
		System.out.println(s.isHeap(root));
	}

}

class Solution {
    boolean isHeap(Node tree) {
        // code here
        
        int i = 0;
        
        //heaapSize = no of node
        int heaapSize = countNodes(tree);
     
        return  (isCBT(tree , i , heaapSize) && isMaxHeap(tree));
    }
    
    //for finding the heapsize
    int countNodes(Node root){
        if(root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    //checking if the given tree is a complete binary tree
    boolean isCBT(Node root , int index , int heaapSize){
        
        if(root == null) return true;
        
        if(index >= heaapSize) return false;
        
            
        boolean left = isCBT(root.left , 2*index+1 , heaapSize);
        boolean right = isCBT(root.right , 2*index+2 , heaapSize);
            
        return (left && right);
        
    }
    
    boolean isMaxHeap(Node root){
        
        if(root == null) return true;
        
        if(root.left != null && root.data < root.left.data) return false;
        if(root.right != null && root.data < root.right.data) return false;
       
            boolean left = isMaxHeap(root.left);
            boolean right = isMaxHeap(root.right);
            
           return left && right;
    }
    
    
}

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
