class Solution {
    public boolean canJump(int[] nums) {
        int mxIdx = 0;
        int n = nums.length;

        for(int i=0;i<nums.length;i++){
            mxIdx = Math.max(mxIdx, nums[i] + i);
            if(mxIdx >= n-1){
                return true;
            }
            if(mxIdx == i){
                break;
            }
        }
        return false;
    }
}
