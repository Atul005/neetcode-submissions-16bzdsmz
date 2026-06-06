class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private int partition(int[] nums, int low, int high){
        int i = low -1;
        int pivot = nums[high];
        for(int j=low;j<high;j++){
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, high);
        return i+1;
    }

    private void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}