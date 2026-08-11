// Last updated: 8/11/2026, 2:20:28 PM
class Solution {
    public boolean isSameAfterReversals(int num) {
        int d;
        int ans=0;
        int temp=num;
         if (num==0)
        return true;
         else if(num%10==0||num%100==0)
        return false;
        else 
        return true;
    }
}