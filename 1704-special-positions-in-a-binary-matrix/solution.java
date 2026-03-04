class Solution {
    public int numSpecial(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1){

                    int rowCount = 0;
                    int colCount = 0;

                  
                    for(int k = 0; k < n; k++){
                        if(mat[i][k] == 1) rowCount++;
                    }

                   
                    for(int k = 0; k < m; k++){
                        if(mat[k][j] == 1) colCount++;
                    }

                    if(rowCount == 1 && colCount == 1){
                        count++;
                    }
                }

            }
        }

        return count;
    }
}
