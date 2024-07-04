package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.Stack;

public class CoursesII {
	
	//Q: https://leetcode.com/problems/course-schedule-ii/
	
	//here we need to return the linear ordering ntg but same like topological algorithm
	
	public int[] findOrder(int num, int[][] prerequisites) {
	       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        //no of courses is the no of vertices
	       for(int i=0;i<num;i++){
	         adj.add(new ArrayList<Integer>());
	       }

	       for(int i=0;i<prerequisites.length;i++){
	        //we need complete the 1st index course before completing the 0th index course, so considering 1->{0}
	         adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
	       }
	        //visitor array num of courses
	       int vis[] = new int[num];
	       // DFS so using path way
	       int path[] = new int[num];
	       //Stack to store the linear order
	        Stack<Integer> stack = new Stack<>();
	       for(int i=0;i<num;i++){
	        if(vis[i]==0){
	            dfs(i,adj,vis,path,stack);
	        }
	       }

	       int result[] = new int[num];
	       int ind=0;
	        //if stack size equals to num of courses we have asyclic path, else we have a cycle so return false in that case
	       if(stack.size()==num){
	            while(!stack.isEmpty()) result[ind++]=stack.pop();

	            return result;
	       }
	       return new int[] {};
	    }

	    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis,int path[], Stack<Integer> stack){
	        vis[node] = 1;
	        path[node] = 1;
	        for(int adjNode:adj.get(node)){
	            if(vis[adjNode]==0){
	                dfs(adjNode,adj,vis,path,stack);
	            }else if(vis[adjNode]==1 && path[adjNode]==1){ //checking that whether we are moving in the same, if it is same path then we have a cycle in the given graph
	                return;
	            }
	        }
	        path[node]=0;
	        stack.push(node);
	    }

}
