package concepts.binarytrees.mediumproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import concepts.binarytrees.concepts.TreeNode;

public class ZigZagLevelOrder {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		queue.offer(root);
        boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			Integer[] subList = new Integer[size];
			for (int i = 0; i < size; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				
                int index = leftToRight?i:(size-i-1);
                subList[index]=queue.poll().val;
			}
            leftToRight = !leftToRight;
			list.add(Arrays.stream(subList).collect(Collectors.toList()));
		}
		return list;
        
    }

}
