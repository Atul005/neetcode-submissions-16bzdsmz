class StockSpanner {
    
    Deque<Pair> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span=1;
        boolean isDone = false;
        if(stack.isEmpty()){
            stack.push(new Pair(price, 1));
            return span;
        }

        while(!stack.isEmpty() && !isDone){
            if(price >= stack.peek().a){
                span += stack.pop().b;
            }else {
                stack.push(new Pair(price, span));
                isDone = true;
            }
        }

        if(stack.isEmpty() && !isDone){
            stack.push(new Pair(price, span));
        }

        return span;
    }
}


class Pair{
    int a;
    int b;

    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */