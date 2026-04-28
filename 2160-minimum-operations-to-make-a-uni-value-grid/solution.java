import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {

        int m = grid.length;
        int n = grid[0].length;

        
        int[] arr = new int[m * n];
        int k = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k] = grid[i][j];
                k++;
            }
        }

       
        int base = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - base) % x != 0) {
                return -1;
            }
        }

     
        Arrays.sort(arr);

        
        int target = arr[arr.length / 2];

      
        int ops = 0;
        for (int i = 0; i < arr.length; i++) {
            ops += Math.abs(arr[i] - target) / x;
        }

        return ops;
    }
}
