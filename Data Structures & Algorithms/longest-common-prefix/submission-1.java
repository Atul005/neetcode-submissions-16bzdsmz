class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int i=0;
        while(i < first.length() && first.charAt(i) == last.charAt(i)){
            res.append(first.charAt(i));
            i++;
        }
        return res.toString();
        // StringBuilder res = new StringBuilder();
        // int min = Integer.MAX_VALUE;
        // for(int i=0;i<strs.length;i++){
        //     if(strs[i].length() < min){
        //         min = strs[i].length();
        //     }
        // }

        // String temp = strs[0];
        // for(int i=0;i<min;i++){
        //     boolean f = true;
        //     for(int j=1;j<strs.length;j++){
        //         if(temp.charAt(i) != strs[j].charAt(i)){
        //             f = false;
        //             break;
        //         }
        //     }
        //     if(f){
        //         res.append(temp.charAt(i));
        //     }else{
        //         break;
        //     }
        // }

        // return res.toString();
    }
}