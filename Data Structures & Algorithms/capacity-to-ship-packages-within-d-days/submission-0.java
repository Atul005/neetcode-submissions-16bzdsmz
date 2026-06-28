class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = weights[0];
        int n = weights.length;
        int max = weights[0];

        for(int i=1;i<n;i++){
            min = Math.max(min, weights[i]);
            max += weights[i];
        }

        int ans = max;

        while(min <= max){
            int mid = min + (max - min)/2;
            if(isValid(weights, mid, days)){
                ans = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }

        return ans;

    }

    public boolean isValid(int[] weights, int k, int days){
        int count = 1;
        int i = 1;
        int n = weights.length;
        int prefSum = weights[0];

        while(i < n){
            if(prefSum + weights[i] <= k){
                prefSum += weights[i]; 
            }else{
                count++;
                prefSum = weights[i];
            }
            i++;
            if(count > days){
                return false;
            }
        }

        if(count <= days){
            return true;
        }
        return false;
    }
}