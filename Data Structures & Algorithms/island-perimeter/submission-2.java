class Solution {
    public int islandPerimeter(int[][] grid) {
    
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    count += (4 - countAdjacents(grid, i, j));
                }
            }
        }
        return count;
    }

    public int countAdjacents(int[][] grid, int i, int j){
        int count = 0;
        if(i+1<grid.length && grid[i+1][j] == 1){
            count++;
        }

        if(i-1>=0 && grid[i-1][j] == 1){
            count++;
        }

        if(j-1>=0 && grid[i][j-1] == 1){
            count++;
        }

        if(j+1<grid[i].length && grid[i][j+1] == 1){
            count++;
        }

        return count;
    }
}