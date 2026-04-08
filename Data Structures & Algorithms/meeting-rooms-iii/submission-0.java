class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a,b) -> { return a[0] - b[0];});
        PriorityQueue<long[]> busyRooms = 
            new PriorityQueue<>((a, b) -> 
                {
                    if(a[0] == b[0]){
                        return Long.compare(a[1],b[1]);
                    }
                    return Long.compare(a[0],b[0]);
                });

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            freeRooms.offer(i);
        }

        int[] count = new int[n];

        for(int[] meeting : meetings){
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            while(!busyRooms.isEmpty() &&  busyRooms.peek()[0] <= start){
                int room = (int)busyRooms.poll()[1];
                freeRooms.offer(room);
            }

            if(!freeRooms.isEmpty()){
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            }else{
                long[] earliest = busyRooms.poll();
                long newStart = earliest[0];
                long newEnd = newStart +  duration;
                int room = (int)earliest[1];
                busyRooms.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }

        System.out.println(Arrays.toString(count));

        int maxRoom = 0;
        for(int i=1;i<n;i++){
            if(count[i] > count[maxRoom]){
                maxRoom = i;
            } 
        }

        return maxRoom;
    }
}