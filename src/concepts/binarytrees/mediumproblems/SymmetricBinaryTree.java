package concepts.binarytrees.mediumproblems;

import concepts.binarytrees.concepts.TreeNode;

public class SymmetricBinaryTree {
	
public boolean isSymmetric(TreeNode root) {
        
        return root==null || isSymmetricImpl(root.left,root.right);
    }

    boolean isSymmetricImpl(TreeNode left, TreeNode right){
        if(left==null || right==null){
            return left==right;
        }

        if(left.val!=right.val){
            return false;
        }

        return isSymmetricImpl(left.left,right.right) && isSymmetricImpl(left.right,right.left);
        
    }

}
