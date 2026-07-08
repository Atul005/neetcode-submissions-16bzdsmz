class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right){
            
            for(int col = left; col <= right; col++){
                res.add(matrix[top][col]);
            }
            top++;

            for(int row = top; row <= bottom;row++){
                res.add(matrix[row][right]);
            }
            right--;

            if(top <= bottom){
                for(int c = right;c >= left;c--){
                    res.add(matrix[bottom][c]);
                }
            }
            bottom--;

            if(left <= right){
                for(int r = bottom;r >= top;r--){
                    res.add(matrix[r][left]);
                }
            }
            left++;

        }
        return res;
    }
}
