class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<StringBuilder> chessBoard = new ArrayList();
    boolean isSafe(int r, int c , int n){
        for(int i = 0; i<r; i++){
            if(chessBoard.get(i).charAt(c)== 'Q'){
                return false;
            }
        }
        int R = r;
        int C = c;
        while(R>=0 && C>=0){
            if(chessBoard.get(R).charAt(C)=='Q'){
                return false;
            }
            R--;
            C--;
        }
        R = r;
        C = c;
        while(R>=0 && C<n){
            if(chessBoard.get(R).charAt(C)=='Q'){
                return false;
            }
            R--;
            C++;
        }
        R = r;
        C = c;
        while(R<n && C>=0){
            if(chessBoard.get(R).charAt(C)=='Q'){
                return false;
            }
            R++;
            C--;
        }
        R = r;
        C = c;
        while(R<n && C<n){
            if(chessBoard.get(R).charAt(C)=='Q'){
                return false;
            }
            R++;
            C++;
        }
        return true;
    }
    public void recur(int row , int n){
        if(row==n){
            List<String> currentAns = new ArrayList<>();
            for(int i = 0; i<chessBoard.size(); i++){
                currentAns.add(chessBoard.get(i).toString());
            }
            ans.add(new ArrayList<>(currentAns));
        }
        for(int j = 0; j<n; j++){
            if(isSafe(row,j,n)){
                chessBoard.get(row).setCharAt(j,'Q');
                recur(row+1,n);
                chessBoard.get(row).setCharAt(j,'.');
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        for(int i = 0; i<n;  i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0; j<n; j++){
                row.append(".");
            }
            chessBoard.add(row);
        }
        recur(0,n);
        return ans;
        
    }
}
