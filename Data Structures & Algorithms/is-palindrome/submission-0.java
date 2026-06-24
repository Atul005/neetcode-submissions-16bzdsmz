class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length() - 1;

        while(i <= j){
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));

            if(left == ' ' || !Character.isLetterOrDigit(left)){
                i++;
                continue;
            }
            
            if(right == ' ' || !Character.isLetterOrDigit(right)){
                j--;
                continue;
            }

            if(left != right){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
