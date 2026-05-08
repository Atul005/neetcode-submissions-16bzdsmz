class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int n = stones.length;
        
        for(int i=0;i<n;i++){
            maxHeap.offer(stones[i]);
        }


        while(maxHeap.size() > 1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            int c = Math.abs(a-b);
            if(c != 0){
                maxHeap.offer(c);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
