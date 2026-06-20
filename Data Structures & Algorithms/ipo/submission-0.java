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

        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(arr[i]));
        }

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



        // for(int i=0; i<n; i++){
        //     if(k == 0){
        //         break;
        //     }
        //     else if(res >= arr[i][0]){
        //         k--;
        //         res += arr[i][1];
        //     }else{
        //         break;
        //     }
        // }
        
        return res;
        // PriorityQueue<Pair> capitalHeap = new PriorityQueue<>();
        // PriorityQueue<Pair> profitHeap = new PriorityQueue<>((p1, p2) -> {
            
        // });

        // int n = profits.length;
        
        // for(int i=0;i<n;i++){
        //     capitalHeap.offer(capital[i]);
        //     profitHeap.offer(capital[i]);
        // }

        // int res = 0;

        // while(k > 0){
        //     if(minHeap.peek().a <= w){
        //         k--;
        //         w = w + minHeap.peek().b;   
        //     }
        //     minHeap.poll();
        // }

        // return w;
    }
}

// class Pair{
//     int a;
//     int b;

//     Pair(int a, int b){
//         this.a = a;
//         this.b = b;
//     }
// }