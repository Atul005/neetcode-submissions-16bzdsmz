class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0] < nums[n-1]){
            return nums[0];
        }

        int l = 0;
        int h = n-1;
        int min = Integer.MAX_VALUE;

        while(l <= h){
            int mid = l + (h-l)/2;
            min = Math.min(min, nums[mid]);
            if(nums[l] <= nums[mid]){
                min = Math.min(min, nums[l]);
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }

        return min;
    }
}
