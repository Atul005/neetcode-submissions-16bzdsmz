class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(arr.length == 1){
            return 1;
        }

        int curr = 1;
        int ans = 1;
        int prevDir = 0;

        for(int i=1; i<n; i++){
            int currDir = 0;

            if(arr[i] > arr[i-1]){
                currDir = 1;
            }else if(arr[i] < arr[i-1]){
                currDir = -1;
            }


            if(currDir == 0){
                curr = 1;
            }else if(prevDir == 0 || currDir != prevDir){
                curr++;
                
            }else{
                curr = 2;
            }

            ans = Math.max(ans, curr);
            prevDir = currDir;
        }
        return ans;

    }


}