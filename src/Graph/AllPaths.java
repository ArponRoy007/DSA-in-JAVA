package Graph;

import java.util.ArrayList;

public class AllPaths {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    /*
      Graph Structure:
      0 -> 1     1 -> 3
      0 -> 2     2 -> 3
      3 -> 4
      4 -> 5

      Expected Paths from 0 to 5:
      1. 0 -> 1 -> 3 -> 4 -> 5
      2. 0 -> 2 -> 3 -> 4 -> 5
    */
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 5));
    }

    // --- The Main Algorithm ---
    public static void printAllPaths(ArrayList<Edge>[] graph, int curr, int target, String path, boolean[] vis) {
        // Step 1: Base Case - Reached the Target
        if (curr == target) {
            System.out.println(path + target); // Print the full path
            return;
        }

        // Step 2: Mark current node as visited
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Only visit if not already visited in THIS specific path
            if (!vis[e.dest]) {
                vis[curr] = true; // Mark visited

                // Recursion: Add neighbor to path and search deeper
                printAllPaths(graph, e.dest, target, path + curr + " -> ", vis);

                vis[curr] = false; // BACKTRACKING: Unmark to allow this node for other paths
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        int target = 5;

        // We still need a visited array to prevent infinite loops (cycles)
        boolean[] vis = new boolean[V];

        System.out.println("All paths from " + src + " to " + target + ":");
        printAllPaths(graph, src, target, "", vis);
    }
}