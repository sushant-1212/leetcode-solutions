class Solution {

    int value = 0;

    public void fill(int[][] grid, int row, int col, int size) {

        if (size == 1) {
            grid[row][col] = value;
            value++;
            return;
        }

        int half = size / 2;

        fill(grid, row, col + half, half);

        
        fill(grid, row + half, col + half, half);

        
        fill(grid, row + half, col, half);

      
        fill(grid, row, col, half);
    }

    public int[][] specialGrid(int n) {

        int size = 1 << n;

        int[][] grid = new int[size][size];

        fill(grid, 0, 0, size);

        return grid;
    }
}
