package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class InorderSuccessor {
	//Inorder successor is ntg but finding the ceil in the given tree node which is > x
	public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
		// add code here.
		return findCeil(root, x);
	}

	TreeNode findCeil(TreeNode root, TreeNode key) {
		if (root == null)
			return null;
		// Code here
		TreeNode curr = root;
		TreeNode ceil = null;
		while (curr != null) {
			if (curr.val > key.val) {
				ceil = curr;
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		return ceil;
	}

}
