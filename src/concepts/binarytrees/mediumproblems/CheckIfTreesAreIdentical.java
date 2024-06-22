package concepts.binarytrees.mediumproblems;

import concepts.binarytrees.concepts.TreeNode;

public class CheckIfTreesAreIdentical {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p==q;
        }

        return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
