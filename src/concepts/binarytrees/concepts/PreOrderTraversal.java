package concepts.binarytrees.concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new LinkedList<Integer>();
        preOrderTraversal(root,preorder);
        return preorder;
    }
	
	private void preOrderTraversal(TreeNode root, List<Integer> list){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null){
            return;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
	            if(currentNode.right!=null) {stack.push(currentNode.right);}
	            if(currentNode.left!=null) {stack.push(currentNode.left);}
	            list.add(currentNode.val);
	         }  
        }

}
