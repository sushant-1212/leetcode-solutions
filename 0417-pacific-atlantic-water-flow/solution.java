class Solution {

    int m, n;
    int[][] mat;

    boolean[][] pacific;
    boolean[][] atlantic;

    boolean[][] vis;
    public void dfs(int i, int j) {

        vis[i][j] = true;

        if(i+1 < m && !vis[i+1][j] && mat[i+1][j] >= mat[i][j]) dfs(i+1, j);
        if(i-1 >= 0 && !vis[i-1][j] && mat[i-1][j] >= mat[i][j]) dfs(i-1, j);
        if(j+1 < n && !vis[i][j+1] && mat[i][j+1] >= mat[i][j]) dfs(i, j+1);
        if(j-1 >= 0 && !vis[i][j-1] && mat[i][j-1] >= mat[i][j]) dfs(i, j-1);
    }  

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        mat = heights;
        m = heights.length;
        n = heights[0].length;

        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        
        vis = pacific;                
        for(int i = 0; i < m; i++) dfs(i, 0);
        for(int j = 0; j < n; j++) dfs(0, j);

       
        vis = atlantic;               
        for(int i = 0; i < m; i++) dfs(i, n-1);
        for(int j = 0; j < n; j++) dfs(m-1, j);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

}
