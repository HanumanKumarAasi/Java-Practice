package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class LargestBSTinBT {
static NodeValue largestsBST(TreeNode root){
        
        //base condition
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        
        //following post traversal order
        NodeValue left = largestsBST(root.left);
        NodeValue right = largestsBST(root.right);
        
        //condition for bst validation if yes we return below logic
        if(left.max<root.val && root.val<right.min){
            return new NodeValue(Math.min(left.min,root.val),Math.max(right.max,root.val),left.size+right.size+1);
        }
        
        //else we return this so that the respective either of the sub tree is not a valid BST 
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(TreeNode root)
    {
        // Write your code here
        
        NodeValue res = largestsBST(root);
        
        return res.size;
        
        
    }
}

class NodeValue{
    int min,max,size;
    
    NodeValue(int mini,int maxi, int sizee){
        min = mini;
        max = maxi;
        size = sizee;
    }
}
