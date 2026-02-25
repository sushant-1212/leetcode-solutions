import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

       
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                    dist[i][j] = 0;   
                } else {
                    dist[i][j] = -1;  
                }
            }
        }

        
        while(!q.isEmpty()){

            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            
            if(i - 1 >= 0 && dist[i-1][j] == -1){
                dist[i-1][j] = dist[i][j] + 1;
                q.add(new int[]{i-1, j});
            }

           
            if(i + 1 < n && dist[i+1][j] == -1){
                dist[i+1][j] = dist[i][j] + 1;
                q.add(new int[]{i+1, j});
            }

            
            if(j - 1 >= 0 && dist[i][j-1] == -1){
                dist[i][j-1] = dist[i][j] + 1;
                q.add(new int[]{i, j-1});
            }

            
            if(j + 1 < m && dist[i][j+1] == -1){
                dist[i][j+1] = dist[i][j] + 1;
                q.add(new int[]{i, j+1});
            }
        }

        return dist;
    }
}
