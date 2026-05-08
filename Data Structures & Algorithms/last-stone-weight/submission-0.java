class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int n = stones.length;
        
        for(int i=0;i<n;i++){
            maxHeap.offer(stones[i]);
        }


        while(maxHeap.size() != 1){
            System.out.println(maxHeap);
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            maxHeap.offer(Math.abs(a-b));
        }

        return maxHeap.poll();
    }
}
