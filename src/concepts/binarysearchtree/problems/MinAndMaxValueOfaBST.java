package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class MinAndMaxValueOfaBST {
	
	int minValue(TreeNode root) {
        // code here
        if(root==null)return -1;
        
        while(root.left!=null){
            root=root.left;
        }
        return root.val;
    }
	
	int maxValue(TreeNode root) {
        // code here
        if(root==null)return -1;
        
        while(root.right!=null){
            root=root.right;
        }
        return root.val;
    }

}
