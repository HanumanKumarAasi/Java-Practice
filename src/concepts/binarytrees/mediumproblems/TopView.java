package concepts.binarytrees.mediumproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import concepts.binarytrees.concepts.TreeNode;

public class TopView {
	
	public ArrayList<Integer> topView(TreeNode root) {
        // add your code
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        
        Map<Integer,Integer> map = new TreeMap<>();
        
        while(!q.isEmpty()){
            
            Pair pair = q.poll();
            TreeNode temp = pair.TreeNode;
            if(!map.containsKey(pair.line)){
                map.put(pair.line,pair.TreeNode.val);
            }
            
            if(temp.left!=null){
                q.offer(new Pair(temp.left,pair.line-1));
            }
            
            if(temp.right!=null){
                q.offer(new Pair(temp.right,pair.line+1));
            }
        }
        
        ArrayList<Integer> templist = new ArrayList<Integer>(map.keySet());
        Collections.sort(templist);
        
        for(int key:templist){
            list.add(map.get(key));
        }
        
        return list;
    }
	
	static class Pair{
	    TreeNode TreeNode;
	    int line;
	    Pair(TreeNode TreeNode, int line){
	        this.TreeNode = TreeNode;
	        this.line = line;
	    }
	}
}



