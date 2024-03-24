import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();

    private static int[] dp;

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
        dp = new int[10001];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < 10001; i++) {
            dp[i] += 1 + dp[i - 2];
        }
        for (int i = 3; i < 10001; i++) {
            dp[i] += dp[i - 3];
        }

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            output.append(dp[num]).append("\n");
        }
        System.out.println(output);
    }

}
