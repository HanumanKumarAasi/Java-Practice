package concepts.binarytrees.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import concepts.binarytrees.hardproblems.MorrisInorderTraversal;
import concepts.binarytrees.mediumproblems.BottomView;
import concepts.binarytrees.mediumproblems.BoundaryTraversal;
import concepts.binarytrees.mediumproblems.CheckIfTreeIsBalancedTreeOrNot;
import concepts.binarytrees.mediumproblems.DiameterOfABinaryTree;
import concepts.binarytrees.mediumproblems.LeafNodePath;
import concepts.binarytrees.mediumproblems.LeftView;
import concepts.binarytrees.mediumproblems.MaximumWidthOfABinaryTree;
import concepts.binarytrees.mediumproblems.RightView;
import concepts.binarytrees.mediumproblems.TopView;
import concepts.binarytrees.mediumproblems.VerticalTraversal;

public class Main {
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(8);
		
		root.right = new TreeNode(3);
		root.right.left= new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
		
		LevelOrderTraversalBFS level = new LevelOrderTraversalBFS();
		//System.out.println(level.levelOrder(root));
		
		PostOrderTraversal inTraversal = new PostOrderTraversal();
		System.out.println("One stack post"+inTraversal.postorderTraversal(root));
		System.out.println("Two stack post"+inTraversal.postorderTraversal2(root));
		
		
		CheckIfTreeIsBalancedTreeOrNot check = new CheckIfTreeIsBalancedTreeOrNot();
		System.out.println(check.isBalanced(root));
		
		
		DiameterOfABinaryTree diameter = new DiameterOfABinaryTree();
		System.out.println("diameter : "+diameter.diameterOfBinaryTree(root));
		
		MaximumWidthOfABinaryTree maximumWidthOfABinaryTree = new MaximumWidthOfABinaryTree();
		int width = maximumWidthOfABinaryTree.widthOfBinaryTree(root);
		System.out.println("width : "+ width);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		
		root1.left.left = new TreeNode(3);
		
		root1.left.left.left = new TreeNode(4);
		
		root1.left.right = new TreeNode(6);
		
		root1.left.right.right = new TreeNode(7);
		
		root1.left.right.right.left = new TreeNode(8);
		root1.left.right.right.left.left = new TreeNode(10);
		
		root1.left.right.right.right = new TreeNode(9);
		root1.left.right.right.right.right = new TreeNode(11);
		
		
		root1.right = new TreeNode(5);
		
		root1.right.right = new TreeNode(12);
		
		root1.right.right.left = new TreeNode(13);
		
		root1.right.right.right = new TreeNode(14);
		
		root1.right.right.right.left = new TreeNode(15);
		
		root1.right.right.right.left.left = new TreeNode(16);
		root1.right.right.right.left.left.right = new TreeNode(17);
		
		System.out.println("diameter of root1 : "+diameter.diameterOfBinaryTree(root1));
		
		int[] arr = {1,2,3,4};
		String arr1[] = { "Python", "HTM", "Java", "C", "C++", "JavaScript", "Ruby", "Swift", "PHP" }; 
		System.out.println(Arrays.stream(arr1).collect(Collectors.toList()));
		
		BoundaryTraversal boundary = new BoundaryTraversal();
		System.out.println(boundary.printBoundary(root));
		
		VerticalTraversal vertical = new VerticalTraversal();
		System.out.println(vertical.verticalTraversal(root));
		
		
		TopView topView = new TopView();
		System.out.println(topView.topView(root));
		
		BottomView bottomView =new BottomView();
		System.out.println(bottomView.bottomView(root));
		
		RightView rightView = new RightView();
		System.out.println(rightView.rightSideView(root));
		
		LeftView leftView = new LeftView();
		System.out.println(leftView.leftSideView(root));
		
		System.out.println(LeafNodePath.Paths(root));
		
		System.out.println(new MorrisInorderTraversal().MorrisInorder(root, new ArrayList<Integer>()));
	}
	
	

}
