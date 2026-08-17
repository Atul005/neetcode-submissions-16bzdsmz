class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }

        int i = s1.length()-1;
        int j = 0;

        while(j < s2.length()){
            if((j + s1.length() - 1) < s2.length() && isPermutation(s2.substring(j, s1.length()+j), s1)){
                return true;
            }
            j++;
        }
        return false;
    }

    public boolean isPermutation(String s1, String s2){
        int[] chars = new int[26];

        for(int i=0;i<s1.length();i++){
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }


        for(int i=0;i<26;i++){
            if(chars[i] > 0){
                return false;
            }
        }

        return true;
    }

    

}
