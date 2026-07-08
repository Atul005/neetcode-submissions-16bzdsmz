class Solution {
    public int findDuplicate(int[] nums) {
        int res = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i]) -1] < 0){
                res = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
        }

        System.out.println(Arrays.toString(nums));

        return res;
    }
}
