package concepts.binarytrees.concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreInPostOrderTraversals {
	
	public List<Integer> preInPostTraversal(TreeNode root) {
		    List<Integer> order = preInPostTraversal(root,"postorder");
	        return order;
	    }
	
	private List<Integer> preInPostTraversal(TreeNode root, String type) {
		List<Integer> prelist = new LinkedList<>();
		List<Integer> inlist = new LinkedList<>();
		List<Integer> postlist = new LinkedList<>();
		
		Stack<Pair> stack = new Stack<>();
		
		stack.push(new Pair(root, 1));
		
		while(!stack.isEmpty()) {
			if(stack.peek().count==1) {
				prelist.add(stack.peek().root.val);
				stack.peek().setCount(2);
				if(stack.peek().root.left!=null) {
					stack.push(new Pair(stack.peek().root.left, 1));
				}
			}else if(stack.peek().count==2) {
				inlist.add(stack.peek().root.val);
				stack.peek().setCount(3);
				if(stack.peek().root.right!=null) {
					stack.push(new Pair(stack.peek().root.right, 1));
				}
			}else if(stack.peek().count==3) {
				postlist.add(stack.peek().root.val);
				stack.pop();
			}
		}
		
		if(type.equalsIgnoreCase("preorder")) {
			return prelist;
		}else if(type.equalsIgnoreCase("inorder")) {
			return inlist;
		}else {
			return postlist;
		}
	}
	
	
	

}

class Pair{
	
	TreeNode root;
	int count;
	
	public Pair(TreeNode root, int count) {
		super();
		this.root = root;
		this.count = count;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
