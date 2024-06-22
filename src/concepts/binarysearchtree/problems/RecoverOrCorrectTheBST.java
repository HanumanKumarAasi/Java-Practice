package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class RecoverOrCorrectTheBST {
	
	private TreeNode firstVoilation;

    private TreeNode secondVoilation;

    private TreeNode thirdVoilation;

    //the prev Node for validating the curr Node for recording voilation
    private TreeNode prev;


    //traversing through all node which got swapped
    private void inorder(TreeNode node){
        if(node==null) return;
        //left
        inorder(node.left);

        //root(checking for curr node is less than prev node)
        if(prev!=null && node.val<prev.val){
            if(firstVoilation==null){
                firstVoilation=prev;
                secondVoilation=node;
            }else{
                thirdVoilation=node;
            }
        }
        //recording curr node as prev
        prev = node;
        //right
        inorder(node.right);

    }

    public void recoverTree(TreeNode root) {
        firstVoilation = secondVoilation = thirdVoilation = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        //non adjacent voilated nodes
        if(firstVoilation!=null && thirdVoilation!=null){
            int temp = firstVoilation.val;
            firstVoilation.val = thirdVoilation.val;
            thirdVoilation.val = temp;
        }//adjacent voilated nodes
        else if(firstVoilation!=null && secondVoilation!=null){
            int temp = firstVoilation.val;
            firstVoilation.val = secondVoilation.val;
            secondVoilation.val = temp;
        }
    }

}
