class Solution {
    public void dfs(int[][] image, int i, int j, int color , int srcC , int n , int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return;
        }
        if(image[i][j]!=srcC){
            return;
        }
        image[i][j] = color;
        dfs(image,i-1,j,color,srcC,n,m);
        dfs(image,i+1,j,color,srcC,n,m);
        dfs(image,i,j-1,color,srcC,n,m);
        dfs(image,i,j+1,color,srcC,n,m);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int srcC = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        if(srcC!=color){
             dfs(image,sr,sc,color,srcC,n,m);
        }
        return image;
        
    }
}
