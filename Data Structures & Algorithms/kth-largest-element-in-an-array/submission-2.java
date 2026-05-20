class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            
            if(heap.size() == k){
                if(heap.peek() > nums[i]){
                    continue;
                }else{
                    heap.poll();
                }
            }

            heap.offer(nums[i]);
        }
        return heap.peek();
    }
}
