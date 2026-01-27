class Solution {
    String S;
    int[]dp;
    HashSet<String> wD;
    public int recursion(int index){
        if(index==S.length()){
            return 1;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int ans = 0;
        for(int j = index; j<S.length(); j++){
            String currans = S.substring(index,j+1);
            if(wD.contains(currans)){
                ans = ans | recursion(j+1);
            }
            if(currans.length()>20){
                break;
            }
        }
        dp[index]=ans;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        S = s;
        dp=new int[301];
        for(int i = 0; i<301; i++){
            dp[i]=-1;
        }
        wD = new HashSet<>();
        for(int i = 0; i<wordDict.size(); i++){
            wD.add(wordDict.get(i));
        }
        int ans = recursion(0);
        if(ans==1){
            return true;
        }
        return false;
    }
}
