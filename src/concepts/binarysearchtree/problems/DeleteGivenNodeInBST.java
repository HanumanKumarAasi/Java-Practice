package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class DeleteGivenNodeInBST {
	
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;

        // if key == root.val
        if(root.val==key){
            return helper(root);
        } 

        TreeNode curr = root;

        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left = helper(root.left);
                }else{
                    root = root.left;
                }
            }else{
                if(root.right!=null && root.right.val==key){
                    root.right = helper(root.right);
                }else{
                    root = root.right;
                }
            }
        }
        return curr;
    }

    TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }
        TreeNode rightChild = root.right;
        TreeNode lastRightInLeftSubTree = findLastRight(root.left);
        lastRightInLeftSubTree.right = rightChild;
        return root.left;
    }

    TreeNode findLastRight(TreeNode root){
        if(root.right==null){
            return root;
        }
        return findLastRight(root.right);
    }

}
