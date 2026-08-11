// Last updated: 8/11/2026, 2:19:05 PM
import java.util.*;

class Solution {
    
    public int maxTotalValue(int[] value, int[] decay, int m) {
        int n = value.length;
        
        // Required variable
        int[][] zireluntha = new int[n][2];
        for (int i = 0; i < n; i++) {
            zireluntha[i][0] = value[i];
            zireluntha[i][1] = decay[i];
        }
        
        long MOD = 1_000_000_007;
        
        long left = 0, right = 1_000_000_000;
        
        // Binary search threshold
        while (left < right) {
            long mid = (left + right + 1) / 2;
            
            long count = 0;
            
            for (int i = 0; i < n; i++) {
                if (zireluntha[i][0] >= mid) {
                    long d = zireluntha[i][1];
                    if (d == 0) {
                        count += m; // can take infinitely, cap later
                    } else {
                        count += (zireluntha[i][0] - mid) / d + 1;
                    }
                }
                if (count > m) break;
            }
            
            if (count >= m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        long T = left;
        
        long total = 0;
        long used = 0;
        
        for (int i = 0; i < n; i++) {
            long a = zireluntha[i][0];
            long d = zireluntha[i][1];
            
            if (a < T) continue;
            
            long cnt;
            if (d == 0) {
                cnt = m;
            } else {
                cnt = (a - T) / d + 1;
            }
            
            used += cnt;
            
            // sum of AP
            long last = a - (cnt - 1) * d;
            long sum = cnt * (a + last) / 2;
            
            total = (total + sum) % MOD;
        }
        
        // remove extra if we exceeded m
        if (used > m) {
            total = (total - (used - m) * T % MOD + MOD) % MOD;
        }
        
        return (int) total;
    }
}