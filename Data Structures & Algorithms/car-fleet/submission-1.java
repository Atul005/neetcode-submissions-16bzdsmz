class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = speed.length;
        int count = 0;
        Deque<Double> stack =  new ArrayDeque<>();

        double[][] arr = new double[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = (double)position[i];
            arr[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(arr, (a, b) -> Double.compare(b[0],a[0]));

        double maxTime = 0;
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(arr[i][1]);
            }
            else if(arr[i][1] <= stack.peek()){
                continue;
            }else{
                stack.push(arr[i][1]);
            }
        }

        return stack.size();
    }    
}
