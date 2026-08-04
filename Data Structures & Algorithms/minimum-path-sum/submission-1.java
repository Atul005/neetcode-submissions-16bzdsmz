class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tab = new int[m][n];
        

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i+1 == m && j+1 == n){
                    tab[i][j] = grid[i][j];
                }else{
                    int right = j+1 >= n ? Integer.MAX_VALUE : tab[i][j+1];
                    int left = i+1 >= m ? Integer.MAX_VALUE : tab[i+1][j];

                    tab[i][j] = grid[i][j] + Math.min(right, left); 
                }
            }
        }

        return tab[0][0];
    }
}