package concepts.binarytrees.mediumproblems;

import java.util.ArrayList;

import concepts.binarytrees.concepts.TreeNode;

public class LeafNodePath {
	
	public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        
        if(root == null){
            return list;
        }
        helper(list,path,root);
        return list;
    }
    
	//leaf node path
    static void helper(ArrayList<ArrayList<Integer>> list,ArrayList<Integer> path,TreeNode root){
        if(root.left == null && root.right == null){
            path.add(root.val);
            list.add(new ArrayList(path));
            return;
        }
        path.add(root.val);
        if(root.left != null){
             helper(list,path,root.left);
            path.remove(path.size()-1);
        }
       
        if(root.right != null){
            helper(list,path,root.right);
            path.remove(path.size()-1);
        }
        
    }
    
    //node path
    boolean nodePathHelper(TreeNode node, ArrayList<Integer> list, int nodeVal){
    	if(node==null) {
    		return false;
    	}
    	list.add(node.val);
    	if(node.val==nodeVal) {
    		return true;
    	}
    	if(nodePathHelper(node.left,list,nodeVal)||nodePathHelper(node.right,list,nodeVal)) {
    		return false;
    	}
    	
    	list.remove(list.size()-1);
    	return true;
    }

}
