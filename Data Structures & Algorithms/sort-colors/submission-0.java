class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int h = nums.length - 1;

        while(m <= h){
            if(nums[m] == 0){
                swap(nums, m, l);
                m++;
                l++;
            } else if(nums[m] == 2){
                swap(nums, m, h);
                h--;
            } else{
                m++;
            }
        }
    }

    private void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}