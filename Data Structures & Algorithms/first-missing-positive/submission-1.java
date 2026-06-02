class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        int res = -1;

        while(i < nums.length){  //1,2,4,5,6,3,1
            int idx = nums[i]-1;
            if(nums[i] > 0 && nums[i] <= nums.length && idx != i && nums[i] != nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }else{
                i++;
            }
        }


        for(i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                res = i+1;
                break; 
            }
        }

        return res != -1 ? res : nums.length + 1;
    }
}