package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class LowestCommonAncestorInBST {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return root;

        TreeNode curr = root;

        while(curr!=null){
            if(curr.val==p.val || curr.val==q.val || (curr.val>p.val && curr.val<q.val) || (curr.val>q.val && curr.val<p.val)){
                return curr;
            }else if(curr.val>p.val && curr.val>q.val){
                curr = curr.left;
            }else if(curr.val<p.val && curr.val<q.val){
                curr = curr.right;
            }else{
                return null;
            }
        }

        return null;
    }

}
