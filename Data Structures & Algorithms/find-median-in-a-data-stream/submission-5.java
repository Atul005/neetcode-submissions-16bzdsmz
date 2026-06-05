class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    List<Integer> stream;

    public MedianFinder() {
        stream = new ArrayList<>();
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }        
    }
    
    public double findMedian() {
        int size1 = maxHeap.size();
        int size2 = minHeap.size();
        
        if(size1 == 0){
            return 0.0;
        }else if(size2 == 0 || (size1 + size2) % 2 == 1){
            return maxHeap.peek(); 
        } else{
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

}
