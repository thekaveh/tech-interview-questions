package algoexpert.hard.dijkstras_algorithm;
import java.util.*;

// Approach: Min-heap Dijkstra with VertexInfo wrapper.
class Solution4 {
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int V = edges.length;

        var distTo = new int[V];
        var minPQ = new PriorityQueue<VertexInfo>((a, b) -> a.distance - b.distance);

        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;

        minPQ.add(new VertexInfo(start, 0));

        while (!minPQ.isEmpty()) {
            var v = minPQ.poll().vertex;

            for (var adj : edges[v]) {
                int w = adj[0], vwWeight = adj[1], wDistCandidate = distTo[v] + vwWeight;

                if (distTo[w] > wDistCandidate) {
                    distTo[w] = wDistCandidate;
                    minPQ.add(new VertexInfo(w, distTo[w]));
                }
            }
        }

        for (var v = 0; v < V; v++) {
            if (distTo[v] == Integer.MAX_VALUE) {
                distTo[v] = -1;
            }
        }

        return distTo;
    }

    static class VertexInfo {
        int vertex;
        int distance;

        VertexInfo(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
