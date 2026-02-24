class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]>q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int mints = 0;
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            mints++;
            for(int k = 0; k<size; k++){
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];
                if(i-1>=0 && grid[i-1][j]==1){
                    grid[i-1][j] = 2;
                    fresh--;
                    q.add(new int[]{i-1,j});
                }
                if(i+1<n && grid[i+1][j]==1){
                    grid[i+1][j] = 2;
                    fresh--;
                    q.add(new int[]{i+1,j});
                }
                if(j-1>=0 && grid[i][j-1]==1){

                    grid[i][j-1] = 2;
                    fresh--;
                    q.add(new int[]{i,j-1});
                }

                if(j+1<m && grid[i][j+1]==1){

                    grid[i][j+1] = 2;
                    fresh--;
                    q.add(new int[]{i,j+1});
                }
            }
        }
        if(fresh == 0){
            return mints;
        }
        return -1;
        
    }
}
