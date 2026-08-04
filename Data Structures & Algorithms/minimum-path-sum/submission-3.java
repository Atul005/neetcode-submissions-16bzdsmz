class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(memo[i], -1);
        }
        return solve(0, 0, grid, m, n, memo);
    }

    public int solve(int i, int j, int[][] grid, int m, int n, int[][] memo){
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(i == m-1 && j == n-1){
            return grid[i][j];
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        memo[i][j] = grid[i][j] + 
                    Math.min(
                        solve(i+1, j, grid, m, n, memo), 
                        solve(i, j+1,grid, m, n, memo));

        return memo[i][j]; 
    }

}



