class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        
        for(int i=0; i<n; i++){
            int target = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i+1;j<n;j++){
                int key = target - nums[j];
                if(map.containsKey(key)){
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[j]);
                    temp.add(nums[i]);
                    temp.add(key);
                    Collections.sort(temp);
                    res.add(temp);
                }else{
                    map.put(nums[j], 1);
                }
            }
        }

        return new ArrayList(res);
    }
}
