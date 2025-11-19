class MinStack {
     Stack<Integer> st;
     Stack<Integer> minstk; 

    public MinStack() {
       st = new Stack<>();
       minstk = new Stack<>();
        
    }
    
    public void push(int val) {
        st.push(val);
        if(minstk.isEmpty() || val<=minstk.peek()){
            minstk.push(val);
        }
        
    }
    
    public void pop() {
        int rev = st.pop();
        if(rev == minstk.peek()){
            minstk.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return minstk.peek();
        
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
