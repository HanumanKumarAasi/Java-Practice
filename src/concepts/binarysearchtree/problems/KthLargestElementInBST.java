package concepts.binarysearchtree.problems;

import concepts.binarytrees.concepts.TreeNode;

public class KthLargestElementInBST {
	
	public int kthLargest(TreeNode root, int k) {
        if(root==null) return -1;

        int res = -1;
        
        KthSmallestElementInBST kthSmallest = new KthSmallestElementInBST();
        
        int len[] = new int[1];
        len[0] = 0;
        //finding out the length of the BST and finding out the (length-k+1 smallest element from the BST)
        lengthOfBst(root,len);
        
        res = kthSmallest.kthSmallest(root, len[0]-k+1);

        return res;
    }

	private void lengthOfBst(TreeNode root, int[] len) {
		// TODO Auto-generated method stub
		if(root==null) return;
		lengthOfBst(root.left,len);
		len[0]++;
		lengthOfBst(root.right,len);		
	}

}
