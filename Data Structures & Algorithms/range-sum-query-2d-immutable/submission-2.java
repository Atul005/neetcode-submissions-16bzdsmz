class NumMatrix {

    int[][] matrix;
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.prefix = new int[matrix.length][matrix[0].length];
        preparePrefix(matrix, prefix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = prefix[row2][col2];

        if(row1 > 0){
            a = a - prefix[row1 -1][col2];
        }

        if(col1 > 0){
            a = a - prefix[row2][col1-1];
        }

        if(row1 > 0 && col1 > 0){
            a = a + prefix[row1-1][col1-1];
        }

        return a;
    
    }

    public void preparePrefix(int[][] matrix, int[][] prefix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(i == 0){
                prefix[i][0] = matrix[i][0];
                continue;
            }
            prefix[i][0] = prefix[i-1][0] + matrix[i][0];
        }

        for(int i=0;i<n;i++){
            if(i == 0){
                prefix[0][i] = matrix[0][i];
                continue;
            }
            prefix[0][i] = prefix[0][i-1] + matrix[0][i];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                prefix[i][j] = matrix[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }


    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */