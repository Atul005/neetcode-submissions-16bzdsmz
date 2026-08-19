class Solution {

    int[][] dirs = {{-1, 0},{1, 0},{0, 1},{0, -1}};

    public int orangesRotting(int[][] grid) {
        int count = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshFruits = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshFruits++;
                }
            }
        }

        boolean found = false;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int[] rotten = queue.poll();

                for(int[] dir : dirs){
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];

                        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                            grid[x][y] = 2;
                            queue.offer(new int[]{x, y});
                            freshFruits--;
                            found = true;
                        } 
                }
                size--;
            }
            if(found){
                count++;
            }
            found = false;
        }
        return freshFruits == 0 ? count : -1;
    }
}
