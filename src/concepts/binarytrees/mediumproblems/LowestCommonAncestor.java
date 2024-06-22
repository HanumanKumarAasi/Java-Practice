package concepts.binarytrees.mediumproblems;

import concepts.binarytrees.concepts.TreeNode;

public class LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        //Checking left half
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        //Checking right half
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }

}
