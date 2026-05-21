class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (a, b) -> Integer.compare(b[2], a[2]));
        int[][] res = new int[k][2];
        for(int[] p : points){
            int d = calculateDis(p);
            if(maxHeap.size() < k){
                maxHeap.offer(new int[]{p[0], p[1], d});
            }
            else if(d < maxHeap.peek()[2]){
                maxHeap.poll();
                maxHeap.offer(new int[]{p[0], p[1], d});
            }             
        }
        int i = 0;
        for(int[] point : maxHeap){
            res[i] = new int[]{point[0], point[1]};
            i++;
        }
        return res;
    }

    public int calculateDis(int[] p){
        return p[0]*p[0] + p[1]*p[1];
    }

}
