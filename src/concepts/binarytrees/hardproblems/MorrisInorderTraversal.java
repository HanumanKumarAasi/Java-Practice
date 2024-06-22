package concepts.binarytrees.hardproblems;

import java.util.List;

import concepts.binarytrees.concepts.TreeNode;

public class MorrisInorderTraversal {
	
	
	public List<Integer> MorrisInorder(TreeNode root, List<Integer> list){
        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }

                if(prev.right==null){
                    prev.right = curr;
                    curr = curr.left;
                }

                else{
                    prev.right=null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        
        return list;
    }
}
