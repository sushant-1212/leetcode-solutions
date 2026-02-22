class Solution {
    public void dfs(int[][] image, int i, int j, int color , int src , int n , int m){
        
        if(i < 0 || j < 0 || i >= n || j >= m){
            return;
        }
        
        if(image[i][j] != src){
            return;
        }
        
        image[i][j] = color;
        
        dfs(image , i-1 , j , color, src , n , m);
        dfs(image , i+1 , j , color, src , n , m);
        dfs(image , i , j-1 , color, src , n , m);
        dfs(image , i , j+1 , color, src , n , m);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length;
        int m = image[0].length;
        
        int src = image[sr][sc];
        
        if(src != color){
            dfs(image, sr, sc, color, src, n, m);
        }
        
        return image;
    }
}
