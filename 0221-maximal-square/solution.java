class Solution {
    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int maxSide = 0;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == '1') {

                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } 
                    else {

                        dp[row][col] =
                            Math.min(
                                dp[row - 1][col],
                                Math.min(
                                    dp[row][col - 1],
                                    dp[row - 1][col - 1]
                                )
                            ) + 1;
                    }

                    maxSide = Math.max(maxSide, dp[row][col]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
