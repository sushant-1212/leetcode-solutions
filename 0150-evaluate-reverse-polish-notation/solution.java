class Solution {
           public boolean isOperator(String s){
            return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
        }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        for(int i =0; i<n; i++){
            String token = tokens[i];
            if(!isOperator(token)){
                int num = Integer.parseInt(token);
                st.push(num);
                
            } else{
                int b = st.pop();
                int a = st.pop();
                int result = 0;
                if(token.equals("+")){
                    result = a+b;
                } if(token.equals("-")){
                    result = a-b;
                }
                if(token.equals("*")){
                    result = a*b;
                }
                if(token.equals("/")){
                    result = a/b;
                }
                st.push(result);
            }
        }
        return st.pop();
        
    }
}
