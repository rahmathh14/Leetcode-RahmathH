// Last updated: 8/11/2026, 2:19:01 PM
class Solution {
   public boolean checkGoodInteger(int n) {
        int ds=0;
        int ss=0;
        while(n>0){
            int d=n%10;
            ds+=d;
            ss+=d*d;
            n/=10;
        }
        return(ss-ds)>=50;
        
    }
}