class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int ans = 0;
        for(String s:tokens)
        {
            if(s.equals("+") || s.equals("-") ||s.equals("/") || s.equals("*"))
            {
                String s2 = st.pop();
                String s1 = st.pop();
                st.push(help(Integer.parseInt(s1),Integer.parseInt(s2),s));
            }
            else
            {
                st.push(s);
            }
        }
        return Integer.parseInt(st.peek());
    }
    public String help(int s1,int s2,String op)
    {
        if(op.equals("+"))
        {
            return (s1+s2)+"";
        }
        else if(op.equals("-"))
        {
            return (s1-s2)+"";
        }
        else if(op.equals("*"))
        {
            return (s1*s2)+"";
        }
        else
        {
            return (s1/s2)+"";
        }
    }
}
