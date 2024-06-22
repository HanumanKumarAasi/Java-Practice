package concepts.binarytrees.hardproblems;

import java.util.HashMap;
import java.util.Map;

import concepts.binarytrees.concepts.TreeNode;

public class BuildBTUsingInorderAndPreorder {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

       TreeNode root = buildBinaryTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

       return root;
    }

    TreeNode buildBinaryTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, 
    Map<Integer,Integer> map){

            if(prestart>preend || instart>inend) return null;

            TreeNode root = new TreeNode(preorder[prestart]);

            int rootPos = map.get(root.val);
            int nextleft = rootPos - instart;

            root.left = buildBinaryTree(preorder, prestart+1, prestart+nextleft, inorder, instart, rootPos-1, map);
            root.right = buildBinaryTree(preorder, prestart+nextleft+1, preend, inorder, rootPos+1, inend, map);

            return root;





    }

}
