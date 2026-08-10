class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] prev = res.get(res.size()-1);;
            int[] curr = intervals[i];
            if(prev[1] < curr[0]){
                res.add(curr);
            } else {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }



        return res.toArray(new int[res.size()][]);

    }
}
