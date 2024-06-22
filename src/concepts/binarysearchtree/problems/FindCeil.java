package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class FindCeil {
	int findCeil(TreeNode root, int key) {
        if (root == null) return -1;
        // Code here
        TreeNode curr = root;
        int ceil = -1;
        while(curr!=null){
            if(curr.val==key){
                return curr.val;
            }else if(curr.val>key){
                ceil = curr.val;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return ceil;
    }

}
