class Solution {
    public int rob(int[] nums) {
        int memo[] = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return solve(nums, nums.length-1, memo);
    }

    public int solve(int[] nums, int n, int[] memo){
        
        if(n < 0){
            return 0;
        } 

        if(memo[n] != -1){
            return memo[n];
        }
        
        if(n == 0){
            return nums[n];
        }

        int pick = nums[n] + solve(nums, n-2, memo);
        int notPick = solve(nums, n-1, memo);

        memo[n] =  Math.max(pick, notPick);

        return memo[n];
    }
}
