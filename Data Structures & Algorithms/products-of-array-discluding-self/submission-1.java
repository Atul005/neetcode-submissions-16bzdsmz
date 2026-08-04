class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];

        int idx = -1;
        int zeros = 0;
        int prod = 1;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                idx = i;
                zeros++;
            }else{
                prod = prod * nums[i];
            }
        }

        if(zeros > 1){
            return res;
        }else if(zeros == 1){
            res[idx] = prod;
        }else{
            for(int i=0;i<nums.length;i++){
                res[i] = prod / nums[i];
            }
        }

        return res;
    }
}  
