package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    // A simple Edge class to represent connections in our graph
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

    // A Pair class to store (vertex, cost) in our Priority Queue.
    // It must implement Comparable so the PQ knows how to sort them by cost.
    static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        public Pair(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }

        // This sorts the pairs so the one with the smallest cost is always first.
        @Override
        public int compareTo(Pair other) {
            return this.cost - other.cost;
        }
    }

    // Method to build the graph from the image
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Edges from the image:
        // 0 is connected to 1, 2, 3
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        // 1 is connected to 0, 3
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        // 2 is connected to 0, 3
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        // 3 is connected to 0, 1, 2
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    // Prim's Algorithm to find the Total MST Cost
    public static void primsAlgo(ArrayList<Edge>[] graph, int V) {
        // To keep track of visited vertices (the MST Set)
        boolean[] vis = new boolean[V];

        // Priority Queue to pick the vertex with the minimum cost edge
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start from vertex 0 with a cost of 0
        pq.add(new Pair(0, 0));

        int totalMstCost = 0; // Variable to store the final answer

        while (!pq.isEmpty()) { //
            // Get the vertex with the smallest cost
            Pair curr = pq.remove();

            // If we have not visited this vertex yet
            if (!vis[curr.vertex]) {
                // 1. Mark it as visited
                vis[curr.vertex] = true;

                // 2. Add its cost to the total MST cost
                totalMstCost += curr.cost;
                System.out.println("Added vertex " + curr.vertex + " with cost " + curr.cost);

                // 3. Add all its unvisited neighbors to the Priority Queue
                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        // Print the final result
        System.out.println("\nTotal Minimum Spanning Tree (MST) Cost: " + totalMstCost);
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices (0, 1, 2, 3)
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        primsAlgo(graph, V);
    }
}