class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }

        if(total % k != 0){
            return false;
        }

        int sum = total / k;
        Arrays.sort(nums);
        reverse(nums);
        int[] sides = new int[k];
        return partition(0, nums, sides, sum);
    }

    public boolean partition(int idx, int[] nums, int[] sides, int sum){
        if(idx == nums.length){
            for(int side : sides){
                if(side != sum){
                    return false;
                }
            }
            return true;
        }

        for(int i=0;i<sides.length;i++){

            if(i > 0 && sides[i] == sides[i - 1]) {
                continue;
            }
            if(sides[i] + nums[idx] > sum){
                continue;
            }

            sides[i] = sides[i] + nums[idx];
            if(partition(idx+1, nums, sides, sum)){
                return true;
            }
            sides[i] = sides[i] - nums[idx];

            if(sides[i] == 0) break;
        }
        return false;
    }

    public void reverse(int[] arr){
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}