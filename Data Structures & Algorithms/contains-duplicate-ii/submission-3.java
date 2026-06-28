class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();
        int i=0;
        int n = nums.length;
        int j=0;
        while(i < n){
            if(set.contains(nums[i])){
                if(i - j <=k){
                    return true;
                }
            }
            set.add(nums[i]);
            while(set.size() > k && j < nums.length){
                set.remove(nums[j]);
                j++;
            }
            i++;
        }
        return false;
    }
}