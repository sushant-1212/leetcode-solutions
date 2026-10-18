class Solution {
    public int[] lastVisitedCell(char[][] grid) {
         int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int r = 0, c = 0;
        visited[0][0] = true;

        while (true) {
            int nr = r, nc = c;

            if (grid[r][c] == 'L') nc--;
            else if (grid[r][c] == 'R') nc++;
            else if (grid[r][c] == 'U') nr--;
            else if (grid[r][c] == 'D') nr++;

            if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                break;

            if (visited[nr][nc])
                break;

            r = nr;
            c = nc;
            visited[r][c] = true;
        }

        return new int[]{r, c};
        
    }
}
