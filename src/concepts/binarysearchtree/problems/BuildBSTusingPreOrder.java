package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class BuildBSTusingPreOrder {
	
	public TreeNode bstFromPreorder(int[] preorder) {
        //Here last augment is used as index pointer
        return buildBST(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    TreeNode buildBST(int[] pre, int bound, int[] i){
        if(i[0]==pre.length || pre[i[0]]>bound) return null;

        TreeNode root = new TreeNode(pre[i[0]++]);
        //in left subtree of root the bound will always be its root.val
        root.left = buildBST(pre,root.val,i);

        //in right subtree of root the bound will be always IntMa
        root.right = buildBST(pre,bound,i);

        return root;
    }

}
