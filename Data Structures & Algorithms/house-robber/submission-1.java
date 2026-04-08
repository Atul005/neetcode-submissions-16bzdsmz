class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        
        int first = 0;
        int second = nums[0];
        
        for(int i=2;i<memo.length;i++){
            int curr = Math.max(second, nums[i-1] + first);
            first = second;
            second = curr;
        }
        
        return second;
    }
}
