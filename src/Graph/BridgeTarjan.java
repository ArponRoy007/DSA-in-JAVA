package Graph;

import java.util.ArrayList;

public class BridgeTarjan {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Creating the graph from the image
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Left Triangle (0-1-2)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3)); // The connecting edge

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // Right Triangle (3-4-5)
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    // Global timer variable
    public static int time = 0;

    // DFS Algorithm to find Bridges
    public static void dfs(ArrayList<Edge>[] graph, int curr, int par,
                           int[] dt, int[] low, boolean[] vis) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time; // Step 1: Initialize times

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            // Case 1: If neighbor is parent, ignore it (don't go back immediately)
            if (neigh == par) {
                continue;
            }

            // Case 2: If neighbor is visited, it's a "Back Edge"
            // We update our low time based on the neighbor's discovery time
            if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
            // Case 3: If neighbor is not visited, move forward
            else {
                dfs(graph, neigh, curr, dt, low, vis);

                // Upon return, update our low time based on child's low time
                low[curr] = Math.min(low[curr], low[neigh]);

                // *** BRIDGE CHECK ***
                // If the lowest reachable time from neighbor is greater than
                // my discovery time, they can't reach back up past me.
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge found: " + curr + " ----- " + neigh);
                }
            }
        }
    }

    public static void getBridges(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];   // Discovery Time
        int[] low = new int[V];  // Lowest Discovery Time
        boolean[] vis = new boolean[V];
        int time = 0; // Reset time

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                // Start DFS (parent of root is -1)
                dfs(graph, i, -1, dt, low, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        getBridges(graph, V);
    }
}