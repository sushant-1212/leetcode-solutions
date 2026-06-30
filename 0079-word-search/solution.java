class Solution {

    int m;
    int n;

    char[][] board;
    String word;

    public boolean helper(int i, int j, int idx){

      
        if(idx == word.length()){
            return true;
        }

       
        if(i < 0 || j < 0 || i >= m || j >= n){
            return false;
        }

        if(board[i][j] != word.charAt(idx)){
            return false;
        }


        char temp = board[i][j];
        board[i][j] = '#';

        boolean ans = helper(i + 1, j, idx + 1) ||
                      helper(i - 1, j, idx + 1) ||
                      helper(i, j + 1, idx + 1) ||
                      helper(i, j - 1, idx + 1);

    
        board[i][j] = temp;

        return ans;
    }

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;

        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(board[i][j] == word.charAt(0)){

                    if(helper(i, j, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
