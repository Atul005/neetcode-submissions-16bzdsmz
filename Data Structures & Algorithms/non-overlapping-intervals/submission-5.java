class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (t1, t2) -> t1[1] - t2[1]);

        int prevEnd = intervals[0][1];
        int count=0;
        for(int i=1;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(prevEnd > curr[0]){
                count++;
            }else{
                prevEnd = curr[1];
            }
        }
        return count;
    }
}
