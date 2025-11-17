class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int l = s.length();
        for(int i =0; i<l; i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            } else{
                if(st.peek()==s.charAt(i)){
                    st.pop();
                } else{
                    st.push(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
        
    }
}
