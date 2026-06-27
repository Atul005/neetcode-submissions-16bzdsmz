class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int can1 = -1;
        int can2 = -1;
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == can1){
                count1++;
            } else if(nums[i] == can2){
                count2++;
            } else if(count1 == 0){
                can1 = nums[i];
                count1++;
            } else if(count2 == 0){
                can2 = nums[i];
                count2++;
            } else{
                count1--;
                count2--;;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == can1){
                count1++;
            }
            if(nums[i] == can2){
                count2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length / 3){
            res.add(can1);
        }

        if(count2 > nums.length / 3){
            res.add(can2);
        }

        Collections.sort(res);

        return res;
    }
}