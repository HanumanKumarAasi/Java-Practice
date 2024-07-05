package concepts.graphs.problems;

import java.util.ArrayList;
import java.util.List;

public class Graph2DArrayToAdjList {

	public List<List<Integer>> printGraph(int V, int edges[][]) {

		List<List<Integer>> adj = new ArrayList<>();

		// no of vertices
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// no of edges they have given edge contains only 2 vertices a-->b

		for (int i = 0; i < edges.length; i++) {
			// as this is undirected we need to conside both ways a<--->b
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		return adj;
	}

}
