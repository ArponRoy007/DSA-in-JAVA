package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // --- Graph 1: A Square (0-1-2-3-0) -> BIPARTITE ---
    public static void createBipartiteGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        // 0 -- 1
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        // 1 -- 2
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        // 2 -- 3
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        // 3 -- 0
        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3));
    }

    // --- Graph 2: A Triangle (0-1-2-0) -> NOT BIPARTITE ---
    public static void createNonBipartiteGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        // 0 -- 1
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        // 1 -- 2
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        // 2 -- 0 (This creates the triangle)
        graph[2].add(new Edge(2, 0));
        graph[0].add(new Edge(0, 2));
    }

    // --- The Main Logic: Check if Bipartite using BFS ---
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        // 'col' array stores colors.
        // -1: No color
        //  0: Yellow
        //  1: Blue
        int[] col = new int[graph.length];

        // Step 1: Initialize all colors to -1 (no color)
        Arrays.fill(col, -1);

        // Step 2: Loop through all nodes (to handle disconnected parts)
        for (int i = 0; i < graph.length; i++) {

            // If the node has no color yet, start BFS
            if (col[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                col[i] = 0; // Assign first color (0) to starting node

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        // Case 1: Neighbor has no color. Give it the OPPOSITE color.
                        if (col[e.dest] == -1) {
                            int nextColor = (col[curr] == 0) ? 1 : 0; //tarnary oparetor
                            col[e.dest] = nextColor;
                            q.add(e.dest);
                        }
                        // Case 2: Neighbor already has the SAME color. Impossible!
                        else if (col[e.dest] == col[curr]) {
                            return false; // Not Bipartite
                        }
                    }
                }
            }
        }
        return true; // If we finish without conflict, it is Bipartite
    }

    public static void main(String[] args) {
        int V = 4; // Use 4 vertices for both examples

        // --- TEST 1: The Bipartite Graph ---
        ArrayList<Edge>[] graph1 = new ArrayList[V];
        createBipartiteGraph(graph1);
        System.out.println("Graph 1 (Square) is Bipartite? " + isBipartite(graph1));
        // Expected: true

        // --- TEST 2: The Non-Bipartite Graph ---
        ArrayList<Edge>[] graph2 = new ArrayList[V];
        createNonBipartiteGraph(graph2);
        System.out.println("Graph 2 (Triangle) is Bipartite? " + isBipartite(graph2));
        // Expected: false
    }
}