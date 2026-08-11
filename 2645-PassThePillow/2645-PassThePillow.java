// Last updated: 8/11/2026, 2:20:13 PM
class Solution {
    public int passThePillow(int n, int time) {
        int r=time/(n-1);
        int a=time%(n-1);

        return r%2==0? a+1:n-a;
   

    }
}