class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subSets(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    public void subSets(int index, int[] nums, List<List<Integer>> res, List<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            if(i > index  && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            subSets(i+1, nums, res, temp);
            temp.remove(temp.size()-1);
        }
    }

}
