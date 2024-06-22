package concepts.binarytrees.mediumproblems;

import concepts.binarytrees.concepts.TreeNode;

public class MaximumPathSum {
	
	public int maxPathSum(TreeNode root) {
        int maxsum[] = new int[1];
        maxsum[0]=root.val;
        max(root, maxsum );
        return maxsum[0];
    }

    public int max(TreeNode root, int[] maxsum){
        if(root==null){
            return 0;
        }

        int leftsum = max(root.left,maxsum);
        int rightsum = max(root.right,maxsum);
        leftsum = leftsum>0?leftsum:0;
        rightsum = rightsum>0?rightsum:0;
        maxsum[0] = Math.max(maxsum[0], (leftsum+rightsum+root.val));

        return root.val+Math.max(leftsum,rightsum);
    }

}
