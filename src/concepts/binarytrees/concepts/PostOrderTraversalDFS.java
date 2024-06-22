package concepts.binarytrees.concepts;

import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversalDFS {
	// Left -  Right - Root 
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postorder = new LinkedList<Integer>();
		postOrder(root, postorder);
		return postorder;
	}

	private void postOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
	}

}
