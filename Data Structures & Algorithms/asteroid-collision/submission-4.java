class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int n : asteroids) {
            boolean isAlive = true;

            if (stack.isEmpty()) {
                stack.push(n);
                continue;
            }

            while (!stack.isEmpty() && isAlive && stack.peek() > 0 && n < 0) {
                if (Math.abs(stack.peek()) < Math.abs(n)) {
                    stack.pop();
                } else if (Math.abs(stack.peek()) == Math.abs(n)) {
                    stack.pop();
                    isAlive = false;
                } else {
                    isAlive = false;
                }
            }
            if(isAlive) stack.push(n);
        }

        int[] res = new int[stack.size()];
            int i = 0;
            for (int n : stack) {
                res[i] = n;
                i++;
            }
            for (i = 0; i < res.length / 2; i++) {
                int temp = res[i];
                res[i] = res[res.length - 1 - i];
                res[res.length - 1 - i] = temp;
            }
            return res;
    }
}