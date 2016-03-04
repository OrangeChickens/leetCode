/*
Given a 2d grid map of '1's (land) and '0's (water), 
count the number of islands. An island is surrounded 
by water and is formed by connecting adjacent 
lands horizontally or vertically. You may assume all 
four edges of the grid are all surrounded by water.
*/
public class Solution {
  public int numIslands(char[][] grid) {
  	if (grid == null || grid.length == 0 || grid[0].length == 0) {
  		return 0;
  	}
  	int numOfIslands = 0;
  	int rows = grid.length;
  	int columns = grid[0].length;

  	for (int i  = 0; i < rows; i++) {
  		for (int j = 0; j < columns; j++) {
  			if (grid[i][j] == "1") {
  				numOfIslands += 1;
  				dfs(i, j, grid);
  			}
  		}
  	}

  	return numOfIslands;
  }

  private static dfs(int m , int n, char[][] grid) {
  	if (m < 0 || m > grid.length || n < 0 || n > grid[0].length || grid[i][j] == '2') {
  		return;
  	}

  	if (grid[i][j] == '0') {
  		return;
  	}

  	dfs(m - 1, n, grid);
  	dfs(m + 1, n, grid);
  	dfs(m, n - 1, grid);
  	dfs(m, n + 1, grid);
  }
}