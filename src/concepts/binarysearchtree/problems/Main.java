package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class Main {
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(2);
		
		root.left.right = new TreeNode(4);
		
		//root.left.left.right = new TreeNode(2);
		
		//root.right.left = new TreeNode(6);
		
		root.right.right = new TreeNode(7);
		
		KthLargestElementInBST kthLargest = new KthLargestElementInBST();
		
		System.out.println(kthLargest.kthLargest(root, 3));
		
		System.out.println(new TwoSumIVforBST().findTarget(root, 10));
	}

}
