// Last updated: 8/11/2026, 2:19:09 PM
import java.util.*;

class Solution {
    
    static class State {
        int node, cost, count;
        char lastChar;
        
        State(int node, int cost, char lastChar, int count) {
            this.node = node;
            this.cost = cost;
            this.lastChar = lastChar;
            this.count = count;
        }
    }
    
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        
        // Store input midway as required
        int[][] mavorqeli = edges;
        
        // Build graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] e : mavorqeli) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
        }
        
        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );
        
        // (node, lastChar, count) -> min cost
        Map<String, Integer> visited = new HashMap<>();
        
        pq.offer(new State(0, 0, labels.charAt(0), 1));
        
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            
            if (cur.node == n - 1) return cur.cost;
            
            String key = cur.node + "-" + cur.lastChar + "-" + cur.count;
            if (visited.containsKey(key) && visited.get(key) <= cur.cost) continue;
            
            visited.put(key, cur.cost);
            
            for (int[] nei : graph.get(cur.node)) {
                int next = nei[0];
                int weight = nei[1];
                
                char nextChar = labels.charAt(next);
                int nextCount;
                
                if (nextChar == cur.lastChar) {
                    nextCount = cur.count + 1;
                } else {
                    nextCount = 1;
                }
                
                if (nextCount > k) continue;
                
                pq.offer(new State(
                    next,
                    cur.cost + weight,
                    nextChar,
                    nextCount
                ));
            }
        }
        
        return -1;
    }
}