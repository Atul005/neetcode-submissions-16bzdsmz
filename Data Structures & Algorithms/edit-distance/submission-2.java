class Solution {
    public int minDistance(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();

        if(m == 0 || n == 0){
            return Math.max(m, n);
        }

        int[][] tab = new int[m+1][n+1];

        for(int i=0;i<=n;i++){
            tab[0][i] = i;
        }

        for(int j=0;j<=m;j++){
            tab[j][0] = j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(w1.charAt(i-1) == w2.charAt(j-1)){
                    tab[i][j] = tab[i-1][j-1];
                }else{
                    tab[i][j] =1 +  Math.min(tab[i][j-1], Math.min(tab[i-1][j], tab[i-1][j-1]));
                }
            }
        }

        return tab[m][n];
    }
}
