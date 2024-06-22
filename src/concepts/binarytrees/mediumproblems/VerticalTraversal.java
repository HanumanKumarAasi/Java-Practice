package concepts.binarytrees.mediumproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import concepts.binarytrees.concepts.TreeNode;

public class VerticalTraversal {

	public List<List<Integer>> verticalTraversal(TreeNode root) {
	    Map<Integer,Map<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
	    Queue<Tuple> queue = new LinkedList<>();
	    queue.offer(new Tuple(root,0,0));
	    while(!queue.isEmpty()){
	        Tuple tuple = queue.poll();
	        TreeNode node = tuple.node;
	        int y = tuple.vertical;
	        int x = tuple.level;

	        if(!map.containsKey(x)){
	            map.put(x, new TreeMap<>());
	        }

	        if(!map.get(x).containsKey(y)){
	            map.get(x).put(y, new PriorityQueue<>());
	        }
	        map.get(x).get(y).offer(node.val);
	        if(node.left!=null){
	            queue.offer(new Tuple(node.left,x-1,y+1));
	        }

	        if(node.right!=null){
	            queue.offer(new Tuple(node.right,x+1,y+1));
	        }
	    }

	    List<List<Integer>> list = new ArrayList<>();
	    for(Map<Integer,PriorityQueue<Integer>> inner: map.values()){
	        list.add(new ArrayList<>());
	        for(PriorityQueue<Integer> nodes: inner.values()){
	            while(!nodes.isEmpty()){
	                list.get(list.size()-1).add(nodes.poll());
	            }
	        }
	    }
	    return list;
	    }
	        
	}

	class Tuple{
	    TreeNode node;
	    int vertical;
	    int level;

	    Tuple(TreeNode node, int level, int vertical){
	        this.node = node;
	        this.vertical = vertical;
	        this.level = level;
	    }
	}
