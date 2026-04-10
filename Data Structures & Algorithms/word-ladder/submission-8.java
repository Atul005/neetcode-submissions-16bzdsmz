class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int edit=0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String str = queue.poll();
                if(str.equals(endWord)){
                    return edit+1;
                }

                for(String word : wordList){
                    if(!visited.contains(word) && isPossible(str, word)){
                        queue.offer(word);
                        visited.add(word);
                    }
                }


                size--;
            }
            edit++;
        }
        return 0;  
    }

    public boolean isPossible(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int i=0;
        int count=0;
        while(i<s1.length()){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 1){
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
