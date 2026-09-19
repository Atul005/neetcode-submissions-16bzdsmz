class Solution {
    public int candy(int[] rat) {

        int n = rat.length;
        int i = 1;
        int sum = 1;

        while(i < n){

            if(i < n && rat[i-1] == rat[i]){
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;
            while(i < n && rat[i-1] < rat[i]){
                i++;
                peak++;
                sum += peak;
            }

            int down = 1;
            while(i < n && rat[i-1] > rat[i]){
                i++;
                sum += down;
                down++;
            }

            if(down > peak){
                sum += (down - peak);
            }

        }   

        return sum;
    }
}

/*
    4,3,5
    4,4,4
    5,5,5 

*/ 