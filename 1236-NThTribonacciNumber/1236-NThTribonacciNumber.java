// Last updated: 8/11/2026, 2:40:45 PM
class Solution {
    public int tribonacci(int n) {
        if(n==0||n==1)
        return n;
        else if(n==2)
        return 1;
       int  n1=0;
        int n2=1;
        int n3=1;
        int n4=0;
        for(int i=3;i<=n;i++){
            n4=n3+n2+n1;
            n1=n2;
            n2=n3;
            n3=n4;
        }
        return n4;
    }
}