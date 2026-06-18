class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && temp[stack.peek()] <= temp[i]){
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? 0 : stack.peek()  - i;
            stack.push(i);
        }

        return ans;
    }
}
