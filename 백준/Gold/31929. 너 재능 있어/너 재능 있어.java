import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] winScore, loseScore;
    static int[][] dp;
    static int k;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        winScore = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            winScore[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        loseScore = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            loseScore[i] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());

        dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + winScore[i];
        }
        for (int i = 1; i <= m; i++) {
            if (Math.floorMod(dp[0][i - 1], k) == 0) {
                dp[0][i] = dp[0][i - 1] - loseScore[i];
            } else {
                dp[0][i] = dp[0][i - 1] - Math.min(Math.floorMod(dp[0][i - 1], k), loseScore[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int curWin = dp[i - 1][j] + winScore[i];
                int curLose = dp[i][j - 1];
                if (Math.floorMod(dp[i][j - 1], k) == 0) {
                    curLose -= loseScore[j];
                } else {
                    curLose -= Math.min(Math.floorMod(dp[i][j - 1], k), loseScore[j]);
                }

                dp[i][j] = Math.max(curWin, curLose);
            }
        }
        System.out.println(dp[n][m]);
    }
}
