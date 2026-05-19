class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        
        for(int i=0;i<gifts.length;i++){
            maxHeap.offer(gifts[i]);
        }
        
        while(k > 0){
            int max = maxHeap.poll();
            maxHeap.offer((int)Math.floor(Math.sqrt(max)));
            k--;
        }

        int sum = 0;

        while(!maxHeap.isEmpty()){
            sum += maxHeap.poll();
        }

        return sum;
    }
}