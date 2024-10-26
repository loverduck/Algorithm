import java.io.*;
import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int maxT;
        int minT;
        int temp = 0;
        
        if(temperature > t2) {
            maxT = Math.abs(t1 - temperature);
            minT = Math.abs(t2 - temperature);
        } else {
            minT = Math.abs(t1 - temperature);
            maxT = Math.abs(t2 - temperature);
        }
        
        int[][] dp = new int[onboard.length][52];
        for(int i = 0; i < onboard.length; i++) {
            Arrays.fill(dp[i], 100 * 1000);
        }
        dp[0][0] = 0;
        for(int i = 1; i < onboard.length; i++) {
            for(int j = 0; j < 51; j++) {
                
                if(onboard[i] == 1 && (j > maxT || j < minT)) continue;
                
                
                // 온도가 올라온거라면?
                if(0 <= j - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + a);
                }

                // 온도를 유지한거라면
                // 1. 외부 기온이랑 똑같았을수도.
                // 2. 달라서 유지한거일수도
                int min = dp[i - 1][j];
                if(0 != j) {
                    min += b;
                }
                dp[i][j] = Math.min(dp[i][j], min);


                // 온도가 내려간거라면
                // 이건 외부 온도보다 높아야만 가능해.
                if(j + 1 <= maxT) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                }   
            }
        }
        
        
        
        int answer = 100 * 1000;
        for(int j = 0; j < 51; j++) {
            answer = Math.min(answer, dp[onboard.length - 1][j]);
        }
        return answer;
    }
}