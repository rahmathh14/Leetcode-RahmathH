// Last updated: 8/16/2026, 8:55:57 AM
1class Solution {
2    public int minPenalty(int p, int[] lights, int[] at) {
3        int m=0;
4        for(int light:lights){
5            m=Math.max(m,light);
6        }
7            int [][]v=new int[][]{lights,at};
8        int ans=0;
9        for(int t:at){
10            int r=t%p;
11            if(r>=m){
12                ans=Math.max(ans,p-r);
13            }
14        }
15           return ans; 
16    }
17}