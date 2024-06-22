package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class KthSmallestElementInBST {
	
	public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;

        TreeNode curr = root;
        int res = -1;
        int count = 0;
        while(curr!=null){

            if(curr.left==null){
                res = curr.val;
                curr = curr.right;
                count++;
                
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                        prev = prev.right;
                    }

                    if(prev.right==null){
                        prev.right = curr;
                        curr = curr.left;
                        
                    }else{
                        prev.right = null;
                        res = curr.val;
                        curr = curr.right;
                        count++;
                        
                }
            }

            if(count==k){
                return res;
            }
        }

        return res;
    }

}
