package concepts.binarytrees.hardproblems;

import java.util.LinkedList;
import java.util.Queue;

import concepts.binarytrees.concepts.TreeNode;

public class SerializedAndDeserializedOfBinaryTree {
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr==null){
                res.append("N ");
                continue;
            }
            res.append(curr.val+" ");
            q.offer(curr.left);
            q.offer(curr.right);
        }

        return res.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="" || data==null) return null;

        String[] nodevalues = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(nodevalues[0]));

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        
        for(int i=1;i<nodevalues.length;i++){
            TreeNode curr = q.poll();
            if(!nodevalues[i].equals("N")){
                curr.left = new TreeNode(Integer.parseInt(nodevalues[i]));
                q.offer(curr.left);
            }

            if(!nodevalues[++i].equals("N")){
                curr.right = new TreeNode(Integer.parseInt(nodevalues[i]));
                q.offer(curr.right);
            }
        }

        return root;

    }

}
