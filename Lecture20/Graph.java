import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Undirected graph with BFS and DFS traversal methods.
 */
public class Graph {
    private final int numVertices;
    private int numEdges;
    private final List<Integer>[] adj; // adjacency lists

    // init empty graph with V vertices and 0 edges
    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.numVertices = V;
        this.numEdges = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    // adds undirected edge v-w to graph. parallel edges and self-loops allowed
    public void addEdge(int v, int w) {
        numEdges++;
        adj[v].add(w);
        adj[w].add(v);
    }

    // returns vertices adjacent to vertex v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int numVertices() {
        return numVertices;
    }

    public int numEdges() {
        return numEdges;
    }

    public void bfs(int s) {
        boolean[] marked = new boolean[numVertices];
        int[] edgeTo = new int[numVertices];
        int[] distTo = new int[numVertices];

        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        distTo[s] = 0;
        queue.add(s);
        System.out.println("Visited s (dist " + distTo[s] + ")");

        System.out.println("BFS starting from vertex " + s + ":");

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : adj[v]) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.add(w);
                    System.out.println("Visited " + w + " (dist " + distTo[w] + ")");
                }
            }
        }
    }

    public void dfs(int s) {
        boolean[] marked = new boolean[numVertices]; // marked[v] - is there an s-v path?
        int[] edgeTo = new int[numVertices]; // edgeTo[v] = previous vertex on path from s to v
        int[] distTo = new int[numVertices]; // distTo[v] - distance from s to v

        for (int i = 0; i < numVertices; i++) {
            distTo[i] = -1; // initialize distances to -1
        }

        marked[s] = true;
        distTo[s] = 0;
        dfs(s, marked, edgeTo, distTo);

        System.out.println("DFS starting from vertex " + s + ":");
        for (int v = 0; v < numVertices; v++) {
            if (marked[v]) {
                System.out.println("Visited " + v + " (dist " + distTo[v] + ")");
            }
        }
        System.out.println();
    }

    private void dfs(int v, boolean[] marked, int[] edgeTo, int[] distTo) {
        for (int w : adj[v]) {
            if (!marked[w]) {
                marked[w] = true;
                edgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                dfs(w, marked, edgeTo, distTo);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(numVertices).append(" vertices, ").append(numEdges).append(" edges\n");
        for (int v = 0; v < numVertices; v++) {
            sb.append(v).append(": ");
            for (int w : adj[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println(g);

        g.bfs(0);
        g.dfs(0);
    }
}
