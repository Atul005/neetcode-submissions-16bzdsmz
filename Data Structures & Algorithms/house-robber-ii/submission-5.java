class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int[] num1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] num2 = Arrays.copyOfRange(nums, 1, nums.length);


        // System.out.println(Arrays.toString(num1) +" && "+ Arrays.toString(num2));

        int res1 = solve(num1);
        int res2 = solve(num2);

        return Math.max(res1, res2);
    }

    
    public int solve(int[] nums){
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        int[] tab = new int[n];

        tab[0] = nums[0];
        tab[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<n;i++){
            int pick = nums[i] + tab[i-2];
            int notPick = tab[i-1];
            tab[i] = Math.max(pick, notPick);
        }

        return tab[n-1];
    }
}
