class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<Triplet> queue = new ArrayDeque<>();
        int[][] visited = new int[m][n];
        int ones = 0;
        int maxTime = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    Triplet t = new Triplet(i, j, 0);
                    queue.offer(t);
                    visited[i][j] = 1;
                }else if(grid[i][j] == 1){
                    ones++;
                }
            }
        }   

        if(ones == 0){
            return 0;
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};     

        while(!queue.isEmpty()){
            Triplet polled = queue.poll();
            maxTime = Math.max(maxTime, polled.m);

            for(int[] dir : dirs){
                int r = polled.r + dir[0];
                int c = polled.c + dir[1];
                int t = polled.m;
                maxTime = Math.max(maxTime, t);
                
                if(r >= 0 && r < m && c >= 0 &&  c < n && visited[r][c] != 1 && grid[r][c] == 1){
                    queue.add(new Triplet(r, c, t+1));
                    visited[r][c] = 1;
                    grid[r][c] = 2;    
                    ones--;                                    
                }
            }

        }

        if(ones > 0){
            return -1;
        }

        return maxTime;
    }

    public class Triplet{
        int r;
        int c;
        int m;

        public Triplet(int r, int c, int m){
            this.r = r;
            this.c = c;
            this.m = m;
        }
    }
}
