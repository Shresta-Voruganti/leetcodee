class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> minheap;

    public MinStack() {
        stack = new Stack<>();
        minheap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.push(val);
        minheap.add(val);
    }
    
    public void pop() {
        int val = stack.pop();
        minheap.remove(val);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minheap.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */