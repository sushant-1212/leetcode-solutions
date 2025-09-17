class Solution {
    public void rev(int row[]){
        int i = 0;
        int j = row.length-1;
        while(i<j){
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i<j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for(int i = 0; i<n; i++){
            rev(matrix[i]);
        }
    }
}
