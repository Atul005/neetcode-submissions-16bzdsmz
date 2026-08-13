class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for(int i=0;i<26;i++){
            rank[order.charAt(i) - 'a'] = i;
        }
        String prev = words[0];
        for(int i=1;i<words.length;i++){
            String curr = words[i];
            int j = 0;
            int k = 0;
            while(j < prev.length() && k < curr.length()){
                if(rank[prev.charAt(j) - 'a'] == rank[curr.charAt(k) - 'a']){
                    j++;
                    k++;
                }else if(rank[prev.charAt(j) - 'a'] < rank[curr.charAt(k) - 'a']){
                    break;
                }else{
                    return false;
                }
            }
            if(j < prev.length() && k == curr.length()){
                return false;
            }
            prev = curr;
        }
        return true;
    }
}