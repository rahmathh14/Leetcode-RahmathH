// Last updated: 8/27/2026, 11:11:14 AM
1class Solution {
2    public int fib(int n) {
3        if (n <= 1) {
4            return n;
5        }
6
7        int first = 0;
8        int second = 1;
9
10        for (int i = 2; i <= n; i++) {
11            int third = first + second;
12
13            first = second;
14            second = third;
15        }
16
17        return second;
18    }
19}