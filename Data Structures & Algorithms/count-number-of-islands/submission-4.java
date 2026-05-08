class Solution {

    public int numIslands(char[][] grid) {
        int count = 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // boolean[][] visited = new boolean[m][n];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid, dirs);
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid, int[][] dirs){
        // visited[i][j] = true;
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int k = i + dir[0];
            int l = j + dir[1];

            if(l < 0 || k < 0 || k >= grid.length || l >= grid[i].length || grid[k][l] != '1'){
                continue;
            }           
            dfs(k, l, grid, dirs);
        }
    }


}
