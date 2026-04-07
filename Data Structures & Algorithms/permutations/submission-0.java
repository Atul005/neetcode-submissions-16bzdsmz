class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteAll(0, res, nums);
        return res;
    }

    public void permuteAll(int index, List<List<Integer>> res, int[] nums){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            res.add(temp);
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(nums, index, i);
            permuteAll(index+1, res, nums);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
