package Graph;

import java.util.PriorityQueue;

public class ConnectingCities {

    // Simple class to store in Priority Queue: {node, cost}
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        // Sort by cost (smallest cost first)
        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connectCities(int[][] cities) {
        int V = cities.length; // Number of cities

        // Priority Queue to store {vertex, cost}
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Array to keep track of visited cities
        boolean[] vis = new boolean[V];

        // Start from City 0 with cost 0
        pq.add(new Edge(0, 0));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            // If already visited, skip
            if (vis[curr.dest]) {
                continue;
            }

            // 1. Mark as visited
            vis[curr.dest] = true;

            // 2. Add cost to total
            finalCost += curr.cost;

            // 3. Find neighbors using the 2D Matrix
            // We loop through all possible columns for the current row
            for (int i = 0; i < V; i++) {
                // cities[curr.dest][i] represents weight from 'curr' to 'i'
                // If weight != 0, it means there is an edge.
                if (cities[curr.dest][i] != 0) {
                    if (!vis[i]) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {
        // Input matrix from your image
        int[][] cities = {
                {0, 1, 2, 3, 4},
                {1, 0, 5, 0, 7},
                {2, 5, 0, 6, 0},
                {3, 0, 6, 0, 0},
                {4, 7, 0, 0, 0}
        };

        System.out.println("Minimum Cost to Connect Cities: " + connectCities(cities));
    }
}