class Solution {
    int[][] mat;
    int[][]vis;
    int m;
    int n;
    public boolean dfs(int i, int j){
        if(i==m-1 && j==n-1){
            return true;
        }
        if(i<0 || i>=m || j<0 || j>=n){
            return false;
        }
        vis[i][j]=1;
        int val = mat[i][j];


        // left moment..

        if(val == 1 || val == 3 || val == 5){
            int nextI = i;
            int nextJ = j-1;
            if(nextJ>=0 && vis[nextI][nextJ]==0){
                int nextVal = mat[nextI][nextJ];
                if(nextVal == 1 || nextVal == 4 || nextVal == 6){
                    if(dfs(nextI,nextJ)){
                        return true;
                    }
                }
            }
        }

        // right moment..

         if(val == 1 || val == 4 || val == 6){
            int nextI = i;
            int nextJ = j+1;
            if(nextJ<n && vis[nextI][nextJ]==0){
                int nextVal = mat[nextI][nextJ];
                if(nextVal == 1 || nextVal == 3 || nextVal == 5){
                    if(dfs(nextI,nextJ)){
                        return true;
                    }
                }
            }
        }

        // up moment..


         if(val == 2 || val == 5 || val == 6){
            int nextI = i-1;
            int nextJ = j;
            if(nextI>=0 && vis[nextI][nextJ]==0){
                int nextVal = mat[nextI][nextJ];
                if(nextVal == 2 || nextVal == 3 || nextVal == 4){
                    if(dfs(nextI,nextJ)){
                        return true;
                    }
                }
            }
        }

        // down moment...

         if(val == 2 || val == 3 || val == 4){
            int nextI = i+1;
            int nextJ = j;
            if(nextI<m && vis[nextI][nextJ]==0){
                int nextVal = mat[nextI][nextJ];
                if(nextVal == 2 || nextVal == 5 || nextVal == 6){
                    if(dfs(nextI,nextJ)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        mat = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new int[m][n];
        return dfs(0,0);
    }
}
