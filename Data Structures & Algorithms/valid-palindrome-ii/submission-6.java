class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int h = s.length() - 1;

        while(l<h){
            if(s.charAt(l) != s.charAt(h)){
                return isPalindrome(s, l+1, h) || isPalindrome(s, l, h-1);
            }
            l++;
            h--;
        } 
        return true;
    }

    public boolean isPalindrome(String str, int l, int h){
        while(l < h){
            if(str.charAt(l) != str.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

}

