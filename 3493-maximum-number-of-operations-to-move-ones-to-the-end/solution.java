class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int ans = 0;
        int one = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i<n; i++){
            if(c[i]=='1'){
                one++;
            } else{
                if(i==0 || c[i-1]=='1' ){
                    ans+=one;
                }
            }
        }
        return ans;
        
    }
}
