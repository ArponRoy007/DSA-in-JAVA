package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Creating the same DAG as before
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // --- Kahn's Algorithm (BFS) ---
    public static void topSort(ArrayList<Edge>[] graph, int V) {
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        // Step 1: Calculate Indegree
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }

        // Step 2: Add nodes with 0 Indegree to Queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: BFS Loop
        System.out.print("Topological Sort (Kahn's): ");
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); // Print the node

            // Reduce indegree of neighbors
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;

                // If neighbor becomes free (0 indegree), add to queue
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        topSort(graph, V);
    }
}