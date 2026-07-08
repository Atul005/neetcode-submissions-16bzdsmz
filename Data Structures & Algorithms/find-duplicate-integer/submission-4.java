class Solution {
    public int findDuplicate(int[] nums) {
        int res = -1;
        for(int i=0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num -1] < 0){
                res = num;
                break;
            }
            nums[num - 1] = -1 * nums[num - 1];
        }

        return res;
    }
}
