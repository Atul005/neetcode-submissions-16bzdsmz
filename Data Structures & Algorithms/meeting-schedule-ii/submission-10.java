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
    public int minMeetingRooms(List<Interval> intervals) {
        
        int n = intervals.size();
        
        int[] arr = new int[n];
        int[] dep = new int[n];

        for(int i=0;i<n;i++){
            Interval t = intervals.get(i);
            arr[i] = t.start;
            dep[i] = t.end;
        }

        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0;
        int res = 0;

        int i=0;
        int j=0;

        while(i<n && j<n){
            if(dep[j] > arr[i]){
                count++;
                i++;
                res = Math.max(res, count);
            }else{
                count--;
                j++;
            }
        }

        return res;
    }
}
