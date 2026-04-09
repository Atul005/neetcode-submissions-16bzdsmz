class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int p1 = maxPro(0, nums.length-2, nums);
        int p2 = maxPro(1, nums.length-1, nums);
        return Math.max(p1, p2);
    }

    public int maxPro(int start, int end, int[] nums){
        int[] tab = new int[nums.length];

        int first = 0;
        int sec = nums[start];

        for(int i=start+1;i<=end;i++){
            int curr = Math.max(sec, first + nums[i]);
            first = sec;
            sec = curr;
        }
        return sec;  
    }
}
