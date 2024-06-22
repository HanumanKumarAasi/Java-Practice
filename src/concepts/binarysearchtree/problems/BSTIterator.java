package concepts.binarysearchtree.problems;

import java.util.Stack;

import concepts.binarytrees.concepts.TreeNode;

public class BSTIterator {
    Stack<TreeNode> stack =new Stack<>();
    public BSTIterator(TreeNode root) {
        
            pushAll(root);

    }
    
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node){
        for( ;node!=null;stack.push(node),node = node.left);
    }
}