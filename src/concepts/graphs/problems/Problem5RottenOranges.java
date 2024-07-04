package concepts.graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem5RottenOranges {
	public int orangesRotting(int[][] grid) {

		Queue<Pair> q = new LinkedList<>();

		int row = grid.length;
		int col = grid[0].length;
		int countFresh = 0;

		int[][] vis = new int[row][col];

		//four neighbors indexes rows and cols
		int delRow[] = { -1, 0, 1, 0 };
		int delCol[] = { 0, 1, 0, -1 };

		int time = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 2) {
					// putting all of the rotten oranges into the queue
					q.offer(new Pair(i, j, 0));
					// and marking that cell as visited
					vis[i][j] = 2;
				} else {
					// not visited.
					vis[i][j] = 0;
				}

				if (grid[i][j] == 1) {
					// checking total fresh oranges in i/p for edge case
					countFresh++;
				}
			}
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int r = q.peek().row;
			int c = q.peek().col;
			int t = q.peek().time;
			time = Math.max(time, t);

			q.remove();

			for (int i = 0; i < 4; i++) {
				int nrow = r + delRow[i];// boundary row index
				int ncol = c + delCol[i];// boundary col index

				// checking index boundarylimits and grid[nrow][ncol] should be of fresh(1)
				// and vis[nrow][ncol] should not be rotten if it rotten we already
				// rotten so no need to visit again
				if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col && grid[nrow][ncol] == 1
						&& vis[nrow][ncol] != 2) {

					q.offer(new Pair(nrow, ncol, t + 1));
					vis[nrow][ncol] = 2;
					cnt++;
				}

			}
		}
		// edge case when we still have fresh oragne still in any one of the cell
		if (countFresh != cnt) {
			return -1;
		}
		return time;

	}
}

class Pair {
	int row;
	int col;
	int time;

	Pair(int r, int c, int t) {
		row = r;
		col = c;
		time = t;
	}
}