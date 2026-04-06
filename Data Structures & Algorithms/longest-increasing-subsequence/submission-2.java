class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int max = 1;
        Arrays.fill(res, 1);
        for(int i=1;i<n;i++){
            int val = arr[i];
            for(int j=0;j<i;j++){
                if(arr[j] < val){
                    res[i] = Math.max(1 + res[j],res[i]);
                    max = Math.max(res[i], max);
                }
            }
        }
        // System.out.println(Arrays.toString(res));
        return max;
    }
}
