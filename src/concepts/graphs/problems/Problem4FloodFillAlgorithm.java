package concepts.graphs.problems;

public class Problem4FloodFillAlgorithm {
	// Q https://leetcode.com/problems/flood-fill/
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		// the initial color will be the start roe(sr) and start column(sc) index node
		int initialColor = image[sr][sc];

		// here we need to check 4 neighbors

		int delRow[] = { -1, 0, 1, 0 };
		int delCol[] = { 0, 1, 0, -1 };

		// we are not modifying the original image array so creating ans array for
		// midification
		int[][] ans = image;
		dfs(sr, sc, initialColor, delRow, delCol, image, ans, color);

		return ans;
	}

	public void dfs(int sr, int sc, int initialColor, int[] delRow, int[] delCol, int[][] image, int[][] ans,
			int color) {

		ans[sr][sc] = color;

		// limit for row index validation
		int n = image.length;

		// limit for col index validation
		int m = image[0].length;
		// 4 boundaries
		for (int i = 0; i < 4; i++) {
			int nrow = sr + delRow[i];// boundary row index
			int ncol = sc + delCol[i];// boundary col index

			// checking index boundarylimits and image[nrow][ncol] should be of initial
			// color and ans[nrow][ncol] should e //new color, if it new color we already
			// visited so no need to visit again
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor
					&& ans[nrow][ncol] != color) {
				dfs(nrow, ncol, initialColor, delRow, delCol, image, ans, color);
			}

		}

	}

}
