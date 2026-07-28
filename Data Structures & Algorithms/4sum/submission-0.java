class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n-3;i++){
            int tar = target - nums[i];
            for(int j=i+1;j<n-2;j++){
                // int key = tar - nums[j];
                int l = j+1;
                int r = n-1;
                while(l < r){
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while(l < r && nums[l-1] == nums[l]){
                            l++;
                        }
                        while(l < r && nums[r+1] == nums[r]){
                            r--;
                        }
                    } else if(sum < target){
                        l++;
                    }else{  
                        r--;
                    }
                }

                while(j < n-3 && nums[j+1] == nums[j]){
                    j++;
                }
            }
            while(i < n-4 && nums[i+1] == nums[i]){
                i++;
            }
        }
        return res;
    }
}