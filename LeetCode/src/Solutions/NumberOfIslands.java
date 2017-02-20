package Solutions;

public class NumberOfIslands {

	public static void main(String[] args) {

	}

	public int numIslands(char[][] grid) {
		int rows = grid.length;
		if (rows == 0)
			return 0;
		int cols = grid[0].length;
		if (cols == 0)
			return 0;
		int count = 0;
		// ±éÀú
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					count++;
					bfs(i, j, grid, rows, cols);
				}
			}
		}
		return count;
	}

	// DFS
	public void bfs(int x, int y, char[][] grid, int rows, int cols) {
		if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
			grid[x][y] = '0';
			bfs(x - 1, y, grid, rows, cols);
			bfs(x, y - 1, grid, rows, cols);
			bfs(x + 1, y, grid, rows, cols);
			bfs(x, y + 1, grid, rows, cols);
		}
	}

}
