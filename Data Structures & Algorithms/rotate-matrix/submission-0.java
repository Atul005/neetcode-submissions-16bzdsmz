class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int[][] temp = new int[m][m];

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                temp[j][i] = matrix[i][j];
            }
        }

        int l = 0;
        int r = m-1;
        while(l < r){
            for(int i=0;i<m;i++){
                int t = temp[i][l];
                temp[i][l] = temp[i][r];
                temp[i][r] = t;
            }
            l++;
            r--;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
