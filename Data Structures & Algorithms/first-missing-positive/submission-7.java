class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        boolean onePresent = false;

        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                onePresent = true;
            }
            if(nums[i] <= 0){
                nums[i] = 1;
            }
        }

        if(!onePresent){
            return 1;
        }

        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) - 1;
            if(idx < n && nums[idx] > 0){
                nums[idx] = (-1)  * nums[idx];
            } 
        }

        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        
        return n+1;

    }
}