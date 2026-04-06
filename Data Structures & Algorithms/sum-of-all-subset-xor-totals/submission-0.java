class Solution {
    public int subsetXORSum(int[] nums) {
        int[] res = new int[1];
        ans(0, nums, res, new ArrayList<Integer>());
        return res[0];
    }

    public void ans(int index, int[] nums, int[] res, List<Integer> temp){
        int xor = 0;
        for(int i=0;i<temp.size();i++){
            xor = xor ^ temp.get(i);
        }
        res[0]+=xor;
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            ans(i+1, nums, res, temp);
            temp.remove(temp.size()-1);
        }
    }

}