package Graph;

import java.util.ArrayList;

public class CycleDirected {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // --- Graph 1: Has a Cycle (0 -> 1 -> 2 -> 0) ---
    public static void createGraphWithCycle(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0)); // This creates the cycle!
        graph[2].add(new Edge(2, 3));
    }

    // --- Graph 2: No Cycle (0 -> 1 -> 2 -> 3) ---
    public static void createGraphNoCycle(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3)); // Linear path, no loop back
    }

    // --- Main Function to check for Cycle ---
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] recStack = new boolean[graph.length];

        // Loop through all nodes (to handle disconnected parts)
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCyclicUtil(graph, i, vis, recStack)) {
                    return true; // Cycle found
                }
            }
        }
        return false;
    }

    // --- Recursive Helper (DFS) ---
    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] recStack) {
        vis[curr] = true;
        recStack[curr] = true; // Mark node as part of current path

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 1: If neighbor is already in the recursion stack, it's a cycle!
            if (recStack[e.dest]) {
                return true;
            }

            // Case 2: If neighbor is not visited, go deeper
            if (!vis[e.dest]) {
                if (isCyclicUtil(graph, e.dest, vis, recStack)) {
                    return true;
                }
            }
        }

        recStack[curr] = false; // Backtracking: remove from current path
        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        // --- TEST 1: Graph WITH Cycle ---
        ArrayList<Edge>[] graph1 = new ArrayList[V];
        createGraphWithCycle(graph1);
        System.out.println("Graph 1 (Cycle) result: " + isCyclic(graph1));
        // Expected: true

        // --- TEST 2: Graph WITHOUT Cycle ---
        ArrayList<Edge>[] graph2 = new ArrayList[V];
        createGraphNoCycle(graph2);
        System.out.println("Graph 2 (No Cycle) result: " + isCyclic(graph2));
        // Expected: false
    }
}