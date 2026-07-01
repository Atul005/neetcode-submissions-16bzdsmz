class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0;
        int right = n-k;

        while(left < right){
            int mid = left + (right - left) / 2;
            int leftDiff = x - arr[mid];
            int rightDiff = arr[mid+k] - x;

            if(leftDiff > rightDiff){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=left;i<left + k;i++){
            res.add(arr[i]);
        }

        return res;
    }
}