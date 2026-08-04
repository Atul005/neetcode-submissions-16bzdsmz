class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((
            (a, b) -> map.get(a) - map.get(b)
        ));
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(heap.size() < k){
                heap.offer(entry.getKey());
            } else if(map.get(heap.peek()) < entry.getValue()){
                heap.poll();
                heap.offer(entry.getKey());
            }
            
        }

        System.out.println(heap);

        int[] res = new int[k];
        for(int j=0;j<k;j++){
            res[j] = heap.poll();
        }

        return res;
    }
}
