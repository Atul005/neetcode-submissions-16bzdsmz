class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int[] tab = new int[nums.length];
        tab[0] = nums[0];
        tab[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            int pick = nums[i] + tab[i-2];
            int notPick = tab[i-1];
            tab[i] =  Math.max(pick, notPick);
        }

        return tab[nums.length-1];
    }
}
