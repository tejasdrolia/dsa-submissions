class MinStack {
    Stack<Integer> st;
    Stack<Integer> stmin;
    public MinStack() {
        st = new Stack<>();
        stmin = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(stmin.size()==0)
        stmin.push(val);
        else
        {
            if(val<stmin.peek())
            {
                stmin.push(val);
            }
            else
            stmin.push(stmin.peek());
        }
    }
    
    public void pop() {
        st.pop();
        stmin.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return stmin.peek();
    }
}
