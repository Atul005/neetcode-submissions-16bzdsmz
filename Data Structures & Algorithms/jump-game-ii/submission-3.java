class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int r = 0;
        int l = 0;
        while(r < nums.length-1){
            int farthest = 0;
            int i = l;
            while(i <= r){
                farthest = Math.max(farthest, i + nums[i]);
                i++;
            }

            if(farthest == r){
                return -1;
            }

            l = r + 1;
            r = farthest;
            count++;
        }
        return count;
    }
}
