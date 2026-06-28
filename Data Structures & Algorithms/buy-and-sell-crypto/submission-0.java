class Solution {
    public int maxProfit(int[] nums) {
        
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        min[0] = nums[0];
        for(int i=1;i<n;i++){
            min[i] = Math.min(min[i-1], nums[i]);
        }

        max[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            max[i] = Math.max(max[i+1], nums[i]);
        }

        int profit = 0;

        for(int i=0;i<n;i++){
            profit = Math.max(profit, max[i] - min[i]);
        }

        return profit;
    }       
}
