class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int h = n - 1;
        int res = 0;
        
        while(l <= h){
            int min = Math.min(heights[l], heights[h]);
            res = Math.max(res, min*(h-l));

            if(heights[l] < heights[h]){
                l++;
            }else{
                h--;
            }
        } 

        return res;
    }
}
