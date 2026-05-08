class Solution {

    public int numIslands(char[][] grid) {
        int count = 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, };

        Deque<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    bfs(i, j, grid, visited, dirs);
                }
            }
        }

        return count;
    }

    public void bfs(int i, int j, char[][] grid, boolean[][] visited, int[][] dirs){
        visited[i][j] = true;
        for(int[] dir : dirs){
            int k = i + dir[0];
            int l = j + dir[1];

            if(l < 0 || k < 0 || k >= grid.length || l >= grid[i].length || grid[k][l] != '1' || visited[k][l]){
                continue;
            }           
            bfs(k, l, grid, visited, dirs);
        }
    }


}
