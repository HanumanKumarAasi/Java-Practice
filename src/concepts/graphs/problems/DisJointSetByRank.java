package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.List;

public class DisJointSetByRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

	}

}

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
        	//Assigning rank of each node to 0
            rank.add(0);
            
            //parent of each node initially be its own
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
    	
    	//finding the ultimate parent of u
        int ulp_u = findUPar(u);
        
        //finding the ultimate parent of v
        int ulp_v = findUPar(v);
        
        //if ultimate parent of u and v are same then they are under same component
        if (ulp_u == ulp_v) return;
        
        //if not under same component then we need to connect them by considering their ranks, the higher ranker will be the parent for lower rank
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
        	
        	//if both ranks are same then considering u as the parent to v and incrementing the rank of u by 1
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}
