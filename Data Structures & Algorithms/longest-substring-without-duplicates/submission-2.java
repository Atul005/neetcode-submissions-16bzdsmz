class Solution {
    public int lengthOfLongestSubstring(String s) {

        int i=0;
        int j=0;
        int n = s.length();
        int len = 0;
        Set<Character> set = new HashSet<>();
        
        while(i < n){
            char ch = s.charAt(i);
            while(set.contains(ch) && j < n){
                set.remove(s.charAt(j));
                j++;
            }
            len = Math.max(len, i - j + 1);
            set.add(ch);
            i++;
        }

        return len;
    }
}
