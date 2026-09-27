import java.util.*;

public class Fordfulkerson {

    static int V;
    static long[][] capacity;

    static long dfs(int u, int sink, long flow, boolean[] visited) {
        if (u == sink)
            return flow;

        visited[u] = true;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && capacity[u][v] > 0) {

                long pushed = dfs(v, sink,
                        Math.min(flow, capacity[u][v]), visited);

                if (pushed > 0) {
                    capacity[u][v] -= pushed;
                    capacity[v][u] += pushed;
                    return pushed;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        int E = sc.nextInt();

        capacity = new long[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long c = sc.nextLong();

            capacity[u][v] += c;
        }

        long maxFlow = 0;

        while (true) {
            boolean[] visited = new boolean[V];

            long flow = dfs(0, V - 1, Long.MAX_VALUE, visited);

            if (flow == 0)
                break;

            maxFlow += flow;
        }

        System.out.println(maxFlow);
    }
}
