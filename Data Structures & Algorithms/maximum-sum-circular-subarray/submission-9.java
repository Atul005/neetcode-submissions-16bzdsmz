class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMin = nums[0];
        int currMax = nums[0];

        int minSum = nums[0];
        int maxSum = nums[0];

        int totalSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(currMin, minSum);
            
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(currMax, maxSum);

            totalSum += nums[i];
        }

        System.out.println(maxSum + " " + minSum + " " + totalSum);

        int circularSum = totalSum - minSum;
        
        if(circularSum == 0){
            return maxSum;
        }

        return Math.max(maxSum, circularSum);
    }
}