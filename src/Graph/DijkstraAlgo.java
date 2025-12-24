package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {

    // Edge Class: Connects nodes with a specific weight
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

    // Pair Class: Used in PriorityQueue to store {Node, Distance}
    // Must implement Comparable to tell the Queue to sort by 'dist' (smallest first)
    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist; // Ascending order sorting
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        // 0 -> 1 (Weight 2)
        graph[0].add(new Edge(0, 1, 2));
        // 0 -> 2 (Weight 4) [Direct path is expensive!]
        graph[0].add(new Edge(0, 2, 4));

        // 1 -> 2 (Weight 1) [Shortcut to 2]
        graph[1].add(new Edge(1, 2, 1));
        // 1 -> 3 (Weight 7)
        graph[1].add(new Edge(1, 3, 7));

        // 2 -> 3 (Weight 3) [Better path to 3]
        graph[2].add(new Edge(2, 3, 3));
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src, int V) {
        // Step 1: Distance Array (Initialize with Infinity)
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; // Distance from source to source is always 0

        // Step 2: Priority Queue & Visited Array
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Add source to queue
        pq.add(new Pair(src, 0));

        // Step 3: Process the Queue
        while (!pq.isEmpty()) {
            Pair curr = pq.remove(); // Get node with shortest distance

            if (!vis[curr.node]) {
                vis[curr.node] = true;

                // Loop through neighbors
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // RELAXATION FORMULA:
                    // If (dist to u) + (weight u->v) < (current dist to v)
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt; // Update new shortest distance
                        pq.add(new Pair(v, dist[v])); // Add updated path to queue
                    }
                }
            }
        }

        // Output results
        System.out.println("Shortest distances from Source (0):");
        for (int i = 0; i < V; i++) {
            System.out.println("0 to " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        dijkstra(graph, 0, V);
    }
}