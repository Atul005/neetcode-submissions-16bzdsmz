class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        sets(0, nums, res, new ArrayList<>());
        // System.out.println(res);
        return res;
    }

    public void sets(int idx, int[] nums, List<List<Integer>> res, List<Integer> l){
        // res.add(new ArrayList<>(l));

        // for(int i=idx;i<nums.length;i++){
        //     l.add(nums[i]);
        //     sets(i+1,nums, res, l);
        //     l.remove(l.size() - 1);
        // }

        if(idx == nums.length){
            res.add(new ArrayList<>(l));
            return;
        }

        l.add(nums[idx]);
        sets(idx+1, nums, res,l);
        l.remove(l.size()-1);
        sets(idx+1, nums, res, l);
    }
}
