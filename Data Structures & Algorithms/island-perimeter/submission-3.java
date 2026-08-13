class Solution {

    int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    res += 4 - countAdjacents(grid, i, j, m, n);
                }
            }
        }

        return res;
    }

    public int countAdjacents(int[][] grid, int i, int j, int m, int n){
        int adjacents = 0;
        for(int[] side : dirs){
            int x = i + side[0];
            int y = j + side[1];
            if(x < m && y < n && x >= 0 && y >= 0 && grid[x][y] == 1){
                adjacents++;
            }
        }
        return adjacents;
    }
}