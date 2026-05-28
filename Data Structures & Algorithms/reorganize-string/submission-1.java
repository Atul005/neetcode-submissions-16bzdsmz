class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> heap = 
                        new PriorityQueue<>((e1, e2 ) -> Integer.compare(e2.getValue(), e1.getValue()));

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            heap.offer(entry);
        }
        
        
        StringBuilder res = new StringBuilder();
        while(!heap.isEmpty()){
            Map.Entry<Character, Integer> entry = heap.poll();
            int size = res.length();
            int freq = entry.getValue();
            if(size > 0 && res.charAt(size - 1) == entry.getKey()){
                if(heap.isEmpty()){
                    return "";
                }
                Map.Entry<Character, Integer> entry2 = heap.poll();
                int freq2 = entry2.getValue();
                res.append(entry2.getKey());
                if(freq2 > 1){
                    freq2 = freq2 - 1;
                    heap.offer(Map.entry(entry2.getKey(), Integer.valueOf(freq2 - 1)));
                }
                heap.offer(Map.entry(entry.getKey(), Integer.valueOf(freq)));
            } else {
                res.append(entry.getKey());
                if(freq > 1){
                    heap.offer(Map.entry(entry.getKey(), Integer.valueOf(freq - 1)));
                }
            }
        }

        return  res.toString();
    }
}