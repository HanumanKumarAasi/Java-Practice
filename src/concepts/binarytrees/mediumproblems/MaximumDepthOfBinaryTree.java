package concepts.binarytrees.mediumproblems;

import concepts.binarytrees.concepts.TreeNode;

public class MaximumDepthOfBinaryTree {
	
	public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int leftTreeDepth = maxDepth(root.left);
        int rightTreeDepth = maxDepth(root.right);

        return 1+Math.max(leftTreeDepth,rightTreeDepth);
    }

}
