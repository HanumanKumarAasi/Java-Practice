package concepts.binarytrees.mediumproblems;

import java.util.ArrayList;
import java.util.List;

import concepts.binarytrees.concepts.TreeNode;

public class LeftView {
	
	public List<Integer> leftSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int level = 0;
        leftview(root,level,list);
        return list;
    }

    void leftview(TreeNode root, int level, List<Integer> list){
        if(root==null){
            return;
        }

        if(level==list.size()){
            list.add(root.val);
        }

        leftview(root.left,level+1,list);
        leftview(root.right,level+1,list);
        
    }

}
