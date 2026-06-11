class MinStack {

    Deque<Pair> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val, val));
        } else{
            if(stack.peek().b < val){
                stack.push(new Pair(val, stack.peek().b));
            }else{
                stack.push(new Pair(val, val));
            }
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().a;
    }
    
    public int getMin() {
        return stack.peek().b;
    }

    // private int min;
    // private List<Integer> list;
    // private PriorityQueue<Integer> minHeap;

    // public MinStack() {
    //     this.list = new LinkedList<>(); 
    //     this.min = Integer.MAX_VALUE;
    //     this.minHeap = new PriorityQueue<>();
    // }
    
    // public void push(int val) {
    //     list.addFirst(val);
    //     minHeap.offer(val);
    // }
    
    // public void pop() {
    //     int removed = list.removeFirst();
    //     if(removed == minHeap.peek()){
    //         minHeap.poll();
    //     }
    // }
    
    // public int top() {
    //     return list.get(0);
    // }
    
    // public int getMin() {
    //     return minHeap.peek();
    // }

}

class Pair{
    int a;
    int b;

    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

}
