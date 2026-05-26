class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<int[]> heap = 
            new PriorityQueue<>((a1, b1) -> Integer.compare(b1[1], a1[1]));

        if (a > 0) heap.offer(new int[]{0, a});
        if (b > 0) heap.offer(new int[]{1, b});
        if (c > 0) heap.offer(new int[]{2, c});

        char[] chars = {'a', 'b', 'c'};

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while(!heap.isEmpty()){
            int[] peek = heap.poll();
            int idx = sb.length() - 1;

            if(idx >= 1 && sb.charAt(idx) == sb.charAt(idx-1) && sb.charAt(idx) == chars[peek[0]]){
                
                if(heap.isEmpty()){
                    break;
                }

                    int[] peek2 = heap.poll();
                    sb.append(chars[peek2[0]]);
                    int freq2 = peek2[1] - 1;
                    if(freq2 > 0){
                        heap.offer(new int[]{peek2[0], freq2});
                    }
                    flag = false;
                    heap.offer(peek);
                
            }else{
                sb.append(chars[peek[0]]);
            }
            if(flag){
                int freq = peek[1];
                if(freq > 1){
                    heap.offer(new int[]{peek[0], freq-1});
                }
            }
            flag = true;
        }

        return sb.toString();
    }
}