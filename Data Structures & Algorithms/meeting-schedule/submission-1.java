/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> i1.end - i2.end);
        int n = intervals.size();
        for(int i=1;i<n;i++){
            Interval prev = intervals.get(i-1);
            Interval curr = intervals.get(i);

            if(curr.start < prev.end){
                return false;
            }
        }
        return true;
    }
}
