package concepts.binarytrees.concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
        
	    List<Integer> inorder = new LinkedList<Integer>();
	       inOrderTraversal(root,inorder);
	        return inorder;
	    }

	private void inOrderTraversal(TreeNode root, List<Integer> list){
	    
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
	}

}
