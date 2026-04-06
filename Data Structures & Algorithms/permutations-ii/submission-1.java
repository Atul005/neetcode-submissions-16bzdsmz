class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permute(0, res, nums);
        return res;
    }

    public void permute(int index, List<List<Integer>> res, int[] arr){
        if(index == arr.length){
            List<Integer> temp = new ArrayList<>();
            for(int n : arr){
                temp.add(n);
            }
            res.add(temp);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i=index;i<arr.length;i++){
            if(set.contains(arr[i])){
                continue;
            }
            // if(i>index && arr[i] == arr[i-1]){
            //     continue;
            // }
            set.add(arr[i]);
            int t = arr[i];
            arr[i] = arr[index];
            arr[index] = t;
            permute(index+1, res, arr);
            t = arr[i];
            arr[i] = arr[index];
            arr[index] = t;
        }
    }
}