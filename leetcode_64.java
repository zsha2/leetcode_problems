class Solution {
  public int minPathSum(int[][] grid) {
    if(grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int[][] min = new int[grid.length][grid[0].length];
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(i == 0 && j == 0) {
          min[i][j] = grid[i][j];
        }
        else if(i == 0 && j != 0) {
          min[i][j] = min[i][j - 1] + grid[i][j];
        }
        else if(i != 0 && j == 0) {
          min[i][j] = min[i - 1][j] + grid[i][j];
        }
        else{
          min[i][j] = Math.min(min[i][j - 1], min[i - 1][j]) + grid[i][j];
        }
      }
    }
    return min[grid.length - 1][grid[0].length - 1];
  }
}
