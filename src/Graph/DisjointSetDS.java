package Graph;

public class DisjointSetDS {
    static int n = 8;
    static int[] par;
    static int[] rank;

    public static void init() {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) {
            return;
        }

        // Logic adjusted: If ranks are equal, A becomes parent of B
        if (rank[parA] == rank[parB]) {
            par[parB] = parA; // 3 points to 1
            rank[parA]++;     // Rank of 1 increases
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String[] args) {
        init();

        System.out.println("Union(1, 3)");
        union(1, 3);
        // Now 1 should be the parent (leader)
        System.out.println("Parent of 3 is: " + find(3));
        System.out.println("Parent of 1 is: " + find(1));

        System.out.println("-----------------");

        union(2, 4);
        union(3, 6);
        union(1, 4);
        union(1, 5);

        System.out.println("Final Parent of 5: " + find(5));
        System.out.println("Final Parent of 4: " + find(4));
    }
}