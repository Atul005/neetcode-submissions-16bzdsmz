class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int count = 0;
        map.put(0, 1);
        int prefSum = 0;
        for(int i=0; i<nums.length; i++){
            prefSum += nums[i];
            int rem = prefSum - k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }
        System.out.println(map);
        return count;
    }
}   