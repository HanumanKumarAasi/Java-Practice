package concepts.binarytrees.hardproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import concepts.binarytrees.concepts.TreeNode;

public class AllNodesAtDistanceKfromTarget {
	
	void markParents(TreeNode root, Map<TreeNode,TreeNode> nodeparent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                nodeparent.put(curr.left, curr);
                q.offer(curr.left);
            }

            if(curr.right!=null){
                nodeparent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> nodeparent = new HashMap<>();

        markParents(root,nodeparent);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,Boolean> visitor = new HashMap<>();
        int distance = 0;
        q.offer(target);
        visitor.put(target,true);
        while(!q.isEmpty()){


            if(distance == k){
                break;
            }
            distance++;
            int size = q.size();

            

            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(nodeparent.get(temp)!=null && visitor.get(nodeparent.get(temp))==null ){
                    q.offer(nodeparent.get(temp));
                    visitor.put(nodeparent.get(temp),true);
                }

                if(temp.left!=null && visitor.get(temp.left)==null){
                    q.offer(temp.left);
                    visitor.put(temp.left,true);
                }

                if(temp.right!=null && visitor.get(temp.right)==null){
                    q.offer(temp.right);
                    visitor.put(temp.right,true);
                }
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for(TreeNode node:q){
            list.add(node.val);
        }

        return list;

    }

}
