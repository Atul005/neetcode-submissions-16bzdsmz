class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        permutations(nums, 0, n, res);
        return res;
    }

    public void permutations(int[] nums, int idx, int n, List<List<Integer>> res){
        if(idx == n){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }

        for(int i=idx;i<n;i++){
            swap(nums, idx, i);
            permutations(nums, idx+1, n, res);
            swap(nums, idx, i);
        }
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
