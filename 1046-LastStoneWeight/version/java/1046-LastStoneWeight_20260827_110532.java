// Last updated: 8/27/2026, 11:05:32 AM
1import java.util.PriorityQueue;
2
3class Solution {
4    public int lastStoneWeight(int[] stones) {
5        PriorityQueue<Integer> maxHeap =
6            new PriorityQueue<>((a, b) -> b - a);
7
8        for (int stone : stones) {
9            maxHeap.offer(stone);
10        }
11
12        while (maxHeap.size() > 1) {
13            int a = maxHeap.poll();
14            int b = maxHeap.poll();
15
16            if (a != b) {
17                maxHeap.offer(a - b);
18            }
19        }
20
21        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
22    }
23}