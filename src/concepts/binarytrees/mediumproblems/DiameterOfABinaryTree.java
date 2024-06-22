package concepts.binarytrees.mediumproblems;

import concepts.binarytrees.concepts.TreeNode;

public class DiameterOfABinaryTree {
	
	
	public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        diameter[0]=0;
        findMax(root,diameter);
        return diameter[0];
    }

    public int findMax(TreeNode root, int diameter[]) {
        if(root==null) return 0;

        int leftTreeDepth = findMax(root.left,diameter);
        int rightTreeDepth = findMax(root.right,diameter);

        diameter[0] = Math.max(diameter[0],leftTreeDepth+rightTreeDepth);

        return 1+Math.max(leftTreeDepth,rightTreeDepth);
    }

}


