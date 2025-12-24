package Graph;

import java.util.ArrayList;

public class BellmanFordAlgo {
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

        // Edges from your image:
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4)); // Negative Weight!

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1)); // Negative Weight!
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src, int V) {
        int[] dist = new int[V];

        // Step 1: Initialize distances to Infinity
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Step 2: Relax all edges (V-1) times
        // Why V-1? Because in worst case, a path takes V-1 edges (like a straight line)
        for (int k = 0; k < V - 1; k++) {

            // Iterate through ALL vertices and ALL their edges
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation Logic:
                    // If we found a shorter path to 'v' through 'u', update it.
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Step 3: Check for Negative Weight Cycle
        // If we can STILL relax an edge after V-1 loops, a negative cycle exists.
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]) {
                    System.out.println("Negative Weight Cycle Detected!");
                    return;
                }
            }
        }

        // Output Final Distances
        System.out.println("Shortest Distances from Source (0):");
        for (int i = 0; i < V; i++) {
            System.out.println("0 to " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        bellmanFord(graph, 0, V);
    }
}