class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(new StringBuilder());
            } else if( ch == ')'){
                StringBuilder current = stack.pop();
                current.reverse();
                stack.peek().append(current);
            } else{
                stack.peek().append(ch);
            }
        }
        return stack.pop().toString();
        
    }
}
