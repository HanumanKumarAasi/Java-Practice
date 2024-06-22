package concepts.binarytrees.hardproblems;

import java.util.Stack;

import concepts.binarytrees.concepts.TreeNode;

public class FlattenBinaryTreeToLikeLinkedList {
	
	TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root==null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            stack.pop();

            if(curr.right!=null){
                stack.push(curr.right);
            }

            if(curr.left!=null){
                stack.push(curr.left);
            }

            if(!stack.isEmpty()){
                curr.right = stack.peek();
            }
            curr.left=null;
        }

        //flat(root);
    }


    //recursive approach
    void flat(TreeNode root){
            if(root==null){
                return;
            }

            flat(root.right);
            flat(root.left);

            root.right = prev;
            root.left = null;
            prev = root;
    }
    
    //morris approach
    void morrisFlat(TreeNode root){

        TreeNode curr = root;

        while(curr!=null){
            if(curr.left!=null){
                TreeNode prev = curr.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

}
