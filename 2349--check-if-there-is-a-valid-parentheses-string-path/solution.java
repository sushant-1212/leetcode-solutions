class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        Queue<int[]> q = new LinkedList<>();

        int balance = 0;

        if (grid[0][0] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        q.offer(new int[]{0, 0, balance});

        boolean[][][] visited = new boolean[m][n][m + n];

        visited[0][0][balance] = true;

        int[][] dir = {
            {1, 0},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int bal = curr[2];

            if (r == m - 1 && c == n - 1) {
                if (bal == 0) {
                    return true;
                }
            }

            for (int i = 0; i < 2; i++) {

                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr >= m || nc >= n) {
                    continue;
                }

                int newBalance = bal;

                if (grid[nr][nc] == '(') {
                    newBalance++;
                } else {
                    newBalance--;
                }

                if (newBalance < 0) {
                    continue;
                }

                if (visited[nr][nc][newBalance]) {
                    continue;
                }

                visited[nr][nc][newBalance] = true;

                q.offer(new int[]{nr, nc, newBalance});
            }
        }

        return false;
    }
}
