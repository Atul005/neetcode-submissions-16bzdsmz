class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];

        for(int[] i : trust){
            inDegree[i[0]]++;
            outDegree[i[1]]++;
        }

        for(int i=0;i<=n;i++){
            if(outDegree[i] == n-1 && inDegree[i] == 0){
                return i;
            }
        }

        return -1;
    }
}