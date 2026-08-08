class Solution {
    public int largestRectangleArea(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;
        int res = 0;

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                int idx = stack.pop();
                if(stack.isEmpty()){
                    res = Math.max(res, arr[idx]*(i - (-1) - 1));
                }else{
                    res = Math.max(res, arr[idx]*(i - stack.peek() - 1));
                }
            }
            stack.push(i);   
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            if(stack.isEmpty()){
                res = Math.max(res, arr[idx]*(n - (-1) - 1));
            }else{
                res = Math.max(res, arr[idx]*(n - stack.peek() - 1));
            }
        }

        return res;
    }
}
