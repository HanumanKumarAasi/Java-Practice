package concepts.binarytrees.concepts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBFS {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			list.add(subList);
		}
		return list;
	}
	
	

}
