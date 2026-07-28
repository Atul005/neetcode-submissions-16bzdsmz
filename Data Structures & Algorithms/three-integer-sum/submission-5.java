class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            int l = i+1;
            int r = n-1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }

                    while(l < r && nums[r+1] == nums[r]){
                        r--;
                    }

                }
                else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }

            while(i < n-1 && nums[i+1] == nums[i]){
                i++;
            }

        }

        return res;
    }
}
