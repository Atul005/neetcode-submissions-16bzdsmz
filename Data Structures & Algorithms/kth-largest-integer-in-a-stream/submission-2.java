class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        minHeap = new PriorityQueue<Integer>(k);
        for(int i=0;i<nums.length;i++){
            minHeap.offer(nums[i]);
            if(minHeap.size() > k){
                    minHeap.poll();
            }
            // System.out.println(minHeap);  
        }
        
    }
    
    public int add(int val) {
        // System.out.println(minHeap + " " + minHeap.peek());
        minHeap.offer(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}
