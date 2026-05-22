class Solution {
    public int searchInsert(int[] nums, int target) {
        int h = nums.length-1;
        int l = 0;
        int res = -1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(nums[mid] <= target){
                res = mid;
                l = mid + 1;
            } else if(nums[mid] > target){
                h = mid - 1;
            }
        } 

        if(res == -1){
            return 0;
        }

        return nums[res] == target ? res : res + 1;
    }
}