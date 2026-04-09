class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        dist[0][0] = 0;
        int[][] dirs = { {1,0} , {0,1} , {-1,0} , {0,-1} };
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r==m-1 && c ==n-1){
                return effort;
            }
            for(int i = 0; i<4; i++){
                int nr = r+dirs[i][0];
                int nc = c+dirs[i][1];
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int  edge = Math.abs(heights[r][c] - heights[nr][nc]);
                    int neweffort = Math.max(effort,edge);
                    if(neweffort<dist[nr][nc]){
                        dist[nr][nc]=neweffort;
                        pq.add(new int[]{neweffort,nr,nc});
                    }
                }
            }
        }
        return 0;
        
    }
}
