package concepts.binarytrees.mediumproblems;

import concepts.binarytrees.concepts.TreeNode;

public class CountCompleteTreeNodes {
	
	public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left==right){
            return ((2<<left)-1);
        }

        return countNodes(root.left)+countNodes(root.right)+1;
    }

    int getLeftHeight(TreeNode root){
        int height = 0;

        while(root.left!=null){
            height++;
            root = root.left;
        }

        return height;
    }

    int getRightHeight(TreeNode root){
        int height = 0;

        while(root.right!=null){
            height++;
            root = root.right;
        }

        return height;
    }

}
