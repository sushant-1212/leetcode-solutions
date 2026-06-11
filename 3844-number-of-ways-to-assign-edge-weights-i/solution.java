class Solution {

    long MOD = 1000000007;
    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, -1, 0, graph);

        return (int) power(2, maxDepth - 1);
    }

    public void dfs(int node, int parent, int depth,
                    ArrayList<Integer>[] graph) {

        if (depth > maxDepth) {
            maxDepth = depth;
        }

        for (int i = 0; i < graph[node].size(); i++) {

            int next = graph[node].get(i);

            if (next == parent) {
                continue;
            }

            dfs(next, node, depth + 1, graph);
        }
    }

    public long power(long base, int exp) {

        long ans = 1;

        while (exp > 0) {

            if (exp % 2 == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;

            exp = exp / 2;
        }

        return ans;
    }
}
