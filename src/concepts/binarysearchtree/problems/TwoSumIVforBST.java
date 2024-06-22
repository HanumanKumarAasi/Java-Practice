package concepts.binarysearchtree.problems;

import java.util.Stack;

import concepts.binarytrees.concepts.TreeNode;

public class TwoSumIVforBST {
	static class BSTIterator{
	    Stack<TreeNode> prev = new Stack();
	    Stack<TreeNode> next = new Stack();
	    public BSTIterator(TreeNode root) {
	        pushLeft(root);
	        pushRight(root);
	    }
	    private void pushLeft(TreeNode root){
	        while(root!=null){
	            next.push(root);
	            root=root.left;
	        }
	    }
	    private void pushRight(TreeNode root){
	        while(root!=null){
	            prev.push(root);
	            root=root.right;
	        }
	    }
	    public int next() {
	        TreeNode nextElement = next.pop();
	        pushLeft(nextElement.right);
	        return nextElement.val;
	    }
	    public int before() {
	        TreeNode beforeElement = prev.pop();
	        pushRight(beforeElement.left);
	        return beforeElement.val;
	    }
	    
	    public boolean hasNext() {
	        return next.size()!=0;
	    }
	     public boolean hasBefore() {
	        return prev.size()!=0;
	    }

	}
	    public boolean findTarget(TreeNode root, int k) {
	        BSTIterator it = new BSTIterator(root);
	        int start = it.next();
	        int end = it.before();
	        while(start!=end){
	            int currSum = start+end;
	            if(currSum==k){
	                return true;
	            }
	            else if(currSum>k){
	                if(it.hasBefore())
	                   end = it.before();
	                else return false;
	            }
	            else {
	                if(it.hasNext())
	                   start = it.next();
	                else return false;
	            }
	        }
	        return false;
	    }
}