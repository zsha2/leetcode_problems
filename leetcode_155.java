class MinStack {

  Stack<Integer> stack;
  int min = Integer.MAX_VALUE;
  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<Integer>();
  }

  public void push(int x) {
    if(min >= x) {
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    if(stack.peek() == min) {
      stack.pop();
      min = stack.pop();
    }
    else stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
