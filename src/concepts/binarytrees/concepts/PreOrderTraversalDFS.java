package concepts.binarytrees.concepts;

import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversalDFS {
	// Root - Left - Right
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preorder = new LinkedList<Integer>();
		preOrder(root, preorder);
		return preorder;
	}

	private void preOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preOrder(root.left, list);
		preOrder(root.right, list);
	}

}
