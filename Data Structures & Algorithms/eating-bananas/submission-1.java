class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        for(int i=1;i<n;i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

        int low = 1;
        int high = max;
        int res = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(check(piles, h, mid)){
                res = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }

        }

        return res;
    }

    public boolean check(int[] piles, int h, int j){
        int count = 0;
        for(int i=0;i<piles.length;i++){
            count += (piles[i] + j - 1) / j;
        }
        if(count <= h){
            return true;
        }
        return false;
    }


}
