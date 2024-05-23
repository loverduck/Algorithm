import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] price;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        price = new int[n][3];
        dp = new int[n][3][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 1000001;
                }
            }
        }

        dp[0][0][0] = price[0][0];
        dp[0][1][1] = price[0][1];
        dp[0][2][2] = price[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Math.min(
                            dp[i - 1][j][(k + 1) % 3] + price[i][k],
                            dp[i - 1][j][(k + 2) % 3] + price[i][k]
                    );
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    result = Math.min(result, dp[n - 1][i][j]);
                }
            }
        }
        System.out.println(result);
    }
}