class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {return a[0] - b[0];});

        res.add(intervals[0]);
        int[] prev = intervals[0];
        for(int i=1; i<n; i++){
            int[] curr = intervals[i];
            if(prev[1] >= curr[0]){
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }else {
                res.add(curr);
                prev = curr;
            }
        }
        return res.toArray(new int[0][]); 
    }
}
