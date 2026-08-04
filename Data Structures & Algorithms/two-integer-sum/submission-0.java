class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i=0;i<nums.length;i++){
            int key = target - nums[i];
            if(map.containsKey(key)){
                res[0] = map.get(key);
                res[1] = i;
                return res;
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
}
