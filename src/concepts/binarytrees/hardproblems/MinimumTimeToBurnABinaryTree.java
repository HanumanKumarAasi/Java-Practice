package concepts.binarytrees.hardproblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import concepts.binarytrees.concepts.TreeNode;

public class MinimumTimeToBurnABinaryTree {
	
	public static int minTime(TreeNode root, int target) 
    {
     
        Map<TreeNode,TreeNode> nodeparent = new HashMap<>();

        TreeNode tar = markParentsAndReturnTargetNode(root,nodeparent,target);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,Boolean> visitor = new HashMap<>();
        int time = 0;
        q.offer(tar);
        visitor.put(tar,true);
        while(!q.isEmpty()){


            int flag = 0;
            
            int size = q.size();

            

            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(nodeparent.get(temp)!=null && visitor.get(nodeparent.get(temp))==null ){
                    q.offer(nodeparent.get(temp));
                    visitor.put(nodeparent.get(temp),true);
                    flag=1; // states we have burnt the node which is not in visitors
                }

                if(temp.left!=null && visitor.get(temp.left)==null){
                    q.offer(temp.left);
                    visitor.put(temp.left,true);
                    flag=1; // states we have burnt the node which is not in visitors
                }

                if(temp.right!=null && visitor.get(temp.right)==null){
                    q.offer(temp.right);
                    visitor.put(temp.right,true);
                    flag=1; // states we have burnt the node which is not in visitors
                }
            }
            
            if(flag==1){
                time++;
            }
        }

        return time;
    }
    
    static TreeNode markParentsAndReturnTargetNode(TreeNode root, Map<TreeNode,TreeNode> nodeparent, int target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = null;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val==target){
                res = curr;
            }
            
            if(curr.left!=null){
                nodeparent.put(curr.left, curr);
                q.offer(curr.left);
            }

            if(curr.right!=null){
                nodeparent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        return res;
    }

}
