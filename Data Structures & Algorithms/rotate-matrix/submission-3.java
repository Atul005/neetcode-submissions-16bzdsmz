class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        int l = 0;
        int r = m-1;
        while(l < r){
            for(int i=0;i<m;i++){
                int t = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = t;
            }
            l++;
            r--;
        }

    }
}
