package Graph;

import java.util.ArrayList;

public class Part1DFS {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 connects to 1, 2
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 connects to 0, 3
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 connects to 0, 4
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 connects to 1, 5, 4
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 4, 1));

        // 4 connects to 2, 5, 3
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 3, 1));

        // 5 connects to 3, 4, 6
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 connects to 5
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    // FIXED hasPath
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if (src == dest){
            return true;
        }

        // FIX 1: You must mark the current node as visited!
        // Otherwise, the code will bounce back and forth (0->1->0...) forever.
        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];

        System.out.print("DFS Traversal: ");
        dfs(graph, 0, vis);
        System.out.println(); // New line for cleaner output

        // FIX 2: Reset the visited array!
        // The previous DFS filled 'vis' with trues. If you reuse it,
        // hasPath will think everything is already visited and return false immediately.
        vis = new boolean[V]; // Re-initialize to all false

        System.out.println("Has path 0 to 5? " + hasPath(graph, 0, 5, vis));

        // Let's test a false case too (e.g., if there were a disconnected node 7)
        // System.out.println(hasPath(graph, 0, 7, new boolean[V]));
    }
}