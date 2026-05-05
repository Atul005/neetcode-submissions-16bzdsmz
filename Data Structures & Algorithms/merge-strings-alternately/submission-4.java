class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        boolean flag = true;
        StringBuilder res = new StringBuilder();

        while(i < word1.length() && j < word2.length()){
            if(flag){
                res.append(word1.charAt(i));
                i++;
            }else{
                res.append(word2.charAt(j));
                j++;
            }
            flag = !flag;
        }

        System.out.println("i - "+i+" & j-"+j+" & "+res.toString());

        while(i < word1.length()){
            res.append(word1.charAt(i));
            i++;
        }

        while(j < word2.length()){
            res.append(word2.charAt(j));
            j++;
        }
        return res.toString();
    }
}