import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private final List<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
}