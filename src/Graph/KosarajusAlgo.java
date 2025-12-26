package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Edges from the image:
        // 0 -> 2, 0 -> 3
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1 -> 0
        graph[1].add(new Edge(1, 0));

        // 2 -> 1
        graph[2].add(new Edge(2, 1));

        // 3 -> 4
        graph[3].add(new Edge(3, 4));
    }

    // Step 1: TopSort (Fill Stack by finishing time)
    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr); // Push to stack after visiting all neighbors
    }

    // Step 3 Helper: Standard DFS for the transposed graph
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V) {
        // --- Step 1: Get nodes in Stack (Topological Sort) ---
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        // --- Step 2: Transpose the Graph ---
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            transpose[i] = new ArrayList<>();
        }

        // Reversing edges: src -> dest becomes dest -> src
        for (int i = 0; i < V; i++) {
            vis[i] = false; // Reset visited array for next step
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // --- Step 3: Do DFS on Transpose Graph using Stack ---
        System.out.println("Strongly Connected Components:");
        while (!s.isEmpty()) {
            int curr = s.pop();

            // If node is not visited in this phase, it's a new SCC
            if (!vis[curr]) {
                dfs(transpose, curr, vis);
                System.out.println(); // Print new line after each component
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        kosaraju(graph, V);
    }
}