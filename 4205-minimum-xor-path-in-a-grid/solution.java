class Solution {
    public int minCost(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][][] dp = new boolean[rows][cols][1024];

        dp[0][0][grid[0][0]] = true;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                for (int xor = 0; xor < 1024; xor++) {

                    if (!dp[row][col][xor]) {
                        continue;
                    }

                    if (row + 1 < rows) {
                        int nextXor = xor ^ grid[row + 1][col];
                        dp[row + 1][col][nextXor] = true;
                    }

                    if (col + 1 < cols) {
                        int nextXor = xor ^ grid[row][col + 1];
                        dp[row][col + 1][nextXor] = true;
                    }
                }
            }
        }

        for (int xor = 0; xor < 1024; xor++) {
            if (dp[rows - 1][cols - 1][xor]) {
                return xor;
            }
        }

        return -1;
    }
}
