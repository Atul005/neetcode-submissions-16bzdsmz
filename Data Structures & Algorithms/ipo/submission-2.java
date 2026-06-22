class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        int[][] arr = new int[n][2];

        

        for(int i=0;i<n;i++){
            arr[i][0] = capital[i];
            arr[i][1] = profits[i]; 
        }      

        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int res = w;

        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
 
        int idx = 0;
        while(k > 0){
           while(idx < n && arr[idx][0] <= res){
                max.offer(arr[idx][1]);
                idx++;
            }   

            if(max.isEmpty()){
                break;
            }

            res += max.poll();
            k--;
        }
        
        return res;
    }
}

class Pair{
    int a;
    int b;

    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}