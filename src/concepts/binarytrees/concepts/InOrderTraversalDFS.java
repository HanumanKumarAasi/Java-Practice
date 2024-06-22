package concepts.binarytrees.concepts;

import java.util.LinkedList;
import java.util.List;

public class InOrderTraversalDFS {
	// Left - Root -  Right
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> inorder = new LinkedList<Integer>();
		inOrder(root, inorder);
		return inorder;
	}

	private void inOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}

}
