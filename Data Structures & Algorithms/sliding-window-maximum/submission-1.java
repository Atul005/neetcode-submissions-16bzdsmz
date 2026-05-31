class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for(int i=0;i<nums.length;i++){
            maxHeap.offer(new int[]{nums[i], i});
            if(maxHeap.size() >= k){
                int[] poll = maxHeap.peek();
                if(i - poll[1] < k){
                    res[j] = poll[0];
                    j++;
                }else{
                    while(i - maxHeap.peek()[1] >= k){
                        maxHeap.poll();
                    }
                    res[j] = maxHeap.peek()[0];
                    j++;
                }                
            }
        }
        return res;
    }
}
