package concepts.binarytrees.concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> postorder = new LinkedList<Integer>();
	    postOrderTraversalUsingOneStacks(root,postorder);
	        return postorder;
	    }
	
	public List<Integer> postorderTraversal2(TreeNode root) {
	    List<Integer> postorder = new LinkedList<Integer>();
	    postOrderTraversalUsingTwoStacks(root,postorder);
	        return postorder;
	    }
	
	private void postOrderTraversalUsingTwoStacks(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty()){
            root=stack1.pop();
            stack2.push(root);
            if(root.left!=null){
                stack1.push(root.left);
            }
            if(root.right!=null){
                stack1.push(root.right);
            }
        }

        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
    }
	

	private void postOrderTraversalUsingOneStacks(TreeNode root, List<Integer> list){
		if(root==null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;
		while(currentNode!=null || !stack.isEmpty()) {
			if(currentNode!=null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}else {
				TreeNode temp = stack.peek().right;
				
				if(temp==null) {
					temp = stack.peek();
					stack.pop();
					list.add(temp.val);
					
					//checking whether the temp which is leaf node is right to the next peek node if yes we will be adding peek node to list
					//Loop for checking does leaf node exists on right of the peek node
					while(!stack.isEmpty() && temp==stack.peek().right) {
						temp=stack.peek();
						stack.pop();
						list.add(temp.val);
					}
				}else {
					//right node
					currentNode = temp;
				}
				
				
			}
		}
	}

}
