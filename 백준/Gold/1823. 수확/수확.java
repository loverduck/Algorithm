import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] v;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        v = new int[n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(harvest(0, n - 1, 1) + "");
    }

    public static int harvest(int start, int end, int count) {
        if(start > end) return 0;
        if(dp[start][end] != 0) return dp[start][end];

        dp[start][end] = Math.max(
                harvest(start + 1, end, count + 1) + v[start] * count,
                harvest(start, end - 1, count + 1) + v[end] * count
        );
        return dp[start][end];
    }
}
