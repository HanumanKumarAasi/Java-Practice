package concepts.binarytrees.mediumproblems;

import java.util.ArrayList;
import java.util.List;

import concepts.binarytrees.concepts.TreeNode;

public class RightView {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int level = 0;
        rightview(root,level,list);
        return list;
    }

    void rightview(TreeNode root, int level, List<Integer> list){
        if(root==null){
            return;
        }

        if(level==list.size()){
            list.add(root.val);
        }

        rightview(root.right,level+1,list);
        rightview(root.left,level+1,list);
    }

}
