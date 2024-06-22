package concepts.binarytrees.mediumproblems;

import concepts.binarytrees.concepts.TreeNode;

public class CheckIfTreeIsBalancedTreeOrNot {
	
	public boolean isBalanced(TreeNode root) {
        if(maxDepth(root)==-1){
            return false;
        }
        return true;
    }

    private int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int leftTreeDepth = maxDepth(root.left);
        int rightTreeDepth = maxDepth(root.right);

        if(leftTreeDepth==-1 || rightTreeDepth==-1){
            return -1;
        }

        if(Math.abs(leftTreeDepth-rightTreeDepth)>1){
            return -1;
        }

        return 1+Math.max(leftTreeDepth,rightTreeDepth);
    }

}
