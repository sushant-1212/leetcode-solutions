class Solution {

    int[][] arr;
    boolean[] visited;

    public int removeStones(int[][] stones) {
        arr = stones;
        visited = new boolean[stones.length];

        int components = 0;

        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                components++;
                dfs(i);
            }
        }

        return stones.length - components;
    }

    void dfs(int i) {
        visited[i] = true;

        for (int j = 0; j < arr.length; j++) {
            if (!visited[j] &&
                (arr[i][0] == arr[j][0] ||
                 arr[i][1] == arr[j][1])) {

                dfs(j);
            }
        }
    }
}
