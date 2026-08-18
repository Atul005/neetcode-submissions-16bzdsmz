class Solution {

    int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    res = Math.max(res, dfs(i, j, grid, visited, m, n));
                }
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    public int dfs(int i, int j, int[][] grid, boolean[][] visited, int m, int n){
        visited[i][j] = true;
        int area = 1;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];

            if(!(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] != 1)){
                area += dfs(x, y, grid, visited, m, n);
            }
        }
        return area;
    }
}
