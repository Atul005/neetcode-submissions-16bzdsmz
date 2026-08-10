class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, nums.length, 0, res, new ArrayList<Integer>());
        return res;
    }

    public void solve(int[] nums, int n, int i, List<List<Integer>> res, List<Integer> temp){
        if(i == n){
            res.add(new ArrayList(temp));
            return;
        }
        //pick
        temp.add(nums[i]);
        solve(nums, n, i+1, res, temp);

        //unpick
        temp.remove(temp.size()-1);
        solve(nums, n, i+1, res, temp);
    }

}
