package concepts.binarytrees.mediumproblems;

import java.util.LinkedList;
import java.util.Queue;

import concepts.binarytrees.concepts.TreeNode;

public class MaximumWidthOfABinaryTree {

	public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        int ans=0;
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().count;// the index of the 
            int first = 0,last=0;//for storing the first and last index
            for(int i=0;i<size;i++){
                int curindex = queue.peek().count-min;
                TreeNode node = queue.peek().root;
                queue.poll();
                if(i==0) first = curindex;
                if(i==size-1) last = curindex;
                if(node.left != null){
                    queue.offer(new Pair(node.left,curindex*2+1));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right,curindex*2+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
}

class Pair{
	
	TreeNode root;
	int count;
	
	public Pair(TreeNode root, int count) {
		super();
		this.root = root;
		this.count = count;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}