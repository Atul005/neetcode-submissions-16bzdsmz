class Solution {
    public int largestRectangleArea(int[] h) {
        
        int n = h.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && h[stack.peek()] >= h[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            } else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && h[stack.peek()] >= h[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = n;
            } else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }

        // System.out.println(Arrays.toString(pse));
        // System.out.println(Arrays.toString(nse));

        int res = 0;

        for(int i=0;i<n;i++){
            res = Math.max(res, h[i] * (nse[i] - (pse[i] + 1)));
        }

        return res;
    }
}
