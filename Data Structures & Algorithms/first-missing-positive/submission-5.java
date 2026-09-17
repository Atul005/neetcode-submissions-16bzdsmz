class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        int oneCount = 0;

        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                oneCount++;
            }
            if(nums[i] <= 0){
                nums[i] = 1;
            }
        }

        if(oneCount == 0){
            return 1;
        }

        // System.out.println(Arrays.toString(nums));

        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) - 1;
            if(idx < n && nums[idx] > 0){
                nums[idx] = (-1)  * nums[idx];
            } 
        }

        System.out.println(Arrays.toString(nums));

        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        
        return n+1;

    }
}