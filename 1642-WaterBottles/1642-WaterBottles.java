// Last updated: 8/11/2026, 2:21:50 PM
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int c=0;
       while(numBottles>=numExchange){
        c+=numExchange;
        numBottles -= numExchange;
        numBottles++;
       } 
       return c+numBottles;
    }
}