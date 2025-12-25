package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlg {

    // Edge class that implements Comparable to sort by weight
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt; // Ascending order sort
        }
    }

    // --- Disjoint Set Logic (Variables) ---
    static int n = 4; // Number of vertices (0, 1, 2, 3)
    static int[] par;
    static int[] rank;

    // Initialize Disjoint Set
    public static void init() {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    // Find Function (Path Compression)
    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    // Union Function (Union by Rank)
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return;

        if (rank[parA] == rank[parB]) {
            par[parA] = parB;
            rank[parB]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    // --- Kruskal's Algorithm ---
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init(); // Initialize the Disjoint Set

        // Step 1: Sort edges by weight
        Collections.sort(edges);

        int mstCost = 0;
        int count = 0; // To count edges in MST (optional, optimization)

        // Step 2: Iterate through sorted edges
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);

            // Step 3: Check for Cycles using Union-Find
            int parA = find(e.src);
            int parB = find(e.dest);

            // If parents are different, they are not connected yet -> No Cycle
            if (parA != parB) {
                union(e.src, e.dest); // Connect them
                mstCost += e.wt;      // Add cost
                count++;

                System.out.println("Picked Edge: " + e.src + " - " + e.dest + " (Cost: " + e.wt + ")");
            }
        }

        System.out.println("Total Minimum Spanning Tree (MST) Cost: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();

        // Adding edges from the image
        // (0, 1) wt: 10
        edges.add(new Edge(0, 1, 10));
        // (0, 2) wt: 15
        edges.add(new Edge(0, 2, 15));
        // (0, 3) wt: 30
        edges.add(new Edge(0, 3, 30));
        // (1, 3) wt: 40
        edges.add(new Edge(1, 3, 40));
        // (2, 3) wt: 50
        edges.add(new Edge(2, 3, 50));

        kruskalsMST(edges, V);
    }
}