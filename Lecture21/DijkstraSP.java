import java.util.ArrayList;
import java.util.List;

public class DijkstraSP {
    private final double[] distTo;
    private final DirectedEdge[] edgeTo;
    private final IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        pq = new IndexMinPQ<>(G.V());
        pq.insert(s, distTo[s]);

        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : G.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<DirectedEdge> path = new ArrayList<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.add(0, e);
        }
        return path;
    }
    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(6);
        g.addEdge(new DirectedEdge(0, 1, 7.0));
        g.addEdge(new DirectedEdge(0, 2, 9.0));
        g.addEdge(new DirectedEdge(0, 5, 14.0));
        g.addEdge(new DirectedEdge(1, 2, 10.0));
        g.addEdge(new DirectedEdge(1, 3, 15.0));
        g.addEdge(new DirectedEdge(2, 3, 11.0));
        g.addEdge(new DirectedEdge(2, 5, 2.0));
        g.addEdge(new DirectedEdge(3, 4, 6.0));
        g.addEdge(new DirectedEdge(4, 5, 9.0));

        DijkstraSP sp = new DijkstraSP(g, 0);

        for (int v = 0; v < g.V(); v++) {
            if (sp.hasPathTo(v)) {
                System.out.printf("Shortest path from 0 to %d (%.2f): ", v, sp.distTo(v));
                for (DirectedEdge e : sp.pathTo(v)) {
                    System.out.print(e + "  ");
                }
                System.out.println();
            } else {
                System.out.printf("No path from 0 to %d\n", v);
            }
        }
    }
}
