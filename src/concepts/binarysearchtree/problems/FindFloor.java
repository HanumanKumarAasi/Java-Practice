package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class FindFloor {
	
	public static int floor(TreeNode root, int x) {
        // Code here
        if(root==null) return -1;
        int floor = -1;
        
        while(root!=null){
            if(root.val==x){
                return root.val;
            }else if(root.val<x){
                floor = Math.max(floor,root.val);
                root = root.right;
            }else{
                root = root.left;
            }
        }
        
        return floor;
        
    }

}
