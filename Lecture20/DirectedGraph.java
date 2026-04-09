import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Directed graph with BFS and DFS traversal methods.
 */
public class DirectedGraph {
    private final int numVertices;
    private int numEdges;
    private final List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public DirectedGraph(int V) {
        this.numVertices = V;
        this.numEdges = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        numEdges++;
        adj[v].add(w); // Directed edge from v to w
    }

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

        System.out.println("BFS starting from vertex " + s + ":");

        while (!queue.isEmpty()) {
            int v = queue.remove();
            System.out.println("Visited " + v + " (dist " + distTo[v] + ")");
            for (int w : adj[v]) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.add(w);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int s) {
        boolean[] marked = new boolean[numVertices];
        int[] edgeTo = new int[numVertices];
        int[] distTo = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            distTo[i] = -1;
        }

        marked[s] = true;
        distTo[s] = 0;
        dfsHelper(s, marked, edgeTo, distTo);

        System.out.println("DFS starting from vertex " + s + ":");
        for (int v = 0; v < numVertices; v++) {
            if (marked[v]) {
                System.out.println("Visited " + v + " (dist " + distTo[v] + ")");
            }
        }
        System.out.println();
    }

    private void dfsHelper(int v, boolean[] marked, int[] edgeTo, int[] distTo) {
        for (int w : adj[v]) {
            if (!marked[w]) {
                marked[w] = true;
                edgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                dfsHelper(w, marked, edgeTo, distTo);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(numVertices).append(" vertices, ").append(numEdges).append(" edges\n");
        for (int v = 0; v < numVertices; v++) {
            sb.append(v).append(" -> ");
            for (int w : adj[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println(g);
        g.bfs(0);
        g.dfs(0);
    }
}
